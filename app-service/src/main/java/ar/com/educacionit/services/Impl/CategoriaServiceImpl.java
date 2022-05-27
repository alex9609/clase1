package ar.com.educacionit.services.Impl;
import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.dao.impl.CategoriaDaoImpl;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.services.CategoriaService;


public class CategoriaServiceImpl extends AbstractBaseService<Categorias> implements CategoriaService {
	
	//private CategoriaDao dao;
	
	public CategoriaServiceImpl() {
		super(new CategoriaDaoImpl());
	}
	
	/*
	
	public Categorias getOne(Long id) {
		return dao.getOne(id);
	}

	public void delete(Long id) {
		dao.delete(id);
	}

	public Categorias save(Categorias entity) {
		return dao.save(entity);
	}

	public void update(Categorias entity) {
		dao.update(entity);
	}

	public Categorias[] findAll() {
		return dao.findAll();
	}
*/
	
	

}
