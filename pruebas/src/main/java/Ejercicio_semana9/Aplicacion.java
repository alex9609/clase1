package Ejercicio_semana9;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Aplicacion {
		
	private Set<Alumno> setAlumno = new HashSet<Alumno>();
	private Set<Materia> setMateria = new HashSet<Materia>();
	private Set<Inscripciones> setInscripciones = new HashSet<Inscripciones>();
	
	public Aplicacion( Set<Alumno> setAlumno ,Set<Materia> setMateria) {
		this.setAlumno = setAlumno;
		this.setMateria = setMateria;
	}
	
	public void Inscribir(Scanner teclado) {
		try {
			
			System.out.println("Ingrese el id del alumno a inscribir");
			int idAlumno = teclado.nextInt();
			System.out.println("Ingrese el id materia");
			int idMateria = teclado.nextInt();
			
			Alumno alumn = null;
			
			for(Alumno user: this.setAlumno) {
				if(user.getDni() == idAlumno) {
					alumn = user;
					break;
				}
			}
			
			Materia materia = null;
			for(Materia ma: this.setMateria) {
				if(ma.getId() == idMateria) {
					materia = ma;
					break;
				}
			}
			if(materia == null || alumn == null) {
				System.out.println("Inconsistencia en los valores");
			}else {
				this.setInscripciones.add(new Inscripciones(alumn,materia));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public Set<Inscripciones> getSetInscripciones() {
		return setInscripciones;
	}

	
	
	
	

}
