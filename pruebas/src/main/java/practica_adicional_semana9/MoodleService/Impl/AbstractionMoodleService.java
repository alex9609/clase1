package practica_adicional_semana9.MoodleService.Impl;

import practica_adicional_semana9.MoodleService.GenericMoodleService;
import practica_adicional_semana9.dao.GenericMoodleDao;
import practica_adicional_semana9.domain.Alumno;
import practica_adicional_semana9.domain.Materia;

public class AbstractionMoodleService<T> implements GenericMoodleService<T> {
	
	protected GenericMoodleDao<T> registro;
	
	public AbstractionMoodleService(GenericMoodleDao<T> registro){
		this.registro = registro;		
	}
	public void inscribir(T entity) {
		this.registro.inscribir(entity);
	}

	public void eliminar(int id) {
		this.registro.eliminar(id);
	}

	public T buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizar(int id) {
		this.registro.actualizar(id);
	}
	
	public T getOne(int id) {
		T entity;
		entity = this.registro.getOne(id);
		return entity;
	}
	
	public void getArrayMaterias() {
		this.registro.getArrayMaterias();
	}
	

	
}
