package practica_adicional_semana9.MoodleService;

import practica_adicional_semana9.domain.Alumno;
import practica_adicional_semana9.domain.Inscripciones;
import practica_adicional_semana9.domain.Materia;

public interface InscripcionService extends GenericMoodleService<Inscripciones>{
		
	public Alumno conseguirAlumno(int id);
	public Materia conseguirMateria(int id);
	
	public void getInscripciones();
}
