package ar.com.educacionit.services.Impl;

import ar.com.educacionit.dao.impl.SocioDaoImpl;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.services.SociosService;

public class SociosServicesImpl extends AbstractBaseService<Socios> implements SociosService {
	
	
	public SociosServicesImpl() {
		super(new SocioDaoImpl());
	}
	
}
