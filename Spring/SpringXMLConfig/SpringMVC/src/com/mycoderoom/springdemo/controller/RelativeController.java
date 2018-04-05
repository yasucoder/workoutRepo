package com.mycoderoom.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funny")
public class RelativeController {

	@RequestMapping("/login")
	public String loginpage() {
		return "login";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "successlogin";
	}

}
