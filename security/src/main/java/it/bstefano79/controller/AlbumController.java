package it.bstefano79.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bstefano79.dto.AlbumDto;
import it.bstefano79.dto.AlbumWhitFigurineDto;
import it.bstefano79.exception.FigurineRuntimeException;
import it.bstefano79.service.AlbumService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/album")
public class AlbumController {
	@Autowired
	private AlbumService albumService;
	
	@GetMapping("/")
	public List<AlbumDto> getAlbum() {
		return albumService.findAll();
	}
	
	@GetMapping("/withfigurines")
	public List<AlbumWhitFigurineDto> getAlbumWithFigurines() {
		return albumService.findAllWithFigurines();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		AlbumDto album = albumService.findById(id);
		if(album!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(album);
		}
		throw new FigurineRuntimeException("Album con id "+id+" non trovato!!!!!!!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}/withfigurines")
	public ResponseEntity<?> getByIdWithFigurines(@PathVariable Integer id) {
		AlbumDto album = albumService.findByIdWithFigurines(id);
		if(album.getId()!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(album);
		}
		throw new FigurineRuntimeException("Album con id "+id+" non trovato!!!!!!!", HttpStatus.NOT_FOUND);		
	}
}
