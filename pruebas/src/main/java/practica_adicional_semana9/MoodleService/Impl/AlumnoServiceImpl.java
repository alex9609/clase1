package practica_adicional_semana9.MoodleService.Impl;

import practica_adicional_semana9.MoodleService.AlumnoService;
import practica_adicional_semana9.dao.impl.AlumnoDaoImpl;
import practica_adicional_semana9.domain.Alumno;

public class AlumnoServiceImpl extends AbstractionMoodleService<Alumno> implements AlumnoService{
	
	//Esta clase es la implementacion de Alumno service es decir, que por medio de esta clase 
	//vamos a implementar los metodos CRUD, sin embargo ya que está clase extiende de 
	//AbstractionMoodleService por medio de la herencia, es decir que la clase AbdstractionMoodleService es la 
	//que implementa los metodos de GenericService, ya que es generica entonces le añadimos como parametro 
	//que trabaje sobre la entidad Alumno

	public AlumnoServiceImpl() {
		super(new AlumnoDaoImpl());
	}

}
