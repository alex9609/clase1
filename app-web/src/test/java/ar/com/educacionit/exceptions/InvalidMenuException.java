package ar.com.educacionit.exceptions;

public class InvalidMenuException extends RuntimeException {
	
	public InvalidMenuException(String msj) {
		super(msj);
	}
}
