package ar.com.educacionit.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapStringMain2 {
	public static void main(String[] args) {
		
		//que pasa si por teclado le doy enter
		Scanner teclado = new Scanner(System.in);
		
		Map<String,Integer> dias = new HashMap<>();
		System.out.println(dias);
		
		String nombre = "";
		do {
			System.out.println("Ingrese nombres");
			nombre = teclado.next();
			
			if(!nombre.equalsIgnoreCase("fin")) {
				if(dias.containsKey(nombre)) {
					Integer value = dias.get(nombre);
					value++;
					dias.put(nombre, value);
				}else {
					dias.put(nombre, 1);
				}
			}
		}while(!nombre.equalsIgnoreCase("fin"));
		
		System.out.println(dias);
		
		
		System.out.println("Ingrese nombre a eliminar");
		nombre = teclado.next();
		
		//Elimina la clave valor de acuerdo a su clave
		if(dias.containsKey(nombre)) {
			dias.remove(nombre);
		}else {
			System.out.println("No existe " + nombre);
		}
		System.out.println(dias);
		
	}

}
