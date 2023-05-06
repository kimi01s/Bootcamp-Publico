package com.sotelo.web.cadenas.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	@RequestMapping("/")
	public String inicio() {
		return "Hello client! How are you doing?";
	}
	@RequestMapping("/random")
	public String random() {
		return "Spring boot is great! So easy to just respond with strings";
	}
	
}
