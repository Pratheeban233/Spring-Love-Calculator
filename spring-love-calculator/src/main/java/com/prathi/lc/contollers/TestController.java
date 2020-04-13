package com.prathi.lc.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	// @ResponseBody
	@RequestMapping("/test")
	public String sayHello() {
		// return "Hey its working....";
		return "hello-world";

	}
}
