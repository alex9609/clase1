package ar.com.educacionit.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.Impl.ArticulosServiceImpl;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/EliminarProductoServlet")
public class EliminarProductoServlet extends BaseServlet{
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter(ViewKeysEnum.ID_PRODUCTO.getParam());
		
		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		Long idLong = Long.parseLong(id);
		
		Collection<Articulos> artInSession = (Collection<Articulos>)req.getSession().getAttribute(ViewKeysEnum.LISTADO.getParam());
		ArticulosService service = new ArticulosServiceImpl();
		
		try {
			service.delete(idLong);
			//mensaje
			super.addAttribute(req, ViewKeysEnum.EXITO, "Se ha eliminado el articulo con id="+idLong);
			
			artInSession = artInSession.stream().filter(x -> !x.getId().equals(idLong)).collect(Collectors.toList());
		}catch(ServiceException e) {
			super.addAttribute(req, ViewKeysEnum.ERROR_GENERAL, e.getMessage());			
		}finally {
			addAttribute(req.getSession(), ViewKeysEnum.LISTADO, artInSession);
			Double total = artInSession.stream()
					.map(x -> x.getPrecio())
					.reduce(0d, (x,y) -> x+y);	
			addAttribute(req.getSession(), ViewKeysEnum.TOTAL, total);
		}
		
		super.redirect(target, req, resp);
		
	}

}
