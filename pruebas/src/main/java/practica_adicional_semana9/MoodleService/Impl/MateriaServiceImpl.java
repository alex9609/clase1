package practica_adicional_semana9.MoodleService.Impl;

import practica_adicional_semana9.MoodleService.MateriaService;
import practica_adicional_semana9.dao.GenericMoodleDao;
import practica_adicional_semana9.dao.impl.MateriaDaoImpl;
import practica_adicional_semana9.domain.Materia;

public class MateriaServiceImpl extends AbstractionMoodleService<Materia> implements MateriaService {

	public MateriaServiceImpl() {
		super(new MateriaDaoImpl());
	}

}
