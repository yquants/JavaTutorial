package com.winson.javatutorial.daoframework;

import java.sql.Connection;
import java.util.Collection;

public interface DAO<T> {

	public void setConnection(Connection connection) throws DAOException;
	
	public boolean add(T t) throws DAOException;
	
	public boolean update(T t) throws DAOException;
	
	public boolean update(T... t) throws DAOException;
	
	public T findOne(T t) throws DAOException;
	
	public Collection<T> find(T t) throws DAOException;
	
	public boolean delete(T t) throws DAOException;
	
	public boolean delete(T... t) throws DAOException;
}
