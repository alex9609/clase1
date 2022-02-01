package ar.com.educacionit.jdbc;

import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.Impl.CategoriaServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

public class MainJDBC4 {

	public static void main(String[] args) throws ServiceException {
		
		CategoriaService cs = new CategoriaServiceImpl();	
		cs.delete(2l);
		System.out.println("fin");
	}

}
