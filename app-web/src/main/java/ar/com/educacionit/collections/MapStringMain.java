package ar.com.educacionit.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapStringMain {

	public static void main(String[] args) {
		
		Map<Integer,String> dias = new HashMap<>();
		
		//Agregar elementos put(integer,string)
		
		//Map (clave,valor)
		
		dias.put(1, "Lunes");
		dias.put(2, "Martes");
		dias.put(3, "Miercoles");
		dias.put(4, "Jueves");
		dias.put(5, "Viernes");
		dias.put(6, "Sabado");
		dias.put(7, "Domingo");
		
		//Obtener un elemento del mapa
		
		//Obtengo el valor de la llave 1
		String v = dias.get(1);
		System.out.println(1 + " --" +v);
		
		//Una llave que no exista
		//Retorna un null
		System.out.println(dias.get(8));
		
		
		//Impresion del map
		System.out.println(dias);
		
		
		//Saber todas las claves de un map
		//las claves son set - keyset - devuelve claves no duplicadas
		//Todos los values son Collections<v>
		
		//keyset del dia 
		Set<Integer> keyset = dias.keySet();
		
		for(Integer key : keyset) {
			//ahora imprimimos las claves
			System.out.println(key);
			
			//Imprimimos la clave y valor
			System.out.println(key + "----" + dias.get(key));
		}
		
		//Recorrer solo los valores 
		//Me devulve un collection de strings
		Collection<String> values = dias.values();
		for(String value: values) {
			//Impresión de valores
			System.out.println(value);
			
			//DADO EL VALOR OBTENER SI EXISTE PARA EL MAP
			System.out.println(dias.containsValue(value));
		}
		
		System.out.println("----------------------");
		//Entryset : Me da la clave y el valor
		//Me devuelve un set de entry y valor
		Set<Map.Entry<Integer, String>> entrySet = dias.entrySet(); //
		for(Map.Entry<Integer, String> entry:entrySet) {
			
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("---------");
			System.out.println(entry);
		}
		
		
	}

}
