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
import ar.com.educacionit.web.enums.ViewKeysEnum;
import ar.com.educacionit.web.enums.ViewEnums;
import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Capturar los parametros
		// Tenemos todos los parametros en el request req.getParameter("parametro")
		String usernameFromHtml = req.getParameter(ViewKeysEnum.USERNAME.getParam());
		String passwordFromHtml = req.getParameter(ViewKeysEnum.PASSWORD.getParam());
		ViewEnums target = ViewEnums.LOGIN_SUCCESS;

		// Validaciones si los datos están vacios
		if (isValid(usernameFromHtml, passwordFromHtml) ) {
			// Usar capa de servicio para loggearme
			// Login Service
			LoginService ls = new LoginServiceImpl();

			Users user;

			try {
				user = ls.getUserByUserNameAndPassword(usernameFromHtml, passwordFromHtml);
				if (user == null) {
					req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(),
							ViewKeysEnum.USUARIO_PASSWORD_INVALIDADO.getParam());
					target = ViewEnums.LOGIN;
				} else {
					// request
					req.setAttribute("usuario", user);

					// session
					req.getSession().setAttribute(ViewKeysEnum.USER.getParam(), user);
				}
			} catch (ServiceException e) {
				req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(), e.getMessage());
				target = ViewEnums.LOGIN;
			}
		} else {
			req.setAttribute(ViewKeysEnum.ERROR_GENERAL.getParam(),
					ViewKeysEnum.USUARIO_PASSWORD_INVALIDADO.getParam());
			target = ViewEnums.LOGIN;
		}
		// Ir a target
		getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);
	}

	private boolean isValid(String usernameFromHtml, String passwordFromHtml) {
		return (usernameFromHtml != null && !usernameFromHtml.isBlank()) && (passwordFromHtml != null && !passwordFromHtml.isBlank());
	}
}
