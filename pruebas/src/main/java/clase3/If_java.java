package clase3;

import java.util.Scanner;

public class If_java {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese una edad");
		
		int edad = teclado.nextInt();
		
		if(edad>=18) {
			System.out.println("Es mayor edad");
		}else {
			System.out.println("Es menor de edad");
		}
		
	}

}
