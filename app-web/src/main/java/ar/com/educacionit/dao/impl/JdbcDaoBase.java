package ar.com.educacionit.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorConexiones;
import ar.com.educacionit.dao.jdbc.util.DTOUtils;
import ar.com.educacionit.domain.Entity;

/*
 * Las T son entidades que representan tablas
 * Por ende vana heredar de Entity
 */
public abstract class  JdbcDaoBase<T extends Entity> implements GenericDao<T> {
	
	protected String tabla;
	protected Class<T> clazz;
	
	public JdbcDaoBase(String tablaDelHijo) {
		this.tabla = tablaDelHijo;
		//Api reflection de java
		this.clazz = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		//Resuelve 
		//Socios, Categorias, Marcas o la clase correspondiente
	}
	public T getOne(Long id)  throws GenericException{
		
		if (id == null) {
			throw new GenericException("Id no informado ");
		}
		
		String sql = "SELECT * FROM " + this.tabla +"  WHERE ID=" +id;
		System.out.println(sql);
		T entity;
		//Usamos el try catch para que no nos arroje error
		//Lo que hacemos aqui es a traves de la api reflection de java 
		//pasarle a la entity que es generica la instancia de la clase
		
		try{
			//entity = this.clazz.newInstance();
			entity = this.clazz.getDeclaredConstructor().newInstance();
			entity.setId(id);
			
			//Cuando viene desde la base de datos
			//nombre_campo > nombreCampo
			//Ejemplo:
			//paises_id >setPaisesId(Objeto)
			
			
			//Otra manera de hacerlo
			//entity= this.clazz.getDeclaredConstructor().newInstance();
			
			//tomar los metodos de this.clazz > method[]
			//para cada method > method.invoke(entity)
			
			//Clase utilitaria - que va a saber como tomar la instancia y como
			//armar los seteos de los atributos
			
		
		} catch(Exception e) {
			entity = null;
		}
		return entity;
	}

	public void delete(Long id) throws GenericException{
		String sql = "DELETE FROM "+ this.tabla + "WHERE ID = " + id;
		System.out.println(sql);
		//Execute
		//Error de conexión
	}
	/*
	public T save(T entity) throws DuplicatedException {
		//Con api reflection
		//buscar los fields
		//for > cuales son no nulos
		
		StringBuffer namesSQL = new StringBuffer( "INSER INTO " ).append(this.tabla).append("(");
		StringBuffer valueSQLString = new StringBuffer("values (");
		
		try {
			//Creamos una nueva instancia para el objeto
			//Me da una instancia vacia por defecto
			T instance = this.clazz.getConstructor().newInstance();
			
			//Le pido los fields a ese instance
			
			Field[] fields = instance.getClass().getDeclaredFields();
			
			//Recorro cada uno de los fields
			for(Field field:fields) {
				//Cambiamos la accesibilidad del field
				field.setAccessible(true);

				String camposql = field.getName(); //Nombre que tenga el field - Este name es un camelcase
				Object valuesql = field.get(entity);
				if(valuesql != null) {
					namesSQL.append(camposql).append(",");
					valueSQLString.append("'").append(valuesql).append("'").append(",");
					
				}
			}
			//insert into tabla (campo1, campo2, campon,)
			namesSQL = new StringBuffer(namesSQL.substring(0,namesSQL.length()-1)); //Con esta linea quitamos un string adicional
			namesSQL.append(")");
			//Insert into tabla (campo1, campo2 ..... campoN) values (1,2 etc
			valueSQLString = new StringBuffer(valueSQLString.substring(0,valueSQLString.length()-1));
			valueSQLString.append(")");
			
			//Cerramos la instrucción SQL
			namesSQL.append(")");
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sqlfinal = namesSQL.toString() + valueSQLString.toString();
		//Exceute hacia la db
		//un recordset
		
		System.out.println(sqlfinal);
		return null;
	}
	*/
	public T save(T entity) throws DuplicatedException {
		String sql ="INSERT INTO "+ this.tabla + this.getSaveSQL(entity);
		System.out.println(sql);
		entity.setId(12L);//db
		return entity;
	}
	
	
	//Los hijos estan obligados a implemetarlos
	public abstract String getSaveSQL(T entity);
	
	public void update(T entity) {
		String sql = "UPDATE " + this.tabla + " SET " + getUpdateSQL(entity)
		+ "WHERE ID="+entity.getId();
		System.out.println(sql);
		
	}
	
	public abstract String getUpdateSQL(T entity);

	public List<T> findAll() throws GenericException {
		
		List<T> lista = new ArrayList<T>();
		String sql = "SELECT * FROM " + this.tabla;
		//Connection
		try(Connection con = AdministradorConexiones.obtenerConexion();){
			try(Statement st = con.createStatement()){
				try(ResultSet res = st.executeQuery(sql)){
					lista = DTOUtils.populateDTOs(this.clazz, res);
				}
			}
		}catch(Exception e) {
			throw new GenericException("No se pudo consultar" + sql );
		}
		//Statement
		
		//Resultset
		
		return lista;
	}

}
