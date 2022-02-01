package practica_adicional_semana9.dao.impl;


import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

import practica_adicional_semana9.dao.GenericMoodleDao;
import practica_adicional_semana9.domain.Alumno;
import practica_adicional_semana9.domain.DatosDBMemoria;
import practica_adicional_semana9.domain.Entity;
import practica_adicional_semana9.domain.Inscripciones;
import practica_adicional_semana9.domain.Materia;

public class JdbcMoodleDB<T extends Entity> implements GenericMoodleDao<T> {
	
	protected DatosDBMemoria datosBD = new DatosDBMemoria();
	//SIMULA UNA BASE DE DATOS ALUMNOS Y MATERIAS
	protected Alumno[] alumnos;
	protected Materia[] materias;
	
	
	protected String tabla;
	protected Class<T> clazz;
	protected T entity;
	
	
	public JdbcMoodleDB(String tabla,Alumno[] alumno,Materia[] materia) {
		this.tabla = tabla;
		this.materias = materia;
		this.alumnos = alumno;
		this.clazz = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public JdbcMoodleDB(String tabla) {
		this.tabla = tabla;
		this.clazz = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void inscribir(T entity) {
		System.out.println("INSERT INTO " + this.tabla + " values " + entity.getClass().getSimpleName());
		
	}

	public void eliminar(int id) {
		System.out.println("DELETE * FROM " + this.tabla + " WHERE ID = " + id );		
		
	}

	public T buscar() {
		return null;
	}

	public void actualizar(int id) {
		System.out.println("UPDATE " + this.tabla + " SET " + " columna = value " + "WHERE ID= "+ id);
	}
	
	public T getOne(int id) {		
		System.out.println("SELECT * FROM " + this.tabla + " WHERE ID = " + id);
		return entity;
	}
	
	public void getAll(T entity) {
		
		
	}
	
	public void getArrayMaterias() {
		for(Materia asignature: this.materias) {
			System.out.println(asignature.getId()+ ". "+asignature.getCurso());
		}
	}

}
