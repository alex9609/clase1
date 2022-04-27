package ar.com.educacionit.servlet;

import java.io.IOException;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
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
import ar.com.educacionit.web.enums.Enumerable;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/controllers/CargarProductosServlet")
public class CargarProductosServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. Toma los datos de session (que esta dentro del req)
		@SuppressWarnings("unchecked")
		Collection<Articulos> articulosPreview = (Collection<Articulos>) req.getSession()
				.getAttribute(ViewKeysEnum.UPLOAD_PREVIEW_KEY.getParam());

		// Validaciones
//		IValidator validator = ValidatorBuilder.getValidator(ValidatorEnum.ARTICULOS);
//		validator.validate()

		if (articulosPreview == null || articulosPreview.isEmpty()) {
			req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), "No hay datos aprocesar");
			redirect(ViewEnums.UPLOAD_PREVIEW, req, resp);
		}

		ArticulosService service = new ArticulosServiceImpl();

		List<Articulos> oks = new ArrayList<>();
		List<Articulos> fails = new ArrayList<>();
		
		// Persistir los datos en la DB por medio del servicio ArticulosService
		// Recorro la lista e inserto de a uno
		for (Articulos art : articulosPreview) {
			try {
				service.save(art);
				oks.add(art);
			}catch(ServiceException se) {
				fails.add(art);
			}
		}
		
		//Una vez procesado todos los articulos, limpio la session
		req.getSession().removeAttribute(ViewKeysEnum.UPLOAD_PREVIEW_KEY.getParam());
		
		//Guardos las listas en request/session
		req.getSession().setAttribute(Enumerable.ENUMPARAM,ViewKeysEnum.ARTICULOS_FAIL);
		addAttribute(req.getSession(), ViewKeysEnum.ARTICULOS_FAIL, fails);
		addAttribute(req, ViewKeysEnum.ARTICULOS_OKS, oks);
		//redirect
		redirect(ViewEnums.RESULTADO_PREVIEW, req, resp);
	
	}

}
