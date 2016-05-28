package com.winson.javatutorial.daoframework;

import java.sql.Connection;

public interface ConnectionManager {

	public Connection getConnection() throws DAOException;
	
	public void startTransaction(Connection con)throws DAOException;
	
	public void commit(Connection con) throws DAOException;
	
	public void commitAndClose(Connection con) throws DAOException;
	
	public void rollback(Connection conn) throws DAOException;
	
	public void rollbackAndClose(Connection conn) throws DAOException;
	
	public void close(Connection con) throws DAOException;
}
