package ar.com.educacionit.dao.exceptions;

public class GenericException extends Exception{

	public GenericException(String message) {
		super(message);
	}
	
	public GenericException(String msj,Throwable source) {
		super(msj,source);
	}
	
}
