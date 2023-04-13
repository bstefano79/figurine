package it.bstefano79.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<Object> privateAccess() {
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "message", "Questo end-point è privato hai l'autorizzazione"));
	}
	
	@GetMapping(path = "/public", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> allAccess() {
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "message", "Questo end-point non ha bisogno dell'autorizzazione"));
	}
	
}
