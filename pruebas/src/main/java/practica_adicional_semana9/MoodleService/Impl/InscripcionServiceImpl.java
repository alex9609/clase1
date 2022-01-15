package practica_adicional_semana9.MoodleService.Impl;

import practica_adicional_semana9.MoodleService.InscripcionService;
import practica_adicional_semana9.dao.impl.InscripcionDaoImpl;
import practica_adicional_semana9.domain.Alumno;
import practica_adicional_semana9.domain.Inscripciones;
import practica_adicional_semana9.domain.Materia;

public class InscripcionServiceImpl extends AbstractionMoodleService<Inscripciones> implements InscripcionService {

	public InscripcionServiceImpl(Alumno[] alumnos, Materia[] materias) {
		super(new InscripcionDaoImpl(alumnos,materias));
	}

	public Alumno conseguirAlumno(int id) {
		Alumno usuario;
		usuario = ((InscripcionDaoImpl) this.registro).conseguirAlumno(id);
		return usuario;
	}

	public Materia conseguirMateria(int id) {
		Materia asigna;
		asigna = ((InscripcionDaoImpl) this.registro).conseguirMateria(id);
		return asigna;
	}

	public void getInscripciones() {
		((InscripcionDaoImpl) this.registro).getInscripciones();
	}

}
