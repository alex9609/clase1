package Laboratorios;

public class Laboratorio2 {

	public static void main(String[] args) {
	/*
	 * 
	 * Si variableA, variableB y variableC son de tipo lógicas o boolean que valores deben poseer para que las siguientes
		operaciones den los siguientes resultados:
		• (variableA && variableB) || (variableA && variableC) = true
		• !(variableA || variableB) && variableC = false
	 */
		
		boolean variableA = true;
		boolean variableB = true;
		boolean variableC = true;
		
		System.out.println((variableA && variableB) || (variableA && variableC));
		System.out.println((!(variableA ||variableB)) && variableC);
	}

}
