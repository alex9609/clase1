package ar.com.educacionit.services.Impl;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.services.GenericService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class AbstractBaseService<T> implements GenericService<T> {
	
	protected GenericDao<T> genericDao;
	
	public AbstractBaseService(GenericDao<T> dao) {
		this.genericDao = dao;
	}

	public T getOne(Long id) throws ServiceException {
		T entity;
		try {
			entity = genericDao.getOne(id) ;
		} catch (GenericException e) {
			//e.printStackTrace();
			throw new ServiceException("Error de DB al intentar obtener entity id = " + id,e);
		} finally {
			//Siempre se ejecuta, 
			entity = null;
			
		}
		
		return entity;
	}

	public void delete(Long id) {
		genericDao.delete(id);
	}

	public T save(T entity) throws ServiceException{
		
		try {
			return genericDao.save(entity);
		} catch (DuplicatedException de) {
			de.printStackTrace();
			//Relanzo la exception como una Service Exception que contiene
			// la exception original
			throw new ServiceException("No se ha podido grabar al entidad ", de);
		}
	}

	public void update(T entity) {
		genericDao.update(entity);
	}

	public T[] findAll() {
		return genericDao.findAll();
	}

	
}
