package ar.com.educacionit.dao;

import ar.com.educacionit.domain.Socios;

public interface ICrud {
	
	public Socios create(Socios socioCrear);
	
	public Socios findByID(Long id);
	
	public Socios[] findAll();
	
	
}
