package pruebas;

public class OperadoresJava {

	public static void main(String[] args) {
		
		/*
		 
		 + Suma
		 * Multiplicacion
		 / Division 
		  - Resta
		 */
		
		int edad1 = 10;
		int edad2 = 20;
		int res = edad1 + edad2;
		
		//Con ctrl + D borro una linea de codigo
		
		String nombre = "carlos";
		String apellido = "lopez";
		String res1 = nombre + apellido;
		System.out.println( "Hola soy una cadena " + res1);
		
		//Para hacer una divisio puedo usar un valor o float o double
		int alto = 35;
		int ancho = 40;
		double resultado = alto/ancho;
		
		//Valores por referencia
		/*
		 byte -127 hasta 128
		 short -32.768 hasta 32.768
		 int -2^31  hasta 2^31
		 long -2^63 hasta 2^63
		 
		 * 
		 */
		
		//Division /
		double altoo = 20;
		double div0 = (float)altoo/0;
		
		System.out.println(div0);
		
		
		boolean aux = true;
		boolean baux = true;
		boolean reaux = aux ^ baux;
		System.out.println(reaux);
		
		
		//Operador ternario
		//Condicion ? valor si verdad : valor si falso
		byte c = false ? 1:0;
		System.out.println(c);
	}

}
