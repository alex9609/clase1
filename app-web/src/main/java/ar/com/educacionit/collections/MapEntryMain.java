package ar.com.educacionit.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEntryMain {

	public static void main(String[] args) {
		
		
		Map<Integer, String> dias = new HashMap<>();
		
		dias.put(1, "Lunes");
		dias.put(2, "Martes");
		dias.put(3, "Miercoles");
		dias.put(4, "Jueves");
		dias.put(5, "Viernes");
		dias.put(6, "Sabado");
		dias.put(7, "Domingo");
		
		//Las claves
		dias.keySet();
		
		//Valores
		dias.values();
		
		//Set de entries
		Set<Entry<Integer,String>> entries = dias.entrySet();
		for(Entry<Integer,String> en:entries) {
			System.out.println(en.getKey());
			System.out.println(en.getValue());
		}
		
		
		System.out.println("------------------------");
		//Segunda forma de recorrer un entryset
		
		Iterator<Entry<Integer,String>> iterador = entries.iterator();
		
		while(iterador.hasNext()) {
			Entry<Integer,String> entr= iterador.next();
			System.out.println(entr.getKey());
			System.out.println(entr.getValue());
			
		}
		
		
		//Volver el iterador al inicio
		
		iterador = entries.iterator();
	}

}
