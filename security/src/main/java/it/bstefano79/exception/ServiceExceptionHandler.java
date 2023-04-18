package it.bstefano79.exception;

import java.util.Map;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler  {

  @ExceptionHandler(value = {FigurineRuntimeException.class })
  public ResponseEntity<Object> unknownException(Exception ex, WebRequest req) {
    
    ex.printStackTrace();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "message", ex.getMessage(), "eorror", "qualcosa è andato storto", "status", HttpStatus.BAD_REQUEST));
  }
  
  @Nullable
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {

		if (request instanceof ServletWebRequest servletWebRequest) {
			HttpServletResponse response = servletWebRequest.getResponse();
			if (response != null && response.isCommitted()) {
				if (logger.isWarnEnabled()) {
					logger.warn("Response already committed. Ignoring: " + ex);
				}
				return null;
			}
		}

		if (statusCode.equals(HttpStatus.INTERNAL_SERVER_ERROR)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}

		if (body == null && ex instanceof ErrorResponse errorResponse) {
			body = errorResponse.updateAndGetBody(super.getMessageSource(), LocaleContextHolder.getLocale());
		}

		return createResponseEntity(body, headers, statusCode, request);
	}
  
  protected ResponseEntity<Object> createResponseEntity(
			@Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {

	  if(body instanceof ProblemDetail) {
		  ((ProblemDetail) body).setProperty("error","si è verificato un errore");
	  }
		return new ResponseEntity<>(body, headers, statusCode);
	}
}
