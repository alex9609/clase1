package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.ArticuloDao;
import ar.com.educacionit.domain.Articulos;

public class ArticuloDaoImpl extends JdbcDaoBase<Articulos> implements ArticuloDao {

	public ArticuloDaoImpl() {
		super("Articulos");
	}

	@Override
	protected void update(PreparedStatement st, Articulos entity) throws SQLException {
		
	}

	@Override
	public String getUpdateSQL() {
		return null;
	}

	@Override
	protected void save(PreparedStatement st, Articulos entity) throws SQLException {
		
	}

	@Override
	public String getSaveSQL() {
		return null;
	}

}
