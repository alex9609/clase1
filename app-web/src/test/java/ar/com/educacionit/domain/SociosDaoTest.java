package ar.com.educacionit.domain;

import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.Impl.CategoriaServiceImpl;
import ar.com.educacionit.services.Impl.SociosServicesImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

public class SociosDaoTest {

	public static void main(String[] args) {
		
		SociosService service = new SociosServicesImpl();
		
		Socios socio = null ;
		try {
			socio = service.getOne(null);
		} catch (ServiceException se) {
			String msjDeService = se.getMessage();
			System.err.println(msjDeService);
			//Quiero la causa que origino se
			Throwable cause = se.getCause();
			//Una vez que tengo la causa puedo 
			String msjCause = cause.getMessage();
			System.err.println(msjCause);
		}
		
		System.out.println(socio);	
		CategoriaService cservice = new CategoriaServiceImpl();
		Categorias categoria = null;
		try {
			categoria = cservice.getOne(2L);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		System.out.println(categoria);
		
		
		
	}

}
