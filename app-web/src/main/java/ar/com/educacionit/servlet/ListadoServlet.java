package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.Impl.ArticulosServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.web.enums.ViewKeysEnum;

/*
 * 
 * Los servlet no tienen el metodo main, porque no son 
 * de tipo consola, sino web
 * 
 * Extiende de HttpServlet: que contienen 
 * 
 * Es una anotación 
 */
@WebServlet("/controllers/ListadoServlet")
public class ListadoServlet extends HttpServlet {  

	@Override
	protected void doPost(HttpServletRequest entrada, HttpServletResponse salida) throws ServletException, IOException {
		System.out.println("LLege al servlet /listado que atiende por POST");
		salida.getWriter().print("Hola frontend soy el backend desde el post");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArticulosService articuloService = new ArticulosServiceImpl();
		
		try {
			List<Articulos> articulos = articuloService.findAll();
			//Guardar el listado en un lugar llamdo request
			
			request.setAttribute(ViewKeysEnum.LISTADO.getParam(), articulos);
			
			//Ahora ve a la otra pagina y pasale la lista de articulos
			getServletContext().getRequestDispatcher("/listado.jsp").forward(request, response);
		} catch (ServiceException | GenericException e) {
			e.printStackTrace();
		}
		
	}
}
