package com.sotelo.web.holaHumano.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@RequestMapping("/")
	public String index(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "lastname", required = false) String lastname) {
		if (name != null) {
			return "Hello " + name;
		}else if(lastname != null) {
			return "Hello" + name + " " + lastname;
		} 
		else {
			return "Hello Human!";
		}
	}
//...

}
