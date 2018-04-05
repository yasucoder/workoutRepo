package com.mycoderoom.springdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycoderoom.springdemo.model.Renter;

@Controller
@RequestMapping("/renter")
public class RenterController {

	// ass an initbinder.. to convert tri inpur strings
	@InitBinder
	public void intiBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showform")
	public String showform(Model themodel) {
		// Create a student object
		Renter theEmp = new Renter();
		// add student object to the model
		themodel.addAttribute("renter", theEmp);

		return "renter_enroll_form";
	}

	@RequestMapping("/processform")
	public String processform(
			@Valid @ModelAttribute("renter") Renter theRenter,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "renter_enroll_form";
		} else {
			return "renter-confrimation";
		}
	}

}
