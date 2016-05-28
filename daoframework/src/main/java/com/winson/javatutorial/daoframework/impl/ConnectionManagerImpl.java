package com.winson.javatutorial.daoframework.impl;

import java.sql.Connection;

import com.winson.javatutorial.daoframework.ConnectionManager;
import com.winson.javatutorial.daoframework.DAOException;
import com.winson.javatutorial.daoframework.DummyConnection;

public class ConnectionManagerImpl implements ConnectionManager {

	public static final ConnectionManagerImpl INSTANCE = new ConnectionManagerImpl();
	
	private ConnectionManagerImpl()
	{
		
	}
	
	private static int count = 0;
	
	public Connection getConnection() throws DAOException {
		// TODO Auto-generated method stub
		System.out.println("Connection:#" + count ++);
		
		return new DummyConnection();
	}

	public void startTransaction(Connection con) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void commit(Connection con) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void commitAndClose(Connection con) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void rollback(Connection conn) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void rollbackAndClose(Connection conn) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void close(Connection con) throws DAOException {
		// TODO Auto-generated method stub

	}

}
