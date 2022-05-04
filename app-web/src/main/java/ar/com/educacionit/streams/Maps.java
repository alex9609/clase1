package ar.com.educacionit.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maps {
	
	public static void main(String[] args) {
		//Convertir edades de integer a String
		Collection<Integer> edades = new ArrayList<>();
		
		edades.add(10);
		edades.add(30);
		edades.add(50);
		edades.add(5);
		
		List<String> edadestr = edades.stream().map(x -> x.toString()).collect(Collectors.toList());
		
		System.out.println(edadestr);
		
		
	}

}
