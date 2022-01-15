package practica_adicional_semana9.dao;

import practica_adicional_semana9.domain.Alumno;
import practica_adicional_semana9.domain.Materia;

public interface GenericMoodleDao<T> {
	
	//Create
	public  void inscribir(T entity);
	//Delete
	public void eliminar(int id);
	
	//Read
	public T buscar();
	//Actualizar 
	public void actualizar(int id);
	
	//Obtener un valor
	public T getOne(int id);
	
	//public void setDatos(Alumno[] alumnos, Materia[] materias);
	public void getArrayMaterias();

}
