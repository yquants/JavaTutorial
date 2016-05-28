package com.winson.javatutorial.service;

import java.sql.Connection;

import com.winson.javatutorial.daoframework.DAO;
import com.winson.javatutorial.daoframework.DAOFactory;
import com.winson.javatutorial.daoframework.DAOFactory.DAOType;
import com.winson.javatutorial.daoframework.impl.ConnectionManagerImpl;
import com.winson.javatutorial.vo.User;

public class UserService {

	public boolean addUser(User... user){
//		System.out.println("1111");
		DAO<?> dao = DAOFactory.getDAO(DAOType.USER_DAO);
		DAO<User> userDao = (DAO<User>)dao;
		
		Connection conn = ConnectionManagerImpl.INSTANCE.getConnection();
		userDao.setConnection(conn);
		for (User u: user){
//			System.out.println("99999");
			userDao.add(u);
		}
		
		ConnectionManagerImpl.INSTANCE.commitAndClose(conn);
		return true;
	}
}
