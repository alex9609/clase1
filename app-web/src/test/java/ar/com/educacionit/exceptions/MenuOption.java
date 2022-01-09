package ar.com.educacionit.exceptions;

import java.util.Scanner;

public class MenuOption {

	public static Integer getMenu() /*throws InvalidMenuException*/{
		

		Scanner teclado = new Scanner(System.in);
		
		Integer op;
	
		System.out.println("Ingrese menu");
		System.out.println("1. Alta");
		System.out.println("2. Baja");
		System.out.println("3. Modificación");
		
		op = teclado.nextInt();
		try {
			if(op != 1 && op !=2 && op != 3) {
				throw new InvalidMenuException(op + " No es valido");
			}
			//Cuando no hay exception que debo controlar no es necesario poner el catch
		}finally {
			teclado.close();
		}
		
		return op;
	}
}
