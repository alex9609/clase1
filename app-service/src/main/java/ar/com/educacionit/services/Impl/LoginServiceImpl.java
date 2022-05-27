package ar.com.educacionit.services.Impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.SocioDaoImpl;
import ar.com.educacionit.dao.impl.UserDaoImpl;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class LoginServiceImpl implements LoginService {

	private UserDao userDao;
	private SociosDao socioDao;

	public LoginServiceImpl() {
		this.userDao = new UserDaoImpl();
		this.socioDao = new SocioDaoImpl();
	}

	@Override
	public Users getUserByUserNameAndPassword(String username, String passwordFromHtml) throws ServiceException {
		try {
			Users user = this.userDao.getUserByUserName(username);

			if (user != null) {
				// Hash password que viene del hhtml y compararlo con el que tiene el usuario
				BCrypt.Result result = BCrypt.verifyer().verify(passwordFromHtml.getBytes(),
						user.getPassword().getBytes());

				if (!result.verified) {
					throw new ServiceException("Credenciales incorrectas", null);
				}
				Socios socio = this.socioDao.getSociosByUserId(user.getId());
				user.setSocio(socio);
			}
			return user;
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}