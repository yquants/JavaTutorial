package com.yquants.turorial.jse.junit;

public class Calculator {

	public int evaluate(String command) {
		int sum = 0;
		for (String str : command.split("\\+"))
			sum += Integer.valueOf(str);
		return sum;
	}
}
