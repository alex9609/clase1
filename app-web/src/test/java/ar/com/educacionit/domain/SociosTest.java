package ar.com.educacionit.domain;

import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.Impl.CategoriaServiceImpl;
import ar.com.educacionit.services.Impl.SociosServicesImpl;
import ar.com.educacionit.services.exceptions.ServiceException;

public class SociosTest {

	public static void main(String[] args) throws ServiceException {
		Long id = 1L;
		String nombre = "Juan";
		String apellido = "Rodriguez";
		String email = "alexander10@gmail.com";
		String direccion = "calle 12";
		Long pais = 1L;
		
		
		SociosService service = new SociosServicesImpl();
		Socios socio = new Socios(nombre,apellido,email,direccion,pais);
		service.save(socio);
		
		CategoriaService cservice = new CategoriaServiceImpl();
		Categorias categorias = new Categorias("TELEVISORES","ADASA445");
		cservice.save(categorias);
		
		
	}

}
