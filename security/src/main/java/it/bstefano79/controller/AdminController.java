package it.bstefano79.controller;

import java.util.List;
import java.util.Map;

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
import it.bstefano79.dto.FigurineTypesDto;
import it.bstefano79.service.AlbumService;
import it.bstefano79.service.FigurineService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private FigurineService figurineService;
	
	/*aggiungere i servizi importante
	vedere questo per salvare + entity
	https://roytuts.com/spring-data-jpa-batch-insertion/*/
	
	@PostMapping("adds/figurine/{idalbum}/{from}/{to}")
	public ResponseEntity<?> getById(@PathVariable Integer idalbum,
			@PathVariable Integer from,
			@PathVariable Integer to) {
		AlbumDto album = albumService.findById(idalbum);
		if(album!=null) {
			figurineService.addsFigurineByAlbum(from, to, album);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
		            "message", "Figurine da "+from+" al "+to+" aggiunte all'Album con id "+idalbum));
		}else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
		            "message", "Album con id "+idalbum+" non trovato!"));
				
	}
	
	@GetMapping("figurine/getalltypes")
	public List<FigurineTypesDto> getAllTypesFigurine(){
		return figurineService.returnAllTypes();
	}
	
	@PostMapping("add")
	public ResponseEntity<?> newAlbum(@Valid @RequestBody AlbumDto albumDto) {
		this.albumService.newAlbum(albumDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "message", "Album salvato con successo!"));
	}
}
