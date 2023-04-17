package it.bstefano79.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bstefano79.entity.Album;
import it.bstefano79.repository.AlbumRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	/*aggiungere i servizi importante
	vedere questo per salvare + entity
	https://roytuts.com/spring-data-jpa-batch-insertion/*/
	
	@GetMapping("adds/figurine/{idalbum}/{from}/{to}")
	public ResponseEntity<?> getById(@PathVariable Integer idalbum,
			@PathVariable Integer from,
			@PathVariable Integer to) {
		Album album = albumRepository.findById(idalbum).orElse(null);
		if(album!=null) {
			return null;
		}else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
		            "message", "Album con id "+idalbum+" non trovato!"));
				
	}
}
