package com.yquants.tutorial.jetty.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	public static void startApplication()
	{
		final String contextFile = "spring-root-config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(contextFile);
		context = null;
	}

	public static void main(String[] args){
		Application.startApplication();
	}
}
