package com.ksotelo.web.dojooverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ksotelo.web.dojooverflow.services.QuestionService;

@Controller
public class MainController {
	@Autowired
	private QuestionService questionServ;

	@GetMapping("/")
	public String index(Model viewModel) {
		
		viewModel.addAttribute("questions", questionServ.findAll());
		return"index.jsp";
	}
	
}