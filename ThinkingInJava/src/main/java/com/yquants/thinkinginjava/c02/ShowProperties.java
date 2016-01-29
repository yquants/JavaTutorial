package com.yquants.thinkinginjava.c02;

/**
 * The Chapter2 Samples in Thinking in Java
 * 
 * @author Wei Song
 * @version 4th
 *
 */
public class ShowProperties {

	public static void main(String[] args) {
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
	}
}
