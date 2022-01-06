package clase4;

import java.util.Scanner;

public class Ejercicio_clase4 {

	public static void main(String[] args) {
		
		//Vector
		//Maximo
		//Minimo
		//PosMaximo
		//PosMinimo
		//Promedio
		
		Scanner teclado = new Scanner(System.in);
		
		//int[] Vector;
		int[] Vector2 = {12,4,5,3,3,3,4,10,30,3,30,20,30,30,10,30};
		               //0  1 2 3 4 5 6  7  8 9 10 11 12 13 14 15
		int tamanio;
		int Maximo;
		int Minimo;
		int PosMaximo;
		int PosMinimo;
		int CanMaximo;
		int CanMinimo;
		double Promedio;
		
		do {
			
			System.out.println("Ingrese el tamaño del vector");
			tamanio = teclado.nextInt();		
			
		}while(tamanio<= 0);
		
		
		Minimo = Vector2[0];
		Maximo = Vector2[0];
		PosMaximo = 0;
		PosMinimo = 0;
		CanMaximo = 0;
		CanMinimo = 0;
		Promedio = Vector2[0];
		
		for(int i = 1; i<Vector2.length;i++) {

			if(Vector2[i] > Maximo) {
				Maximo = Vector2[i];
				PosMaximo = i;
				CanMaximo = 1;
			}else if(Vector2[i] == Maximo){
				CanMaximo += 1;
			}
			if(Vector2[i] < Minimo) {
				Minimo = Vector2[i];
				PosMinimo = i;
				CanMinimo = 1;
			}else if(Vector2[i] == Minimo) {
				CanMinimo +=1;
			}
			
			Promedio += Vector2[i];
		}
		
		System.out.println(Vector2.length);
		Promedio = Promedio/Vector2.length;
		
		System.out.println("El valor máximo es " + Maximo + " la posición es " + PosMaximo + " se repite " + CanMaximo + " veces");
		System.out.println("El valor mínimo es " + Minimo + " la posición es " + PosMinimo + " se repite " + CanMinimo + " veces ");
		
		System.out.println("El promedio es " + Promedio);
		
		
		teclado.close();
	}

}
