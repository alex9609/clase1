package ar.com.educacionit.domain;

import ar.com.educacionit.dao.impl.SocioDaoImpl;

public class FindAllSociosTest {
	
	public static void main(String[] args) {
		
		SocioDaoImpl socioImpl = new SocioDaoImpl();
		
		Socios[] vectorDeSocio = socioImpl.findAll();
		
		for(Socios socio: vectorDeSocio) {
			System.out.println(socio);
		}
		
	}

}
