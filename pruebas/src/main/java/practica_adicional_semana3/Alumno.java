package practica_adicional_semana3;

import java.util.Scanner;

//Clase alumno que nos permite tener los comportamientos de ingresar, obtener o promediar notas

class Alumno {
	Scanner teclado = new Scanner(System.in);
	String nombre;
	String apellido;
	Examen[] examenes;
	double nota;
	
	//Metodo constructor para realizar la creación de cada estudiante
	
	Alumno(String nombre, String apellido, int cantidad_examenes){
		this.nombre = nombre;
		this.apellido = apellido;
		this.examenes = new Examen[cantidad_examenes];
	}
	
	
	//Ingresamos las notas en el vector examenes que hacen parte de cada estudiante
	//con un bucle while verificamos que la nota esté en el rango adecuado 
	void ingresar_nota() {
		
		for(int i = 0; i < this.examenes.length; i++) {
			
			System.out.println("Ingrese la nota #"+(i+1) +" del estudiante: ");
			nota = teclado.nextDouble();
			while (nota < 0 || nota > 10) {
				System.out.println("La nota debe ser entre 0 y 10 ");
				nota = teclado.nextDouble();
			}
			examenes[i] = new Examen((i+1),nota);
		}
	}
	
	//Podemos ver las notas que tiene un estudiante
	void obtener_notas() {
		for(Examen quiz:examenes){
			System.out.println(quiz.obtenerNota());
		}
	}
	
	//Nos devuelve nombre y apellido de un estudiante
	String obtener_nombre() {
		String respuesta = this.nombre + " " + this.apellido;
		return respuesta;
	}
	
	
	//Verificamos cual va a ser la nota mas alta de un estudiante
	//este metodo nos sirve para despues comparar la nota mas alta de cada estudiante
	double nota_alta() {
		double notaAlta = -1;
		
		for(Examen quiz:examenes){
			if(quiz.obtenerNota() > notaAlta) {
				notaAlta = quiz.obtenerNota();
			}
		}
		
		return notaAlta;
	}
	
	//Este metodo nos devuelve la nota mas baja de un estudiante
	//nos servira mas adelante para comparar las notas de varios estudiantes
	
	double nota_baja() {
		double nota_baja = 11;
		
		for(Examen quiz:examenes){
			if(quiz.obtenerNota() < nota_baja) {
				nota_baja = quiz.obtenerNota();
			}
		}
		return nota_baja;
	}

	//Con este metodo promediamos las notas  de cada estudiante para saber mas adelante si
	//aprobo o reprobo
	double promedio() {
		double promedio_nota = 0;
		for(Examen quiz:examenes) {
			promedio_nota += quiz.obtenerNota();
		}
		promedio_nota = promedio_nota / examenes.length;
		return promedio_nota;
	}
	
	

}
