package it.bstefano79.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class HomeController {

	@GetMapping("/")
	  public String privateAccess() {
	    return "Private Content.";
	  }
	
	@GetMapping("/public")
	  public String allAccess() {
	    return "Public Content.";
	  }
	
	@GetMapping("/public/prova")
	  public String allAccessProva() {
	    return "Public PROVA Content.";
	  }
}
