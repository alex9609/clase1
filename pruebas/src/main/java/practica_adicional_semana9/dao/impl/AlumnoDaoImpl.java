package practica_adicional_semana9.dao.impl;

import practica_adicional_semana9.dao.AlumnoDao;
import practica_adicional_semana9.domain.Alumno;

public class AlumnoDaoImpl extends JdbcMoodleDB<Alumno> implements AlumnoDao{

	public AlumnoDaoImpl() {
		super("Alumno");
	}

}
