package Casteo_ArrayList_Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CasteoArraySet {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		ArrayList<String> nombre = new ArrayList<String>();
		
		
		nombre.add("Alex");
		nombre.add("Alex");
		nombre.add("Alex");
		nombre.add("Camilo");
		nombre.add("Felipe");
		nombre.add("Raul");
		
		System.out.println(nombre);
		
		
		Set<String> nameSet = new HashSet<String>(nombre);
		System.out.println(nameSet);
		
		
		
		Set<String> nameSet2 = new HashSet<String>();
		nameSet2.addAll(nombre);
		
		System.out.println(nameSet2);
		Integer b = null ;
		System.out.println(b);
		
		
	}

}
