package ar.com.educacionit.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Vectores {
	
	public static void main(String[] args) {
		Collection<Integer> edades = new ArrayList<>();
		
		edades.add(10);
		edades.add(30);
		edades.add(50);
		edades.add(5);
		
		
		//Filtras los elementos  > 30
		//List<Integer> filtrados = new ArrayList<>();
		
		//Devuelve una secuencia de stremas
		Stream<Integer> stream = edades.stream();
		//Funcion intermedia
		Stream<Integer> filtrados = stream.filter(x -> x >= 30);
		
		//funciona terminal
		List<Integer> res = filtrados.collect(Collectors.toList());
		
		
		
	}

}
