package com.yquants.springtutorial.aop;

import org.springframework.stereotype.Component;

/**
 * Register with @Component annotation to let it to inject to other beans
 * @author Administrator
 *
 */
@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	public int add(int i, int j) {
		return i + j;
	}

	public int sub(int i, int j) {
		return i - j;
	}

	public int multiple(int i, int j) {
		return i * j;
	}

	public int divide(int i, int j) {
		return i/j;
	}

}
