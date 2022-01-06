package ar.com.educacionit.domain;

import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.Impl.CategoriaServiceImpl;
import ar.com.educacionit.services.Impl.SociosServicesImpl;

public class SociosDaoTest {

	public static void main(String[] args) {
		
		SociosService service = new SociosServicesImpl();
		
		Socios socio = service.getOne(1L);
		System.out.println(socio);
		
		CategoriaService cservice = new CategoriaServiceImpl();
		Categorias categoria = cservice.getOne(2L);
		System.out.println(categoria);
		
		
		
	}

}
