package clase4;

import java.util.Arrays;

public class Cuentas {

	public static void main(String[] args) {
		String[] archivo = new String[] {
				"1500; Alex Rodriguez;2000;ca",
				"1501; Juan Ramirez;3000;cc",
				"1502; Raul Jimenez;2050;ca",
				"1503; David Prez;400000;cc",
				"1504; Xavi Alonzo;5000;ca"};
		
		//Separar por ;
		

		
		for(String dato:archivo) {
			String[] cuenta = dato.split(";");
			Integer numerocuenta = Integer.parseInt(cuenta[0]);
			String nombre = cuenta[1];
			Integer saldo = Integer.parseInt(cuenta[2]);
			String tipoCuenta = cuenta[3];
			System.out.println(Arrays.toString(cuenta));
			System.out.println(numerocuenta);
			System.out.println(nombre);
			System.out.println(saldo);
			System.out.println(tipoCuenta);
			System.out.println("--------------");
		}
	}

}
