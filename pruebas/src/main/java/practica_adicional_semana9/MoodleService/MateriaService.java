package practica_adicional_semana9.MoodleService;

import practica_adicional_semana9.domain.Materia;

public interface MateriaService extends GenericMoodleService<Materia> {
	
	//Esta interfaz es la que esta del lado del cliente y heredarada los metodos de la interfaz
	//GenericMoodleService 
	
	//Como GenericMoodleService es una interfaz generica, entonces especificamos que queremos trabajar
	//sobre la entidad (Clase) Materia
	

}
