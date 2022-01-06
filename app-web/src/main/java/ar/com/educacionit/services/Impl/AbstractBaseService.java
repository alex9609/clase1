package ar.com.educacionit.services.Impl;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.services.GenericService;

public class AbstractBaseService<T> implements GenericService<T> {
	
	protected GenericDao<T> genericDao;
	
	public AbstractBaseService(GenericDao<T> dao) {
		this.genericDao = dao;
	}

	public T getOne(Long id) {
		return genericDao.getOne(id) ;
	}

	public void delete(Long id) {
		genericDao.delete(id);
	}

	public T save(T entity) {
		return genericDao.save(entity);
	}

	public void update(T entity) {
		genericDao.update(entity);
	}

	public T[] findAll() {
		return genericDao.findAll();
	}

	
}
