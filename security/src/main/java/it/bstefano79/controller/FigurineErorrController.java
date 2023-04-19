package it.bstefano79.controller;

import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.bstefano79.exception.FigurineRuntimeException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FigurineErorrController implements ErrorController{
	@RequestMapping("/api/public/error")
	public ResponseEntity<?> erorr(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);	
		 if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	throw new FigurineRuntimeException("Questa risorsa non sembra esistere", HttpStatus.NOT_FOUND);
	        }else if(statusCode == HttpStatus.FORBIDDEN.value()) {
	        	throw new FigurineRuntimeException("Non hai i permessi per usare questa risorsa", HttpStatus.FORBIDDEN);
	        }
	       
		 }
		 
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
	        		"message", "Errore Generico","eorror", "qualcosa è andato storto", "status", HttpStatus.BAD_REQUEST));
	}
}
