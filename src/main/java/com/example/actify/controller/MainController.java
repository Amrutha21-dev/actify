package com.example.actify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/")
	public String getHomePage() {
		//View is mapped based on thymeleaf dependency. Otherwise we will get a 404
		return "index";
	}

}
