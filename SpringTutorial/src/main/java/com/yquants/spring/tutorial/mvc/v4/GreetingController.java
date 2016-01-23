package com.yquants.spring.tutorial.mvc.v4;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yquants.spring.tutorial.aop.ArithmeticCalculator;

/**
 * Spring Controller
 * @author Administrator
 *
 */
@Controller
public class GreetingController {

	/*
	 * Only for AOP Testing
	 */
	@Autowired
	private ArithmeticCalculator calculator;
	
	@RequestMapping("/hello.service")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World")String name, Model model){
		/*
		 * It's not necessary to call the method below for the logic of greeting.
		 * Just added here to test Spring AOP
		 */
		testSpringAOP();
		
		model.addAttribute("name", name);
		return "greetings";
	}
	
	/*
	 * This is a JUnit test function
	 */
	@Test
	private void testSpringAOP()
	{
		calculator.divide(1, 0);
	}
}
