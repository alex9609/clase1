package ar.com.educacionit.collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CollectionMain {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese una opcion");
		String opcion = teclado.next();
		
		String uno = "Alex";
		String dos = "Alex";
		
		
		Set<String> valores = new HashSet<>();
		
		valores.contains(uno);
		
		
		System.out.println(uno.hashCode());
		System.out.println(dos.hashCode());
		
		System.out.println(uno.equals(dos));
		
		//Un entry es el par 
		
		
		
	}
}
