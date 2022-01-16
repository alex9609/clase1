package ar.com.educacionit.domain;

import java.util.List;

import ar.com.educacionit.dao.impl.SocioDaoImpl;

public class FindAllSociosTest {
	
	public static void main(String[] args) {
		
		
		SocioDaoImpl socioImpl = new SocioDaoImpl();
		
		List<Socios> ListasDeSocio = socioImpl.findAll();
		
		for(Socios socio: ListasDeSocio) {
			System.out.println(socio);
		}
		
	}

}
