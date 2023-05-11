package com.ksotelo.web.mostrarfecha.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class MainController {
	
	@RequestMapping("")
	public String bienvenido() {
		return "Index.jsp";
	}
	
	@RequestMapping("/hora")
	public String hora(Model model) {
		Date hora = new Date();
		String newHora = new SimpleDateFormat("h:mm a").format(hora);
		model.addAttribute("hora",newHora);
		return"Hora.jsp";
	}
	@RequestMapping("/fecha")
	public String fecha(Model model) {
		
		
		Date fecha = new Date();
		String newFecha = new SimpleDateFormat("EEEE, dd MMMM, yyyy").format(fecha);
		model.addAttribute("fecha",newFecha);
		return"Fecha.jsp";
	}
}
