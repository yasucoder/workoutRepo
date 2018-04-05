package com.mycoderoom.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String loginpage() {
		return "login";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "successlogin";
	}

	@RequestMapping("/processloginForm")
	public String processForm(HttpServletRequest request, Model model) {

		String uname = request.getParameter("username");
		List<String> theStudentList = new ArrayList<String>();
		String theShoppingCart = "TheShoppingCart";
		uname = uname.toUpperCase();

		String result = "Yo!" + uname;

		model.addAttribute("message", result);
		model.addAttribute("Student", theStudentList);
		model.addAttribute("shoppingCart", theShoppingCart);

		return "successlogin";
	}

	@RequestMapping("//processloginFormVersionThree")
	public String processFormV3(@RequestParam("username") String theName,
			Model model) {

		model.addAttribute("Msg", theName);
		return "successlogin";
	}

}
