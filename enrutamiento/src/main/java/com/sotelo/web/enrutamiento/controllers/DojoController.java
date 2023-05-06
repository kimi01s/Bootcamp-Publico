package com.sotelo.web.enrutamiento.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

	@RequestMapping("/{dojo}")
	public String dojo(@PathVariable("dojo") String dojo) {
		return "¡El " + dojo + " es increíble!";
	}

	@RequestMapping("/burbank-{dojo}")
	public String burbankDojo(@PathVariable("dojo") String dojo) {
		return "¡El " + dojo + " Burbank está localizado al sur de California";
	}

	@RequestMapping("/san-{jose}")
	public String sanJose(@PathVariable("jose") String jose) {
		return "El Dojo San " + jose + " es el cuartel general";
	}
}
