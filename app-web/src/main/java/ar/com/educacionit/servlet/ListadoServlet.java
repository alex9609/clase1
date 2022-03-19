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

/*
 * 
 * Los servlet no tienen el metodo main, porque no son 
 * de tipo consola, sino web
 * 
 * Extiende de HttpServlet: que contienen 
 * 
 * Es una anotación 
 */
@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {  

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LLege al servlet /listado que atiende por POST");
		resp.getWriter().print("Hola frontend soy el backend desde el post");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArticulosService articuloService = new ArticulosServiceImpl();
		
		try {
			List<Articulos> articulos = articuloService.findAll();
			//Guardar el listado en un lugar llamdo request
			
			req.setAttribute("Listado", articulos);
			
			//Ahora ve a la otra pagina y pasale la lista de articulos
			getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
		} catch (ServiceException | GenericException e) {
			e.printStackTrace();
		}
		
	}
}
