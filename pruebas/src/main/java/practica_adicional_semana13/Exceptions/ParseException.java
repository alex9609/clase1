package practica_adicional_semana13.Exceptions;

public class ParseException extends Exception{

	public ParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParseException(String message) {
		super(message);
	}

	
}
