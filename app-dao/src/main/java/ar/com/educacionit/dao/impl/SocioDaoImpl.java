package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorConexiones;
import ar.com.educacionit.dao.jdbc.util.DTOUtils;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.domain.Users;

public class SocioDaoImpl extends JdbcDaoBase<Socios> implements SociosDao {

	public SocioDaoImpl() {
		super("Socios"); // es la tabla
	}

	@Override
	public String getSaveSQL() {
	return ("(nombre,apellido,email,fecha_alta,direccion,paises_id) values(?,?,?,?,?,?)"); 
	}

	@Override
	
	public String getUpdateSQL() {
		return "nombre=?, apellido=?, email=?,paises_id=?";
	}

	@Override
	protected void save(PreparedStatement st, Socios entity) throws SQLException {
		st.setString(1, entity.getNombre());
		st.setString(2, entity.getApellido());
		st.setString(3, entity.getEmail());
		st.setDate(4, new java.sql.Date(new Date().getTime()));
		st.setString(5, entity.getDireccion());
		st.setLong(6, entity.getPaisesId());
	}

	@Override
	protected void update(PreparedStatement st, Socios entity) throws SQLException {
		st.setString(1, entity.getNombre());
		st.setString(2, entity.getApellido());
		st.setString(3, entity.getEmail());
		st.setDate(4, new java.sql.Date(new Date().getTime()) );
		st.setLong(5, entity.getPaisesId());
	}

	@Override
	public Socios getSociosByUserId(Long id) throws GenericException {
		String sql = "SELECT * FROM SOCIOS WHERE users_id = " + id;
		List<Socios> list = super.findBySQL(sql);
		Socios entity = null;
		
		if(!list.isEmpty()) {
			entity = list.get(0);
		}
		return entity;
	} 


}
