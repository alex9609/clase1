package practica_adicional_semana9.dao.impl;

import java.util.Scanner;

import practica_adicional_semana9.dao.InscripcionDao;
import practica_adicional_semana9.domain.Alumno;
import practica_adicional_semana9.domain.DatosDBMemoria;
import practica_adicional_semana9.domain.Inscripciones;
import practica_adicional_semana9.domain.Materia;

public class InscripcionDaoImpl extends JdbcMoodleDB<Inscripciones> implements InscripcionDao {

	public InscripcionDaoImpl(Alumno[] alumnos, Materia[] materias) {
		super("Inscripcion",alumnos,materias);
	}
	
	public <T> void inscribir(T entity) {	
		
		this.datosBD.recorrerInscripciones();
		System.out.println(" -------------------- ");
		
		for(int i = 0; i< this.datosBD.getTamanio();i++) {
			//System.out.println(this.datosBD.getInscripcion(i));
			if(this.datosBD.getInscripcion(i) == null) {
				this.datosBD.setInscripcion((Inscripciones)entity, i);
				break;
			}
		}
		
		this.datosBD.recorrerInscripciones();
	}
	
	
	
	public void eliminar(int id) {

		for(int i = 0; i< this.datosBD.getTamanio();i++) {
			//System.out.println(this.datosBD.getInscripcion(i));
			try {
				if(this.datosBD.getInscripcion(i).getId() == id) {
					this.datosBD.setInscripcion(null, i);
					break;
				}
			}catch(Exception e) {
				System.out.println("El elemento a eliminar no existe");
			}
			
		}
		
		System.out.println("El dato ha sido eliminado");
		this.datosBD.recorrerInscripciones();
		
	}
	
	public Inscripciones getOne(int id) {	
		Inscripciones obtenerUna = null;
		for(int i = 0; i< this.datosBD.getTamanio();i++) {
			//System.out.println(this.datosBD.getInscripcion(i));
			if(this.datosBD.getInscripcion(i).getId() == id) {
				 obtenerUna = this.datosBD.getInscripcion(i);
				break;
			}
		}
		return obtenerUna;
	}
	
	public void getInscripciones() {
		this.datosBD.recorrerInscripciones();
	}

	
	public Alumno conseguirAlumno(int id) {
		Alumno alumnoexistente = null;
		for(Alumno user:this.alumnos) {
			if(user.getId() == id) {
				alumnoexistente = user;
			}
		}
		return alumnoexistente;
	}
	
	
	public Materia conseguirMateria(int id) {
		Materia materiaExistente = null;
		for(Materia asig:this.materias) {
			if(asig.getId() == id) {
				materiaExistente = asig;
			}
		}
		return materiaExistente;
	}
	

}
