package it.bstefano79.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bstefano79.config.jwt.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@GetMapping(path = "/public", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> allAccess(HttpServletRequest request) {
		String jwt = jwtUtils.getJwtFromCookies(request);
		String username=null;
		Long id=null;
	    if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
	    	username = jwtUtils.getUserNameFromJwtToken(jwt);
	        id = jwtUtils.getIdUserFromJwtToken(jwt);
	    }
	    String message = "Questo end-point non ha bisogno dell'autorizzazione";
	    if(username==null)
	    {
	    	message+=" non sei loggato";
	    }else {
	    	message+=" sei loggato come "+username+" con id "+id;
	    }
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "message", message));
	}
}
