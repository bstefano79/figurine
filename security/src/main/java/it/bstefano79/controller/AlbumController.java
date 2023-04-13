package it.bstefano79.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bstefano79.entity.Album;
import it.bstefano79.repository.AlbumRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/album")
public class AlbumController {
	@Autowired
	private AlbumRepository albumRepository;
	
	@GetMapping("/")
	public List<Album> privateAccess() {
		return albumRepository.findAll();
	}
}
