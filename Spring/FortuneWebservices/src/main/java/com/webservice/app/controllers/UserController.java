package com.webservice.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.webservice.app.model.ConsumeDetails;
import com.webservice.app.services.UserMaintainService;


@RestController
public class UserController {
	
	@GetMapping(value = "/user/test")
    public String userLogin(){
        return "Welcome User";
    }
	
	@RequestMapping(value = "/user/listall", method = RequestMethod.POST)
	public ConsumeDetails processXMLJsonRequest(@RequestBody ConsumeDetails consumedetails) {
		
		UserMaintainService obscureservice = new UserMaintainService(consumedetails);
		return obscureservice.runcompute();
		

		
	}

}
