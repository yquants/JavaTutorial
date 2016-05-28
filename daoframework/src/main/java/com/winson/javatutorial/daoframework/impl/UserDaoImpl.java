package com.winson.javatutorial.daoframework.impl;

import com.winson.javatutorial.daoframework.DAOException;
import com.winson.javatutorial.vo.User;

public class UserDaoImpl extends DefaultDAOImpl<User> {

	private static UserDaoImpl INSTANCE;
	
	public static UserDaoImpl  getInstance() throws DAOException {
		if (INSTANCE == null)
			INSTANCE = new UserDaoImpl();
		return INSTANCE;
	}
	
	private UserDaoImpl(){};
	
	public boolean add(User user) throws DAOException {
		super.getConnection();
		System.out.println("Adding a new user object!");
		return true;
	}

}
