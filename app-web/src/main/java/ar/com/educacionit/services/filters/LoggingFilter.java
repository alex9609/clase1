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
@WebFilter(filterName = "/LoggingFilter", urlPatterns = "/*")
public class LoggingFilter implements Filter {

	// FilterChain cadena de ejecución donde se van a ejecutar varios filtro
	// Ejecutar desde el primero hasta el último filtro
	// El orden de ejecucipon lo pdemos dar

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 1. Obtener usuario de la session

		// 2. URL "donde vamos" (/controler/AlgunServlet)
		HttpServletRequest req = (HttpServletRequest) request; // Casteo ára poder usar el metodo geetRequestURI
		
		System.out.println("LogginFilter: "+req.getParameterMap().toString());
		chain.doFilter(request, response);
		// 4- Logica
	}

}
