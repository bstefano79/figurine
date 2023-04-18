package it.bstefano79.exception;


public class FigurineRuntimeException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FigurineRuntimeException() {
        super();
    }
    public FigurineRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
    public FigurineRuntimeException(String message) {
        super(message);
    }
    public FigurineRuntimeException(Throwable cause) {
        super(cause);
    }
}