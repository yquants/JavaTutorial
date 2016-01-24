package com.yquants.turorial.jse.junit;

import org.junit.Test;
import org.junit.Assert;

/**
 * A simple JUnit test class, which uses Assert.assertXXXX()
 * Note: the Assert should be imported from org.junit.Assert package.
 * To run it as:
 * Right Click -> Run As -> JUnit Test (in eclispe) or:
 * java -cp .;junit-4.XX.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest
 * @author Winson
 *
 */
public class CalculatorTest {

	@Test
	public void evaluatesExpression()
	{
		Calculator cal = new Calculator();
		int sum = cal.evaluate("1+2+3");
		Assert.assertEquals(6, sum);
	}
	
	@Test
	public void evaluatesNull()
	{
		Calculator cal = new Calculator();
		int sum = cal.evaluate(null);
		Assert.assertEquals("Calculation Failure",7, sum);
	}
}
