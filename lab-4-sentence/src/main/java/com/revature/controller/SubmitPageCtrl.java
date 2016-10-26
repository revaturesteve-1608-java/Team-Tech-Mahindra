package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SubmitPageCtrl {
	
	@RequestMapping(value="/submitHome", method=RequestMethod.GET)
	public String submitHome() {
		
		return "submit.html";
	}
}
