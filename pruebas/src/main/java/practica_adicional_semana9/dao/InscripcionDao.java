package practica_adicional_semana9.dao;

import practica_adicional_semana9.domain.Alumno;
import practica_adicional_semana9.domain.Inscripciones;
import practica_adicional_semana9.domain.Materia;

public interface InscripcionDao extends GenericMoodleDao<Inscripciones> {
	
	public Alumno conseguirAlumno(int id);
	public Materia conseguirMateria(int id);
}
