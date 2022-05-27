package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.dao.ArticuloDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Articulos;

public class ArticuloDaoImpl extends JdbcDaoBase<Articulos> implements ArticuloDao {

	public ArticuloDaoImpl() {
		super("Articulos");
	}

	@Override
	protected void update(PreparedStatement st, Articulos entity) throws SQLException {
		st.setString(1, entity.getTitulo());
		st.setDouble(2, entity.getPrecio());
		st.setLong(3, entity.getStock());
		st.setLong(4, entity.getMarcaId());
		st.setLong(5, entity.getCategoriaId());
	}

	@Override
	public String getUpdateSQL() {
		return "titulo = ?,precio = ?,stock = ?,marcas_id = ?,categorias_id = ?";
	}
	/*
	 *   titulo varchar(100) NOT NULL,
  codigo varchar(10) NOT NULL,
  fecha_creacion date NOT NULL,
  precio float NOT NULL,
  stock int NOT NULL,
  marcas_id int NOT NULL,
  categorias_id int NOT NULL  
	 */
	@Override
	protected void save(PreparedStatement st, Articulos entity) throws SQLException {
		st.setString(1, entity.getTitulo());
		st.setString(2, entity.getCodigo());
		st.setDate(3, new java.sql.Date(entity.getFechaCreacion().getTime()));
		st.setDouble(4, entity.getPrecio());
		st.setLong(5, entity.getStock());
		st.setLong(6, entity.getMarcaId());
		st.setLong(7, entity.getCategoriaId());


	}

	@Override

	public String getSaveSQL() {
		return ("(titulo,codigo,fecha_creacion,precio,stock,marcas_id,categorias_id) values (?,?,?,?,?,?,?)");
	}
	
	public List<Articulos> findBySQL(String whereSQL) throws GenericException{
		String where = "select * from articulos where titulo like '%"+whereSQL+"%'";
		return super.findBySQL(where);
		
	}

}
