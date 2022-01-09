package ar.com.educacionit.exceptions;

public class CommitException extends RuntimeException {

	public CommitException(String message) {
		super(message);
	}

	
	//Las runtime se hacen cuando quiero que el programa
	//no avance, ya que yo quiero que si algo falla en el programa no se 
	//siga compilando
}
