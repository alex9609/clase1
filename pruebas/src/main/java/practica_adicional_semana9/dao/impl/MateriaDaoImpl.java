package practica_adicional_semana9.dao.impl;

import practica_adicional_semana9.dao.MateriaDao;
import practica_adicional_semana9.domain.Materia;

public class MateriaDaoImpl extends JdbcMoodleDB<Materia> implements MateriaDao {

	public MateriaDaoImpl() {
		super("Materia");
	}

}
