package ar.com.educacionit.web.practicaAdicionalSemana15;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.practicaAdicionalSemana15.Domain.Empleado;

@WebServlet("/semana15")
public class Semana15Servlet extends HttpServlet {
	
	private Map<Long,Empleado> DB = new HashMap<Long,Empleado>();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getSession().setAttribute("listaCargos",listaCargos);
		String documento = req.getParameter("documento");
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String edad = req.getParameter("edad");
		String ocupacion = req.getParameter("ocupacion");
		String fechaNacimiento = req.getParameter("fechaNacimiento");
		
		String error = "error";
		String mensajeError = null;
		boolean existeError = false;
		
		if(documento.isEmpty() || Long.parseLong(documento) < 0) {
			if(documento.isEmpty()) {
				mensajeError = "Campo de Documento está vacío";
			}else {
				mensajeError = "El documento no puede ser negativo";
			}
			existeError = true;
		}else if(nombre.isEmpty()) {
			mensajeError = "Campo de nombre vacío";
			existeError = true;
		}else if(apellido.isEmpty()) {
			mensajeError = "Campo de apellido vacío";
			existeError = true;
		}else if(edad.isEmpty() || Long.parseLong(edad) < 15) {
			if(edad.isEmpty()) {
				mensajeError = "Campo de edad vacío";
			}else {
				mensajeError = "La edad no puede ser negativa";
			}
			existeError = true;
		}else if(fechaNacimiento.isEmpty()) {
			mensajeError = "Campo de fecha vacío";
			existeError = true;
		}
		
		
		if(existeError) {
			req.setAttribute(error, mensajeError);
			getServletContext().getRequestDispatcher(("/Semana15JSP/ErrorSemana15.jsp")).forward(req, resp);
		}else {
			Empleado nuevoEmpleado = new Empleado(Long.parseLong(documento), nombre, apellido, Long.parseLong(edad), ocupacion, fechaNacimiento);
			if(!this.DB.containsKey(Long.parseLong(documento))) {
				this.DB.put(Long.parseLong(documento), nuevoEmpleado);
				req.setAttribute("empleado", nuevoEmpleado);
				getServletContext().getRequestDispatcher(("/Semana15JSP/DatosSemana15.jsp")).forward(req, resp);
			}else {
				req.setAttribute(error, "El usuario con numero de documento : " + documento + " ya esta registrado");
				getServletContext().getRequestDispatcher(("/Semana15JSP/ErrorSemana15.jsp")).forward(req, resp);
			}
		}
		
		
		
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!this.DB.isEmpty()) {
			req.setAttribute("mapa", this.DB);
			getServletContext().getRequestDispatcher(("/Semana15JSP/ListadoDatosSemana15.jsp")).forward(req, resp);
		}else {
			getServletContext().getRequestDispatcher(("/Semana15JSP/ListadoDatosVacio.jsp")).forward(req, resp);
		}	
	}

}
