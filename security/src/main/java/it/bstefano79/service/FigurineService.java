package it.bstefano79.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bstefano79.dto.AlbumDto;
import it.bstefano79.dto.FigurineTypesDto;
import it.bstefano79.entity.Album;
import it.bstefano79.entity.FigurineAlbum;
import it.bstefano79.entity.FigurineTypes;
import it.bstefano79.exception.FigurineRuntimeException;
import it.bstefano79.repository.AlbumRepository;
import it.bstefano79.repository.FigurineAlbumRepository;
import it.bstefano79.repository.FigurineTypesRepository;

@Service
public class FigurineService {
	@Autowired
	AlbumRepository albumRepository;
	
	@Autowired
	FigurineTypesRepository figurineTypesRepository;
	
	@Autowired
	FigurineAlbumRepository figurineAlbumRepository;
	
	public void addsFigurineByAlbum(int from,int to, AlbumDto albumDto){
		if(from>=to)
			throw new FigurineRuntimeException("Error: "+from+" >= "+to);
		FigurineTypes figType =figurineTypesRepository.getTypeDefault().orElseThrow(
				()->new FigurineRuntimeException("Non ho trovato il tipo figurina di default"));
		addsFigurineTypeByAlbum(figType, from, to, albumDto);
	}
	
	public void addsFigurineTypeByAlbum(String type, int from,int to, AlbumDto albumDto){
		if(from>=to)
			throw new FigurineRuntimeException("Error: "+from+" >= "+to);
		FigurineTypes figType = figurineTypesRepository.findById(type).
				orElseThrow(() -> new FigurineRuntimeException("Non ho trovato il tipo figurina "+type));
		addsFigurineTypeByAlbum(figType, from, to, albumDto);
		
	}
	
	private void addsFigurineTypeByAlbum(FigurineTypes figType, int from,int to, AlbumDto albumDto){
		Album album = albumRepository.findById(albumDto.getId()).
				orElseThrow(() -> new FigurineRuntimeException("Error: Album con id "+albumDto.getId()+" non trovato!"));
		List<FigurineAlbum> lista = new ArrayList<FigurineAlbum>();
		for(Integer i=from; i<=to;i++) {
			FigurineAlbum fig = new FigurineAlbum();	
			fig.setAlbum(album);
			fig.setFigurineTypes(figType);
			fig.setValue(i.toString());
			lista.add(fig);
		}
		figurineAlbumRepository.saveAll(lista);
	}
	
	public List<FigurineTypesDto> returnAllTypes(){
		return figurineTypesRepository.findAll().stream().map(t->FigurineTypesDto.fromFigurineTypes(t)).toList();
	}
}
