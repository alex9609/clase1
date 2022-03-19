package ar.com.educacionit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.dao.impl.LoginServiceImpl;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.web.enums.LoginViewEnum;
import ar.com.educacionit.web.enums.ViewEnums;
import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Capturar los parametros
		//Tenemos todos los parametros en el request req.getParameter("parametro")
		String usernameFromHtml = req.getParameter(LoginViewEnum.USERNAME.getParam());
		String passwordFromHtml = req.getParameter(LoginViewEnum.PASSWORD.getParam());
		
		//Usar capa de servicio para loggearme
		//Login Service
		LoginService ls = new LoginServiceImpl();
		
		Users user;
		ViewEnums target = ViewEnums.LOGIN_SUCCESS;
		
		try {
			user = ls.getUserByUserName(usernameFromHtml);
			if(user != null) {
				//Hash password que viene del hhtml y compararlo con el que tiene el usuario
				BCrypt.Result result = BCrypt.verifyer().verify(passwordFromHtml.getBytes(), user.getPassword().getBytes());
				
				if(!result.verified) {
					//Enviar al usuario loginSuccess.jsp
					target = ViewEnums.LOGIN;
				}
			}else {
				target = ViewEnums.LOGIN;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			target = ViewEnums.ERROR_GENERAL;
		}
		
		//Ir a target 
		getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);
	}
}
