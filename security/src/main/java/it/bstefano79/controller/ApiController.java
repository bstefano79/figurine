package it.bstefano79.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bstefano79.config.jwt.JwtUtils;
import it.bstefano79.user.details.services.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@GetMapping(path = "/public", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> allAccess(HttpServletRequest request) {
		String jwt = jwtUtils.getJwtFromCookies(request);
		UserDetails userDetails=null;
	    if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
	    	String username = jwtUtils.getUserNameFromJwtToken(jwt);
	      

	        userDetails = userDetailsService.loadUserByUsername(username);
	    }
	    String message = "Questo end-point non ha bisogno dell'autorizzazione";
	    if(userDetails==null)
	    {
	    	message+=" non sei loggato";
	    }else {
	    	message+=" sei loggato come "+userDetails.getUsername();
	    }
		return ResponseEntity.status(HttpStatus.OK).body(Map.of(
	            "message", message));
	}
	
	@GetMapping(path = "/public/404", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> error404() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
	            "message", "Errore questa risorsa non sembra esistere"));
	}
	
}
