package it.bstefano79.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.bstefano79.dto.AlbumDto;
import it.bstefano79.dto.FigurineTypesDto;
import it.bstefano79.exception.FigurineRuntimeException;
import it.bstefano79.service.AlbumService;
import it.bstefano79.service.FigurineService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminAlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	/*@Autowired
	private FigurineService figurineService;*/
	
	/*aggiungere i servizi importante
	vedere questo per salvare + entity
	https://roytuts.com/spring-data-jpa-batch-insertion/*/
	
	
	@PostMapping("album/add")
	public ResponseEntity<?> newAlbum(@Valid @RequestBody AlbumDto albumDto) {
		this.albumService.newAlbum(albumDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "message", "Album salvato con successo!"));
	}
	
	@PutMapping("album/update/field/{id}/{fieldName}")
    public ResponseEntity<?> updateAlbumField(
            @PathVariable Long id,
            @PathVariable String fieldName,
            @RequestBody String fieldValue) {
        albumService.updateAlbumField(id, fieldName, fieldValue);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "message", "Field "+fieldName+" modificato con successo"));
    }
	
	@PostMapping("album/update")
	public ResponseEntity<?> updateAlbum(@Valid @RequestBody AlbumDto albumDto) {
		this.albumService.updateAlbum(albumDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "message", "Album modificato con successo!"));
	}
}
