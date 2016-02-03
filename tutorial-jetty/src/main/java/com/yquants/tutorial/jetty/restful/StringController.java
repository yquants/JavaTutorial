package com.yquants.tutorial.jetty.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/string")
public class StringController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	@ResponseBody
	public String getIndexString()
	{
		return "Hello World";
	}
}
