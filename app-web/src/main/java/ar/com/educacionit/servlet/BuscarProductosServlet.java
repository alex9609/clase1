package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/controllers/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArticulosService service = new ArticulosServiceImpl();
		
		try {
			List<Articulos> lista =service.findAll();
			
			req.setAttribute("Listado", lista);	
			getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
		} catch (ServiceException | GenericException e) {
			List<Articulos> listado = new ArrayList<>();
			req.setAttribute("Listado", listado);	
			getServletContext().getRequestDispatcher("/loginSuccess.jsp").forward(req, resp);
		}
		super.doGet(req, resp);
	}

}
