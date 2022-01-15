package practica_adicional_semana9.MoodleService;

import practica_adicional_semana9.domain.Alumno;
import practica_adicional_semana9.domain.Materia;

public interface GenericMoodleService<T> {
	
	//Es nuestra interfaz generica para el CRUD para el service o el cliente
	//Esta interfaz es generica para poder realizar el CRUD tanto para alumnos como para materias
	
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
