package ar.com.educacionit.exceptions;

import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.domain.Socios;

public class MiPrimerExceptionMain {

	public static void main(String[] args) {
		
		//jvm  > errores unchecked 
		//excepciones no contraladas - el programador
		//no debe preocuparse
		
		//Errores en tiempo de compilación
		
		/*
		int a = 10;
		//Error int b = 0;
		int b = 0;
		int c = a/b;
		//Corta el programa
		System.out.println(c);
		
		
		//Ejemplo con objetos
		// Error Socios s = null;
		Socios s = new Socios();
		Long id = s.getId(); //java.lang.NullPointerException
		System.out.println(id);
		
		//Para resolver el anterior debemos instanciar para
		//que el objeto deje de ser nulo
		
		//Herencia / Interfaces
		
		Object socio = new Socios();
		//Intentar hacer un downCasting
		Categorias cat = (Categorias)socio;  // java.lang.ClassCastException
		
		//Tengo una clase de un tipo y la quiero castear a otro tipo
		//y no hay una linea de herencia para poder hacerlo
		System.out.println(cat.getCodigo());
	
		/*
		Object socio = new Socios();
		Entity soc = (Entity)socio;   - Aquí si podemos hacerlo ya que Socios implementa de entity
		System.out.println(soc.getId());
		*/
		
		//Cuando la clase no implementa la interfaz y se quiere hacer un casteo sobre
		//está interfaz nos arrojará un error 
		
		/***************************************/
		
		// Errores de tipo checked exception
		
		//JVM > Obliga al programador a controlar las "checked exception"
		
		//Errores en tiempo de ejecucion
		//Se da cuando estamos escribiendo el codigo
		//no deja compilar el programa y obliga a utilizar el try catch
		
		int c = 0;
		try {
			metodoConException(c);
		}catch(Exception nombre) {
			nombre.printStackTrace();
			//printStackTrace - Nos arroja cual fue el error
		}
		
		
		
	}
	
	public static void metodoConException(int valor)  throws Exception{
		
		if(valor == 0 ) {
			//Lanzo una nueva exception
			throw new Exception("El valor es erroneo");
		}
		
		metodoB();
		
	}
	
	public static void metodoB() throws Exception{
		
	}

}
