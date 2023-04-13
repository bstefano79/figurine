package it.bstefano79.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bstefano79.dto.AlbumDto;
import it.bstefano79.entity.Album;
import it.bstefano79.entity.AlbumType;
import it.bstefano79.models.EAlbumType;
import it.bstefano79.repository.AlbumRepository;
import it.bstefano79.repository.AlbumTypeRepository;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/album")
public class AlbumController {
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private AlbumTypeRepository albumTyRepository;
	
	@GetMapping("/")
	public List<Album> getAlbum() {
		return albumRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		Album album = albumRepository.findById(id).orElse(null);
		if(album!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(album);
		}else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
		            "message", "Album con id "+id+" non trovato!"));
				
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> newAlbum(@Valid @RequestBody AlbumDto albumDto) {
		Album album = new Album(albumDto.getName());
		
		List<String> strTypes = albumDto.getTypes();
		Set<AlbumType> types = new HashSet<>();
		
		if (strTypes == null || strTypes.size()==0) {
			AlbumType albumType = albumTyRepository.findByName(EAlbumType.GENERICO)
					.orElseThrow(() -> new RuntimeException("Error: Album Type is not found."));
			types.add(albumType);
		}else {
			strTypes.forEach(type -> {
				AlbumType albumType = albumTyRepository.findByName(type)
						.orElseThrow(() -> new RuntimeException("Error: Album Type is not found."));
				types.add(albumType);
			});
		}
		album.setTypes(types);
		albumRepository.save(album);
		
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "message", "Album salvato con successo!"));
	}
}
