package clase4;

public class Ciclo_For {

	public static void main(String[] args) {
		
		//Inicializamos un vector
		int[] vector = new int[7];
		
		//Llenar un For
		for(int i = 0; i<vector.length -1; i++) {
			vector[i] = i * 10;
		}
		
		System.out.println(vector);
	}

}
