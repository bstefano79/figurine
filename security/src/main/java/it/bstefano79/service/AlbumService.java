package it.bstefano79.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bstefano79.dto.AlbumDto;
import it.bstefano79.dto.AlbumTypeDto;
import it.bstefano79.dto.AlbumWhitFigurineDto;
import it.bstefano79.entity.Album;
import it.bstefano79.entity.AlbumType;
import it.bstefano79.exception.FigurineRuntimeException;
import it.bstefano79.repository.AlbumRepository;
import it.bstefano79.repository.AlbumTypeRepository;
import it.bstefano79.repository.FigurineAlbumRepository;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private AlbumTypeRepository albumTypeRepository;
	
	@Autowired
	private FigurineAlbumRepository figurineAlbumRepository;
	
	public List<AlbumDto> findAll() {
		return albumRepository.findAll().stream().map(x -> AlbumDto.fromAlbum(x)).toList();
	}
	
	public List<AlbumWhitFigurineDto> findAllWithFigurines() {
		List<AlbumWhitFigurineDto> pippo= albumRepository.findAll().stream().map(x -> new AlbumWhitFigurineDto(x,figurineAlbumRepository.findAllByIdAlbum(x.getId()))).toList();
		return pippo;
	}
	
	public AlbumDto findById(Integer id){
		Album album = albumRepository.findById(id).orElse(null);
		if(album==null) return null;
		return AlbumDto.fromAlbum(album);
	}
	
	public AlbumWhitFigurineDto findByIdWithFigurines(Integer id){
		return new AlbumWhitFigurineDto(albumRepository.findById(id).orElse(null),figurineAlbumRepository.findAllByIdAlbum(id));
	}
	
	
	public Optional<AlbumType> findAlbumTypeFromName(String name){
		return albumTypeRepository.findByName(name);
	}
	
	public void updateAlbum(AlbumDto albumDto) {
		Album albumDb = albumRepository.findById(albumDto.getId()).orElseThrow(() -> new FigurineRuntimeException("Error: Album not found id="+albumDto.getId()));
		albumDb = AlbumDto.toAlbum(albumDto);
		save(albumDb);
	}
	
	public void newAlbum(AlbumDto albumDto){
		this.save(AlbumDto.toAlbum(albumDto));
	}
	
	public void save(Album album){
		albumRepository.save(album);
	}
}
