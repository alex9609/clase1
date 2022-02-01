package ar.com.educacionit.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
		T entity = null;
		String sql = "SELECT * FROM " + this.tabla +"  WHERE ID=" +id;
		

		//Connection
		try(Connection con = AdministradorConexiones.obtenerConexion();){
			
			try(Statement st = con.createStatement()){
			
				try(ResultSet res = st.executeQuery(sql)){
				
					List<T> lista = DTOUtils.populateDTOs(this.clazz, res);
					
					if(!lista.isEmpty()) {
						entity =lista.get(0);
					}
				}
			}
		}catch(Exception e) {
			throw new GenericException("No se pudo consultar" + sql );
		}
		return entity;
	}

	public void delete(Long id) throws GenericException{
		if(id == null) {
			throw new GenericException("El id informado es NULL");
		}
		
		String sql = "DELETE FROM "+ this.tabla + " WHERE ID =?";
		
		
		try(Connection con = AdministradorConexiones.obtenerConexion();){
			try(PreparedStatement st = con.prepareStatement(sql)){
				st.setLong(1,id);
				
				int res = st.executeUpdate();
				if(res == 0) {
					System.out.println("No existe id en BS");
				}
			}
		}catch(Exception e) {
			throw new GenericException("No se pudo consultar" + sql );
		}

		
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

	public T save(T entity) throws DuplicatedException, GenericException {
		String sql ="INSERT INTO "+ this.tabla + this.getSaveSQL();
		try(Connection con = AdministradorConexiones.obtenerConexion();){
			
			
			try(PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
			
				//Sobrecarga a otro metodo abstracto
				this.save(st,entity); //Este metodo completa el sql con los valores correctos
				st.execute();
				
				//Que me devuelva el id generado recientemente
				try(ResultSet res = st.getGeneratedKeys()){
					if(res.next()) {
						Long lastGeneratedId = res.getLong(1); //Aca esta el id
						
						entity.setId(lastGeneratedId);
					}
					
				}
			}
		}catch(Exception e) {
			throw new GenericException("No se pudo insertar" + sql ,e);
		}
		return entity;
	}
	
	
	
	
	public void update(T entity) throws DuplicatedException, GenericException{
		
		//UPDATE TABLA SET CAMPO1 =?, CAMPO2=?, CAMPON=?
		
		String sql = "UPDATE " + this.tabla + " SET " + this.getUpdateSQL()+ " WHERE ID = "+entity.getId();
		
		try(Connection con = AdministradorConexiones.obtenerConexion();){
			
			
			try(PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
			
				//Sobrecarga a otro metodo abstracto
				this.update(st,entity); //Este metodo completa el sql con los valores correctos
				st.execute();
				
				//Que me devuelva el id generado recientemente
			}
		}catch(SQLException e) {
			//analizar si hay duplicated
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido actualizar " + sql, e);
			}
			
			//Ojo ver mas tipos si es necesario
			throw new GenericException("No se pudo actualizar" + sql ,e);
		}
	}
	

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
		
		return lista;
	}
	protected abstract void update(PreparedStatement st, T entity) throws SQLException;
	public abstract String getUpdateSQL();
	
	protected abstract void save(PreparedStatement st, T entity) throws SQLException;
	//Los hijos estan obligados a implemetarlos
	public abstract String getSaveSQL();

}
