package ar.com.educacionit.jdbc;

import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.Impl.CategoriaServiceImpl;
import ar.com.educacionit.services.Impl.SociosServicesImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

public class MainJDBC3 {
	public static void main(String[] args) throws GenericException, SQLException, ServiceException {
		
		CategoriaService cs = new CategoriaServiceImpl();	
		
		List<Categorias> lista = cs.findAll();
		System.out.println(lista);
		
		
		SociosService ss = new SociosServicesImpl();
		List<Socios> listsoc = ss.findAll();
		
		System.out.println(listsoc);
		
		
		cs.delete(null);
		
		
	}
}
