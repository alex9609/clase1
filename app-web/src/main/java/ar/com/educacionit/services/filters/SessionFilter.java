package ar.com.educacionit.services.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.web.enums.ViewKeysEnum;

//Es un filtro para darle un poco de seguridad a nuestro programa
//@WebFilter(filterName = "/SessionFilter", urlPatterns="/controllers/*")
public class SessionFilter implements Filter{
	
	//FilterChain cadena de ejecución donde se van a ejecutar varios filtro
	//Ejecutar desde el primero hasta el último filtro
	//El orden de ejecucipon lo pdemos dar

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//1. Obtener usuario de la session 
		
		//2. URL "donde vamos" (/controler/AlgunServlet)
		HttpServletRequest req = (HttpServletRequest) request; //Casteo ára poder usar el metodo geetRequestURI
//		String url = req.getRequestURI(); //http://localhost:8080/app-web/
//		String contextPath = req.getContextPath();
		//3- definir rutas o url al las cuales no se aplican este filtro
		//Listas de URL a interceptar
		/*
		List<String> validatePath = Arrays.asList(req.getContextPath()+"/controllers/");
		
		boolean mustValidate = false;
		for(String path : validatePath) {
			if(url.contains(path)) {
				mustValidate = true;
				break;
			}
		}
		/*
		for(int i = 0; !mustValidate && i < validatePath.size();i++) {
			validatePath.contains(url);
		}
		*/
		//Stream
		//boolean validate = validatePath.stream().filter(x -> url.contains(x)).count() > 0;
		HttpSession session = req.getSession(false);
//		if(mustValidate) {
			if(session == null) {
				req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), "Debe loguearse");
				req.getRequestDispatcher("/Login.jsp").forward(request, response);
			}else {
				Users loggedUser = (Users)req.getSession().getAttribute(ViewKeysEnum.USER.getParam());
				
				if(loggedUser != null) {
					//dejo que acceda al /controller/AlgunServlet solicitaod
					chain.doFilter(request, response);
				}else {
					req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), "Debe loguearse");
					req.getRequestDispatcher("/Login.jsp").forward(request, response);
					
				}
				
			}
//		}else {
//			chain.doFilter(request, response);
//		}
		//4- Logica 
	}

}
