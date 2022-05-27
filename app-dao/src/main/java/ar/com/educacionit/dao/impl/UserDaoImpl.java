package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorConexiones;
import ar.com.educacionit.dao.jdbc.util.DTOUtils;
import ar.com.educacionit.domain.Users;

public class UserDaoImpl implements UserDao {

	@Override
	public Users getUserByUserName(String username) throws GenericException {

		Users entity = null;
		String sql = "SELECT * FROM users  WHERE UPPER(username) = '" +username.toUpperCase() +"'";
		

		//Connection
		try(Connection con = AdministradorConexiones.obtenerConexion();){
			
			try(Statement st = con.createStatement()){
			
				try(ResultSet res = st.executeQuery(sql)){
				
					List<Users> lista = DTOUtils.populateDTOs(Users.class, res);
					
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

}
