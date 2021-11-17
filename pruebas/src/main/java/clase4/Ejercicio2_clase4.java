package clase4;

import java.util.Scanner;

public class Ejercicio2_clase4 {

	public static void main(String[] args) {
		//Solicitar al usuario la cantidad de registros
		//Cargar en un vetor de enteros los datos ingresados.
		// contar la cantidad de numeros pares
		// contar la canitdad de numeros impares
		// sumar los numeros pares
		// sumar los numeros impares
		// promevio de valores ingresados
		
		int[] vector;
		int cantidad;
		int canPares;
		int canImpares;
		int sumaPares;
		int sumaImpares;
		double promedio;


		
		Scanner teclado = new Scanner(System.in);
		
		
		
		do {
			System.out.println("Ingrese la cantidad de elementos a ingresar");
			cantidad = teclado.nextInt();
		}while(cantidad <= 0);
		
		vector = new int[cantidad];
		for(int i = 0; i<vector.length; i++) {
			System.out.println("Ingrese el numero " + (i+1));
			vector[i] = teclado.nextInt();
		}
		
		
		//Hacer las demas operaciones
		
		canPares = 0;
		canImpares = 0;
		sumaPares = 0;
		sumaImpares = 0;
		
		for(int dato: vector) {
			if(dato % 2 == 0) {
				canPares++;
				sumaPares += dato;
			}else {
				canImpares++;
				sumaImpares += dato;
			}
		}
		
		
		promedio = (double)(sumaPares + sumaImpares)/vector.length;
		
		System.out.println("La cantidad de numeros pares es " + canPares + " La suma de pares es " + sumaPares);
		System.out.println("La cantidad de numeros impares es " + canImpares + " La suma de pares es " + sumaImpares);
		System.out.println("El promedio de los valores es " + promedio);
		
		teclado.close();
		
	}

}
