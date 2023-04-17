package it.bstefano79.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bstefano79.dto.AlbumDto;
import it.bstefano79.entity.Album;
import it.bstefano79.entity.FigurineAlbum;
import it.bstefano79.repository.AlbumRepository;

@Service
public class FigurineService {
	@Autowired
	AlbumRepository albumRepository;
	
	public void addsFigurineByAlbum(int from,int to, AlbumDto albumDto){
		FigurineAlbum fig = new FigurineAlbum();
		Album album = albumRepository.findById(albumDto.getId()).
				orElseThrow(() -> new RuntimeException("Error: Album con id "+albumDto.getId()+" non trovato!"));

		fig.setAlbum(album);
	}
}
