package clase4;

import java.util.Scanner;

public class EjercicioDiagonal {

	public static void main(String[] args) {
		
		//Determinar si una matriz es una matriz diagonal
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese la cantidad de filas");
		int cantFilas = teclado.nextInt();
		
		System.out.println("Ingrese la cantidad de columnas"); 
		int cantColumnas = teclado.nextInt();
		
		if(cantFilas == cantColumnas) {
			
			int[][] matriz = new int[cantFilas][cantColumnas];
			
			for(int i = 0; i < cantFilas; i++) {
				for(int j = 0; j<cantColumnas; j++) {
					System.out.println("Ingrese el número ");
					matriz[i][j] = teclado.nextInt();
				}
			}
			
			for(int i = 0; i < cantFilas; i++) {
				System.out.println("");
				for(int j = 0; j<cantColumnas; j++) {
					System.out.print(matriz[i][j]);
				}
			}
			
		}
		
		
		
		teclado.close();
	}

}
