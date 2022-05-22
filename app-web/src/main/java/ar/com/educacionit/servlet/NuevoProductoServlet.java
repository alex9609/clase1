package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.MarcasService;
import ar.com.educacionit.services.Impl.ArticulosServiceImpl;
import ar.com.educacionit.services.Impl.CategoriaServiceImpl;
import ar.com.educacionit.services.Impl.MarcasServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/NuevoProductoServlet")
public class NuevoProductoServlet extends BaseServlet{
	
	private MarcasService marcaService = new MarcasServiceImpl();
	private CategoriaService categoriaService = new CategoriaServiceImpl();
	private ArticulosService service = new ArticulosServiceImpl();

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Collection<Marcas> marcas = new ArrayList<>();
		Collection<Categorias> categorias = new ArrayList<>();
		try {
			marcas = this.marcaService.findAll();
			categorias = this.categoriaService.findAll();		
		} catch (ServiceException | GenericException e) {
			System.err.println(e);
		}finally {
			addAttribute(req.getSession(),ViewKeysEnum.CATEGORIAS, categorias);
			addAttribute(req.getSession(),ViewKeysEnum.MARCAS, marcas);
		}

		//redirect con los datos actualizados (session: lista, total)
		super.redirect(ViewEnums.NUEVO, req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//datos
		String titulo = req.getParameter("titulo");
		String precio = req.getParameter("precio");
		String codigo = req.getParameter("codigo");
		String stock = req.getParameter("stock");
		String marca = req.getParameter("marcas");
		String categoria = req.getParameter("categorias");

		try {
			//nuevo articulo actualizado
			Articulos art = new Articulos(titulo, codigo, Double.parseDouble(precio), Long.parseLong(stock), Long.parseLong(marca), Long.parseLong(categoria));

			this.service.save(art);

			super.addAttribute(req, ViewKeysEnum.EXITO, "Alta exitosa id:" + art.getId());
		} catch (ServiceException e) {
			super.addAttribute(req, ViewKeysEnum.ERROR_GENERAL, e.getMessage());
		} 

		super.redirect(ViewEnums.NUEVO, req, resp);
	}
	
}
