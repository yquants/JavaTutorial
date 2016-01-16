package com.yquants.drools;

public class Message {
	
	public static final String HELLO = "Hello";
	public static final String GOODBYE = "Goodbye";
	
	private String message;
	
	public Message(String msg)
	{
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
