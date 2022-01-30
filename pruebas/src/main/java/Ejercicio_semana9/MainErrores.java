package Ejercicio_semana9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MainErrores {

public static void main(String[] args) throws Exception {
	
	//Tenemos datos de alumnos y materias Listo
	
	//Inscripcion a alumno a materia asociada
	//Crear una bd con inscripciones
	
	//Crear alumnos y materias
	Scanner teclado = new Scanner(System.in);
	
	List<Alumno> listaAlumno = new ArrayList<Alumno>();
	
	Set<Alumno> setAlumno = new HashSet<Alumno>();
	Set<Materia> setMateria = new HashSet<Materia>();

	
	boolean validador = false;
	
	while(!validador) {
		System.out.println("Ingrese lo que desea hacer");
		System.out.println("1- Ingresar alumno");
		System.out.println("2- Ingresar materia");
		System.out.println("3- Ingrese inscripcion de materia-alumno");
		try {
			int opcion = teclado.nextInt();
			teclado.nextLine();
			
			switch(opcion){
			case 1:
				System.out.println("Ingresar nombre alumno");
				String nombre = teclado.next();
				teclado.nextLine();
				//Espacio en memoria diferente
				
				System.out.println("Ingrese dni");
				int dni = teclado.nextInt();
				teclado.nextLine();
				
				Alumno user = new Alumno(nombre,dni);
				setAlumno.add(user);
				
				break;
			case 2:
				System.out.println("Ingrese nombre de materias");
				String nombreMateria = teclado.next();
				teclado.nextLine();
				
				System.out.println("Ingrese id materia");
				int id = teclado.nextInt();
				teclado.nextLine();
				
				System.out.println("Ingrese turno");
				String turno = teclado.nextLine();
				
				Materia materia = new Materia(id,nombreMateria,turno);
				setMateria.add(materia);
				
				break;
			case 3:
				if(setAlumno.isEmpty()|| setMateria.isEmpty()) {
					// true  o true = true
					// true o false = true
					//false o true = true
					//false o false = false
					System.out.println("No hay datos");
					validador = true;
				}else {
					Aplicacion app = new Aplicacion(setAlumno,setMateria);
					app.Inscribir(teclado);
					Set<Inscripciones> setInscrip = app.getSetInscripciones();
					System.out.println(setInscrip);
				}
				break;
				
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
			validador = true;
			//throw new Exception (e.printStackTrace()); 
		}
		
		
		
	}


	
	
	
	
	
	
		
	}		
}		