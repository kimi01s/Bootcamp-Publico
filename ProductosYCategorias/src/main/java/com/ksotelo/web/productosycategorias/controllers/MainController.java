package com.ksotelo.web.productosycategorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ksotelo.web.productosycategorias.services.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainServ;
	@GetMapping("/")
	public String redirect() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("productos", mainServ.showAll());
		return"index.jsp";
	}
}