package ar.com.educacionit.web.practicaAdicionalSemana15;

public class ValidateSemana15 {
	
	//Dado unos datos -> Validar si los datos son correctos devolviendo un objeto
	//Si los datos son incorrectos devolver un mensaje que diga error
	//Se puede hacer uso de las clases genericas
	
	public static String validarDatos(String documento,String nombre, String apellido, String edad, String ocupacion, String fechaNacimiento) {
		String validado = "Dato no validado ";
		
		//Validar con expresiones regulares un campo
		if(nombre.length() > 10 || nombre.isEmpty()) {
			validado = "El campo nombre es invalido";
		}else if(apellido.length()>10 || apellido.isEmpty()) {
			validado = "El campo apellido es invalido";
		}else if(ocupacion.length()>10 || ocupacion.isEmpty()) {
			validado = "El campo ocupacion es invalido";
		}
		
		validado = validarLong(edad);
		
		validado = validarLong(documento);
		
		return validado;
	}
	
	private static String validarLong(String valor) {
		String mensaje = "correcto";
		try {
			Long age = Long.parseLong(valor);
		}catch(Exception e){
			mensaje = "El campo edad es invalido";
		}
		return mensaje;
		
	}

}
