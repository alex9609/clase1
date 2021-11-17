package clase4;

import java.util.Scanner;

public class Do_while {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String[] valores = {};
		int tamanio;
		
		System.out.println("Ejemplo de un DO_WHILE");
		do {
			System.out.println("Ingrese la cantidad de valores que desea registrar");
			tamanio = teclado.nextInt();
		}while(tamanio<=0);
		
		valores = new String[tamanio];
		
		//For para ingresar todos los datos
		for(int i = 0;i<tamanio;i++) {
			System.out.println("Ingresa el nombre del pais");
			valores[i] = teclado.next();
		}
		
		//For each 
		
		for(String pais: valores) {
			System.out.println(pais);
		}
		
		teclado.close();
		
	}

}
