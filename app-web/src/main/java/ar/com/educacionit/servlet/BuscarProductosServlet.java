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
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/BuscarProductosServlet")
public class BuscarProductosServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String claveBusqueda = req.getParameter(ViewKeysEnum.CLAVE_BUSQUEDA.getParam());
		if (claveBusqueda == null) {
			claveBusqueda = "";
		}
		ArticulosService service = new ArticulosServiceImpl();

		try {
			List<Articulos> listado = service.findAllBy(claveBusqueda);
			req.getSession().setAttribute(ViewKeysEnum.LISTADO.getParam(), listado);
			getServletContext().getRequestDispatcher(ViewEnums.LISTADO_GENERAL.getParam()).forward(req,resp);

		} catch (ServiceException e) {
			List<Articulos> listado = new ArrayList<>();
			req.setAttribute("LISTADO", listado);
			getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
		}
	}

}
