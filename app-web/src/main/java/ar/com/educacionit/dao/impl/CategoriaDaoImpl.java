package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Socios;

public class CategoriaDaoImpl extends JdbcDaoBase<Categorias> implements CategoriaDao{
	
	public CategoriaDaoImpl() {
		super("Categorias");
	}
	

	public String getSaveSQL() {
	return ("(descripcion,codigo,habilitada) values(?,?,?)"); 
}
	@Override
	protected void save(PreparedStatement st, Categorias entity) throws SQLException {
		//Insert unto categorias
		st.setString(1, entity.getDescripcion());
		st.setString(2, entity.getCodigo());
		st.setLong(3, entity.getHabilitada());
	}

	@Override
	
	public String getUpdateSQL() {
		return "Descripcion=?,habilitada=?";
	}


	@Override
	protected void update(PreparedStatement st, Categorias entity) throws SQLException {
		st.setString(1, entity.getDescripcion());
		st.setLong(2, entity.getHabilitada());
		
	}
	

}
