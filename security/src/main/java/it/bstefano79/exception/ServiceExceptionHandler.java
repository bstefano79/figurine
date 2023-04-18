package it.bstefano79.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler  {

  @ExceptionHandler(value = {FigurineRuntimeException.class })
  public ResponseEntity<Object> unknownException(Exception ex, WebRequest req) {
    
    ex.printStackTrace();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "message", ex.getMessage(), "eorror", "qualcosa è andato storto", "status", HttpStatus.BAD_REQUEST));
  }
}
