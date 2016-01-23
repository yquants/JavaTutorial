package com.yquants.spring.tutorial.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

	private MessageService mservice;

	@Autowired
	public MessagePrinter(MessageService mservice) {
		this.mservice = mservice;
	}

	public void printMessage() {
		System.out.println(this.mservice.getMessage());
	}
}
