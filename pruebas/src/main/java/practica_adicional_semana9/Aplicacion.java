package practica_adicional_semana9;

import java.util.Scanner;

import practica_adicional_semana9.domain.Alumno;
import practica_adicional_semana9.domain.DatosDBMemoria;
import practica_adicional_semana9.domain.Inscripciones;
import practica_adicional_semana9.domain.Materia;

public class Aplicacion {

	public static void main(String[] args) {
		
		
		Alumno a1 = new Alumno("Alex",111,112233,"Rodriguez","Rodriguez");
		Alumno a2 = new Alumno("Camilo",222,223344,"Rodriguez","Rodriguez");
		Alumno a3 = new Alumno("Alejandra",333,334455,"Castillo","Arias");
		Alumno a4 = new Alumno("Raul",444,556677,"Gutierrez","Matinez");
		
		
		Materia m1 = new Materia(1,"Programacion basica","12");
		Materia m2 = new Materia(2,"Algoritmos","13");
		Materia m3 = new Materia(3,"Java SE","14");
		
		Alumno[] listaAlumnos = new Alumno[]{a1,a2,a3};
		Materia[] listaMaterias = new Materia[] {m1,m2,m3};
		
		
		
		System.out.println("Bienvenido al moodle de registro de asignaturas");
		System.out.println(" ");
		Menu menu = new Menu(listaAlumnos,listaMaterias);
	
		


		
		
	}

}
