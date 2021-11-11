package pruebas;

import java.util.Scanner;

public class LecturaDatos {

	public static void main(String[] args) {
		
		//Aquí le estoy diciendo que voy a leer desde el teclado
		Scanner lectura = new Scanner(System.in);
		System.out.println("Escriba su nombre por favor: ");
		String nombre = lectura.nextLine();
		System.out.println(nombre);
	}

}
