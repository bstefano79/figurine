package it.bstefano79.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bstefano79.dto.AlbumDto;
import it.bstefano79.dto.FigurineTypesDto;
import it.bstefano79.entity.Album;
import it.bstefano79.entity.FigurineAlbum;
import it.bstefano79.repository.AlbumRepository;
import it.bstefano79.repository.FigurineTypesRepository;

@Service
public class FigurineService {
	@Autowired
	AlbumRepository albumRepository;
	
	@Autowired
	FigurineTypesRepository figurineTypesRepository;
	
	public void addsFigurineByAlbum(int from,int to, AlbumDto albumDto){
		FigurineAlbum fig = new FigurineAlbum();
		Album album = albumRepository.findById(albumDto.getId()).
				orElseThrow(() -> new RuntimeException("Error: Album con id "+albumDto.getId()+" non trovato!"));

		fig.setAlbum(album);
	}
	
	public List<FigurineTypesDto> returnAllTypes(){
		return figurineTypesRepository.findAll().stream().map(t->new FigurineTypesDto(t)).toList();
	}
}
