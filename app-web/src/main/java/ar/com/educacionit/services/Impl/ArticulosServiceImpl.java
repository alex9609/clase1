package ar.com.educacionit.services.Impl;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.dao.MarcaDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ArticuloDaoImpl;
import ar.com.educacionit.dao.impl.CategoriaDaoImpl;
import ar.com.educacionit.dao.impl.MarcasDaoImpl;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ArticulosServiceImpl extends AbstractBaseService<Articulos> implements ArticulosService {

	//Usor otros daos
	private CategoriaDao categoriaDao;
	private MarcaDao marcasDao;
	
	public ArticulosServiceImpl() {
		super(new ArticuloDaoImpl());
		
		this.categoriaDao = new CategoriaDaoImpl();
		this.marcasDao = new MarcasDaoImpl();
	}
	
	public Articulos getOne(Long id) throws ServiceException{
		try {
			
			Articulos articulo = this.genericDao.getOne(id);
			Marcas marcaDelArticulo = this.marcasDao.getOne(articulo.getMarcaId());
			Categorias catergoriaDelArticulo = this.categoriaDao.getOne(articulo.getCategoriaId());
			
			articulo.setMarca(marcaDelArticulo);
			articulo.setCategoria(catergoriaDelArticulo);
			
			return articulo;			
		}catch(GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
