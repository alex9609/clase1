package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class MainCollection {

	public static void main(String[] args) {
		
		
		//Creo
		Collection<String> nombres = new ArrayList<>();
		
		//No hace falta agregar el tipado
		nombres.add("Juan");
		nombres.add("Camilo");
		nombres.add("Alex");
		nombres.add("Julian");
		nombres.add("Julian");
		
		
		System.out.println(nombres);
		//Obtener
		Iterator<String> itnombres= nombres.iterator();
		while(itnombres.hasNext()) {
			String dato = itnombres.next();
			System.out.println("DATO "+ dato);
		}
		
		/*
		 * Eliminar DA ERROR ajva.util.CurrentModifcationException
		 * 
		 * for(String nombre : nombres){
		 * 	nombres.remove(nombre);
		 */
		
		//Buscar - Sin eliminar o modificar el tama�o o alterar el tama�o
		//de la colecci�n
		for(String nombre: nombres) {
			if(nombre.equalsIgnoreCase("juan")) {
				//
				nombre = new String("Jose");
			}
		}
		System.out.println(nombres);
		
		//Eliminar con iterator
		
		//El puntero lo vuelvo al principio del ArrayList
		itnombres= nombres.iterator();
		while(itnombres.hasNext()) {
			itnombres.next();
			itnombres.remove();
		}
	
		//No hace falta agregar el tipado
		nombres.add("Juan");
		nombres.add("Camilo");
		nombres.add("Alex");
		nombres.add("Julian");
		nombres.add("Julian");
		
		
		nombres = new HashSet<>(nombres);
		System.out.println(nombres);
		

		
	}

}
