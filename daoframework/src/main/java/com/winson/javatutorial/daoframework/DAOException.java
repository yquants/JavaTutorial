package com.winson.javatutorial.daoframework;

public class DAOException extends RuntimeException {

	private static final long serialVersionUID = -1022470303412250787L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, Throwable t) {
		super(message, t);
	}

	public DAOException(Throwable t) {
		super(t);
	}

}
