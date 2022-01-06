package clase4;

public class VectorObject {

	public static void main(String[] args) {
		//Objetos en Java, crear un vector de objetos
		
		Object edad = 10;
		Object nombres = "Alex";
		Object flag = true;
		Object letra = 'a';
		
		Object[] datos = new Object[] {edad,nombres,flag,letra};
		
		//Determinar que datos son de tipo booleano
		
		//Tipos de datos primitivos
		
		/*
		 * byte < short < int < long < float < double
		 * 
		 * wrapper: Tambien es una clase que envuelve a un valor primitivo
		 * Byte Short, Integer, Long, Float, Double
		 */
		
		int a = 25;
		Integer a1 = 25;
		
		//Autoboxing
		a1 = a;
		a = a1;
		
		
		
		
		for(Object dato: datos) {
			//El instanceof trabaja en clases por este motivo Boolean usamos un wrapper en vez de un primitivo
			if(dato instanceof Boolean) {
				Boolean aux = (Boolean)dato;
				System.out.println(aux);
			}
		}
		
	}

}
