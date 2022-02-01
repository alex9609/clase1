package practica_adicional_semana9;

import java.security.Provider.Service;
import java.util.Arrays;
import java.util.Scanner;

import practica_adicional_semana9.MoodleService.AlumnoService;
import practica_adicional_semana9.MoodleService.GenericMoodleService;
import practica_adicional_semana9.MoodleService.InscripcionService;
import practica_adicional_semana9.MoodleService.MateriaService;
import practica_adicional_semana9.MoodleService.Impl.AbstractionMoodleService;
import practica_adicional_semana9.MoodleService.Impl.AlumnoServiceImpl;
import practica_adicional_semana9.MoodleService.Impl.InscripcionServiceImpl;
import practica_adicional_semana9.MoodleService.Impl.MateriaServiceImpl;
import practica_adicional_semana9.domain.Alumno;
import practica_adicional_semana9.domain.DatosDBMemoria;
import practica_adicional_semana9.domain.Inscripciones;
import practica_adicional_semana9.domain.Materia;

public class Menu {
	
	private InscripcionService serviceInscripcion;

	private Inscripciones inscripcionAlumnoMateria;
	private int Opcion;
	private String mensaje;
	
	
	public Menu(Alumno[] alumnos,Materia[] materias) {
		
		//El menu nos muestra por teclado las opcciones y aquí es donde vamos a empezar a ejecuar el CRUD

		
		
		boolean validador = false;
		this.serviceInscripcion = new InscripcionServiceImpl(alumnos,materias);
		System.out.println(" ");
		
		while(!validador) {
			System.out.println("Ingrese la opción que desea realizar");
			System.out.println("1. Inscribir matería");
			System.out.println("2. Eliminar matería");
			System.out.println("3. Buscar inscripción");
			System.out.println("4. Actualizar inscripción");
			System.out.println("5. Encontrar todas las inscripciones");
			System.out.println("6. Salir");
			try {
				Scanner teclado = new Scanner(System.in);
				this.Opcion = teclado.nextInt();
				try {

					switch(Opcion) {
					case 1:
						
						this.serviceInscripcion.getArrayMaterias();
						System.out.println("Escriba la matería que desea inscribir ");
						int materia_id = teclado.nextInt();
						
						System.out.println("Digite su codigo de estudiante");
						int alumno_id = teclado.nextInt();
						
						Alumno alumnoInscripcion = this.serviceInscripcion.conseguirAlumno(alumno_id);
						Materia materiaInscripcion = this.serviceInscripcion.conseguirMateria(materia_id);
						
						if(alumnoInscripcion != null && materiaInscripcion != null) {
							inscripcionAlumnoMateria = new Inscripciones(alumnoInscripcion,materiaInscripcion);
							this.serviceInscripcion.inscribir(inscripcionAlumnoMateria);
							
						}else if(alumnoInscripcion == null) {
							System.out.println("El codigo del alumno es invalido");
							
						}else if(materiaInscripcion == null) {
							System.out.println("El codigo de la materia es invalido");
						}
						
						
					break;
					case 2:
						System.out.println("Ingrese el número de inscripcion que desea eliminar ");
						int id = teclado.nextInt();
						
						this.serviceInscripcion.eliminar(id);
						
					break;
					case 3:
						System.out.println("Ingrese el número de inscripcion que desea consultar ");
						int id1 = teclado.nextInt();
						System.out.println(this.serviceInscripcion.getOne(id1).toString());
						
						System.out.println("Estoy buscando inscripciones");
					break;
					case 4:
						System.out.println("Ingrese el número de inscripción que desea actualizar");
						int id_inscripcion = teclado.nextInt();
						this.serviceInscripcion.actualizar(id_inscripcion);
						

					break;
					case 5:
						this.serviceInscripcion.getInscripciones();
					break;
					case 6:
						System.out.println("Saliendo....");
						System.out.println("Gracias");
						validador = true;
					break;
					default:
						System.out.println("Opcion invalida");
					}
					
				}catch(Exception e) {
					e.getMessage();
					Opcion = 5;
					System.out.println("Error al cargar los datos");
				}
				
				
				//Validando que el usuario exista
							
				
				
			}catch(Exception e) {
				System.out.println(" ");
				System.out.println("Error: Ingrese un dato númerico" );
				System.out.println(" ");
			}
		}

	}
	
	
}
