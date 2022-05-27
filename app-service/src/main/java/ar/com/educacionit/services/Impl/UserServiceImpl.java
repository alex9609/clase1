package ar.com.educacionit.services.Impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.impl.SocioDaoImpl;
import ar.com.educacionit.dao.impl.UserDaoImpl;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class UserServiceImpl implements LoginService{

	private UserDao userDao;
	private SociosDao socioDao;
	
	
	
	public UserServiceImpl() {
		this.userDao = new UserDaoImpl();
		this.socioDao = new SocioDaoImpl();
	}



	@Override
	public Users getUserByUserNameAndPassword(String username, String password) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
