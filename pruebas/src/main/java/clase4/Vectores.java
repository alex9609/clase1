package clase4;

import java.util.Arrays;

public class Vectores {

	public static void main(String[] args) {
		String[]  nombres = new String[] {"Luz","Jose","edwin","Carlos","erana","Samir"};
//		String[] nombresconE = new String[nombres.length];
//		
//		String nombre;
//		int j = 0;
//		
//		
//		
//		for(int i = 0; i < nombres.length; i++) {
//			nombre = nombres[i];
//			if(nombre.startsWith("e")) {
//				nombresconE[j] = nombre;
//				j++;
//			}
//		}
//		
//		for(String nom:nombresconE) {
//			System.out.println(nom);
//		}
//		
//		
		//Determinar la cantidad de elementos que empiezan con e
		//y crear un vector de dicho tamaño
		
		int cantidad = 0;
		for(String name: nombres) {
			if(name.startsWith("e")) {
				cantidad++;
			}
		}
		
		String[] nombresnuevo = new String[cantidad];
		int pos = 0;
		
		for(String name: nombres) {
			if(name.startsWith("e")) {
				nombresnuevo[pos] = name;
				pos++;		
			}
		}
		
		System.out.println(Arrays.toString(nombresnuevo));
		
	}

}
