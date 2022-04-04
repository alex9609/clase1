package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.web.enums.ViewKeysEnum;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Limpiar los datos de la sesion
		req.getSession().removeAttribute(ViewKeysEnum.USER.getParam());
		//Invalidar la sesion que se guarda
		req.getSession().invalidate();
		//Redirect al home
		resp.sendRedirect(getServletContext().getContextPath());
	}

}
