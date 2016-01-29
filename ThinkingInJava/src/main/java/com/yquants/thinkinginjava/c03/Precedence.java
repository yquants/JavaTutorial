package com.yquants.thinkinginjava.c03;

import static com.yquants.thinkinginjava.util.Print.*;
/**
 * A sample in Chapter3 of Thinking in Java
 * 
 * @version 4th Edition
 * @author Wei Song
 *
 */
public class Precedence {

	public static void main(String[] args) {
		int x = 1, y = 2, z = 3;
		int a = x + y - 2 / 2 + z;
		int b = x + (y - 2) / (2 + z);

		println("a = " + a + " b = " + b);
	}
}
