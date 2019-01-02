package com.zhangguoye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloworld")
public class HelloWorldController {

	public HelloWorldController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("")
	public String toIndex() {
		return "helloworld/helloworld-index";
	}

}
