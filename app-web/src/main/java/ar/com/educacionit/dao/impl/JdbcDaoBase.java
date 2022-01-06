package ar.com.educacionit.dao.impl;

import java.lang.reflect.ParameterizedType;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.domain.Entity;

public class JdbcDaoBase<T extends Entity> implements GenericDao<T> {
	
	protected String tabla;
	protected Class<T> clazz;
	
	public JdbcDaoBase(String tablaDelHijo) {
		this.tabla = tablaDelHijo;
		//Api reflection de java
		this.clazz = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		//Resuelve 
		//Socios, Categorias, Marcas o la clase correspondiente
	}
	public T getOne(Long id) {
		String sql = "SELECT * FROM " + this.tabla +"  WHERE ID=" +id;
		System.out.println(sql);
		T entity;
		//Usamos el try catch para que no nos arroje error
		//Lo que hacemos aqui es a traves de la api reflection de java 
		//pasarle a la entity que es generica la instancia de la clase
		
		try{
			entity = this.clazz.newInstance();
			entity.setId(id);
			//Otra manera de hacerlo
			//entity= this.clazz.getDeclaredConstructor().newInstance();
			
			//Clase utilitaria - que va a saber como tomar la instancia y como
			//armar los seteos de los atributos
		} catch(Exception e) {
			entity = null;
		}
		return entity;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public T save(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	public T[] findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
