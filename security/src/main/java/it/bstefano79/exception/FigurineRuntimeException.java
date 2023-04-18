package it.bstefano79.exception;

import org.springframework.http.HttpStatus;


public class FigurineRuntimeException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpStatus status;
	public FigurineRuntimeException() {
        super();
    }
    public FigurineRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
    public FigurineRuntimeException(String message, HttpStatus status) {
        super(message);
        this.status=status;
    }
    public FigurineRuntimeException(String message) {
        super(message);
    }
    public FigurineRuntimeException(Throwable cause) {
        super(cause);
    }
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}