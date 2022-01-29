package ar.com.educacionit.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

public class MinCollection3 {

	public static void main(String[] args) {

		Set<Cliente> clientes = new HashSet<>();
		

		Cliente c1 = new Cliente("asd","Alex");
		Cliente c2 = new Cliente("asd","Camilo");
		
		System.out.println(clientes.add(c1));
		System.out.println(clientes.add(c2));
		
		
		for(Cliente cl: clientes) {
			System.out.println(cl.getDni() + " " + cl.getNombre());
		}

		

		
		
	}

}
