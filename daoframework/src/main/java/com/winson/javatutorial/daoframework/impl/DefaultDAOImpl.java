package com.winson.javatutorial.daoframework.impl;

import java.sql.Connection;
import java.util.Collection;

import com.winson.javatutorial.daoframework.DAO;
import com.winson.javatutorial.daoframework.DAOException;

public class DefaultDAOImpl<T> implements DAO<T> {
	
	private ThreadLocal<Connection> connLocal = new ThreadLocal<Connection>();
	
	public void setConnection(Connection connection) throws DAOException{
		if (connLocal.get() != null)
			throw new DAOException();
		this.connLocal.set(connection);
	}
	
	protected Connection getConnection()throws DAOException{
		Connection connection = connLocal.get();
		if (connLocal.get() == null)
			throw new DAOException();
		return connection;
	}

	public boolean add(T t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(T t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(T... t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public T findOne(T t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<T> find(T t) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(T t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(T... t) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
}
