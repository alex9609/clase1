package clase6MercadoLibrePOO;

import java.util.Scanner;

public class BuscadorMain {

	public static void main(String[] args) {
		
		String palabra_clave;
		
		Scanner teclado = new Scanner (System.in);
		System.out.println("Ingrese el valor a buscar: ");
		
		palabra_clave = teclado.nextLine();
		
		Buscador nueva_busqueda = new Buscador(palabra_clave);
		
		nueva_busqueda.buscar();
		
		
		
		
		teclado.close();
		
		
	}

}
