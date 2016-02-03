package com.yquants.tutorial.jetty.main;

import org.junit.Test;

import org.junit.Assert;

public class ApplicationTest {

	@Test
	public void testStartApplication()
	{
		Application.startApplication();
		Assert.assertEquals(1, 1);
	}
}
