package Laboratorios;

public class Laboratorio1 {

	public static void main(String[] args) {
		//Cree un programa en Java que dado un numero entero de horas
		//muestre el equivalente en semanas, días y horas.
		
		int numero =1823;
		int semana = 168;
		int dia = 24;
		
		int semanas = 0;
		int dias = 0;
		int horas = 0;
		
		semanas = numero/semana;
		numero = numero - (semanas*semana);
		
		dias = numero/dia;
		numero = numero - (dias*dia);
		
		horas = numero;
		
		System.out.println("Semanas " + semanas);
		System.out.println("Dias " + dias);
		System.out.println("Horas " + horas);
	}

}
