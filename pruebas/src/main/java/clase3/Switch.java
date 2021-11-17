package clase3;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese una opción");
		int opcion = teclado.nextInt();
		
		switch(opcion) {
		case 1:
			System.out.println("Un valor de "+ opcion);
		break;
		case 2:
			System.out.println("Un valor de "+ opcion);
		break;
		case 3:
			System.out.println("Un valor de "+ opcion);
		break;
		case 4:
			System.out.println("Un valor de "+ opcion);
		break;
		case 5:
			System.out.println("Un valor de "+ opcion);
		break;
		default:
			System.out.println("Ningún valor ha sido seleccionado");
		}
	}

}
