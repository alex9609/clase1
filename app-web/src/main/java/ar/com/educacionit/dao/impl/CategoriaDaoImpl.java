package ar.com.educacionit.dao.impl;

import java.util.List;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Socios;

public class CategoriaDaoImpl extends JdbcDaoBase<Categorias> implements CategoriaDao{
	
	public CategoriaDaoImpl() {
		super("Categorias");
	}
	

	public String getSaveSQL(Categorias entity) {
		//Lo particupar del sql
	//(campo1, campo2, campoN)
	//values
	//(value1,value2,valueN)

	return ("(descripcion,codigo) values("+entity.getDescripcion() +  "," + entity.getCodigo()+")"); 
}

@Override

public String getUpdateSQL(Categorias entity) {
	String sql = "Descripcion='"+entity.getDescripcion()+"',"
	+"Codigo='"+entity.getCodigo()+"'";
	return sql;
} 
	

}
