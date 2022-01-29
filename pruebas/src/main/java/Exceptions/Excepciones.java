package Exceptions;

public class Excepciones {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 10;
		/*
		if(a == 0) { //El throw frena el programa y me envia el mensaje de error
			throw new ArithmeticException ("No se puede dividir por cero");
		}
		*/
		
		try {
			int c = b/a;
			System.out.println(c);
		}catch(ArithmeticException e){
			System.out.println(e.getMessage()); //Imprime el mensaje de error
			e.printStackTrace();
			//throw new ArithmeticException ("No se puede dividir por cero");
		}
		
		//Con el try catch garantizamos que el programa siga ejecutandose
		//Con el throw paramos el programa y obtenemos el mensaje de error escrito previamente
		System.out.println("Esto es despues de la exception");
	}

}
