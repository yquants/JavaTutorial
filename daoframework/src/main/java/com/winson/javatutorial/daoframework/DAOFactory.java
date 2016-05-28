package com.winson.javatutorial.daoframework;

import com.winson.javatutorial.daoframework.impl.UserDaoImpl;

public class DAOFactory {

	public static enum DAOType{
	USER_DAO	
	}
	
	public static DAO<?> getDAO(DAOType type){
		switch(type){
		case USER_DAO:
			return UserDaoImpl.getInstance();
		}
		
		return null;
	}
}
