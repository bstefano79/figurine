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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bstefano79.dto.AlbumDto;
import it.bstefano79.dto.FigurineTypesDto;
import it.bstefano79.exception.FigurineRuntimeException;
import it.bstefano79.service.AlbumService;
import it.bstefano79.service.FigurineService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminFigurineController {
	
	@Autowired
	private FigurineService figurineService;
	
	@Autowired
	private AlbumService albumService;
	
	@PostMapping("adds/figurine/{idalbum}/{from}/{to}")
	public ResponseEntity<?> addFigurineFromTo(@PathVariable Integer idalbum,
			@PathVariable Integer from,
			@PathVariable Integer to) {
		AlbumDto album = albumService.findById(idalbum);
		if(album!=null) {
			figurineService.addsFigurineByAlbum(from, to, album);
			return ResponseEntity.status(HttpStatus.OK).body(Map.of(
		            "message", "Figurine da "+from+" al "+to+" aggiunte all'Album con id "+idalbum));
		}
		throw new FigurineRuntimeException("Album con id "+idalbum+" non trovato!!!!!!!", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("adds/figurine/{idalbum}/{type}/{from}/{to}")
	public ResponseEntity<?> addFigurineTypesFromTo(@PathVariable Integer idalbum,
			@PathVariable String type,
			@PathVariable Integer from,
			@PathVariable Integer to) {
		AlbumDto album = albumService.findById(idalbum);
		if(album!=null) {
			figurineService.addsFigurineTypeByAlbum(type, from, to, album);
			return ResponseEntity.status(HttpStatus.OK).body(Map.of(
		            "message", "Figurine del tipo "+type+" da "+from+" al "+to+" aggiunte all'Album con id "+idalbum));
		}
		throw new FigurineRuntimeException("Album con id "+idalbum+" non trovato!!!!!!!", HttpStatus.NOT_FOUND);
				
	}
	
	@GetMapping("figurine/getalltypes")
	public List<FigurineTypesDto> getAllTypesFigurine(){
		return figurineService.returnAllTypes();
	}

}
