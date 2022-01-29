package ar.com.educacionit.collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class MainCollection2 {

	public static void main(String[] args) {
		
		LinkedList<String> nombres = new LinkedList<>();
		
		nombres.addFirst("Alex");
		nombres.add("Camilo");
		nombres.add("Aleja");
		
		
		//Interar una linked list
		ListIterator<String> li = nombres.listIterator();

		
		//Como recorrer un list iterator
		
		while(li.hasNext()) {
			String elemento = li.next();
			System.out.println(elemento);
		}
		
		while(li.hasPrevious()) {
			String elemento = li.previous();
			System.out.println(elemento);
		}
	}

}
