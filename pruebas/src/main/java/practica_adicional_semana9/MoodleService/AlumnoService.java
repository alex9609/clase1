package practica_adicional_semana9.MoodleService;

import practica_adicional_semana9.domain.Alumno;

public interface AlumnoService extends  GenericMoodleService<Alumno>{
	
	//Interfaz alumno service extiende de la interfaz GenericMoodleService<Alumno> para permitir realizar 
	//el crud sobre la entidad alumno
	
	//Esta interfaz gracias a la POO, heredara los metodos de la clase GenericMoodleService;

}
