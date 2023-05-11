package com.ksotelo.web.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@PostMapping("/gold")
	public String enviarGold(@RequestParam(value = "keyCode") String keyCode, HttpSession s) {
		
		int gold = 0;
		ArrayList<String> actividades = new ArrayList<String>();
		Date hora = new Date();
		String newHora = new SimpleDateFormat("dd MMMM yyyy h:mm a").format(hora);
		
		if (s.getAttribute("gold") == null) {
			s.setAttribute("gold", gold);
			s.setAttribute("actividades", actividades);
		} else {
			gold = (int) s.getAttribute("gold");
			actividades = (ArrayList<String>) s.getAttribute("actividades");
		}
		if (keyCode.equals("farm")) {
			int numero = new Random().nextInt(10, 20);
			gold += numero;
			actividades.add(0, "entraste a farm y ganaste "+ numero +" gold ("+newHora+")");
			s.setAttribute("actividades", actividades);
			s.setAttribute("gold", gold);
			return "redirect:/gold";
		}
		if (keyCode.equals("cave")) {
			int numero = new Random().nextInt(5, 11);
			gold += numero;
			actividades.add(0, "entraste a cave y ganaste "+ numero +" gold ("+newHora+")");
			s.setAttribute("actividades", actividades);
			s.setAttribute("gold", gold);
			System.out.println(numero);
			return "redirect:/gold";

		}
		if (keyCode.equals("house")) {
			int numero = new Random().nextInt(2, 6);
			gold += numero;
			actividades.add(0, "entraste a house y ganaste "+ numero +" gold ("+newHora+")");
			s.setAttribute("actividades", actividades);
			s.setAttribute("gold", gold);
			System.out.println(numero);
			return "redirect:/gold";
		}
		if (keyCode.equals("casino")) {
			int numero = new Random().nextInt(-50, 51);
			
			if(numero >= 0) {
				gold += numero;
				actividades.add(0, "entraste a casino y ganaste "+ numero +" gold ("+newHora+")");				
			}else {
				gold += numero;
				actividades.add(0, "entraste a casino y perdiste "+ numero +" gold ("+newHora+")");
			}
			s.setAttribute("actividades", actividades);
			s.setAttribute("gold", gold);
			System.out.println(numero);
			return "redirect:/gold";
		}
		if(keyCode.equals("reset")) {
			s.invalidate();
			return"redirect:/gold";
		}
		return "redirect:/gold";
	}

	@GetMapping("/gold")
	public String index(HttpSession s, Model m) {
		m.addAttribute("gold", s.getAttribute("gold"));
		m.addAttribute("actividades", s.getAttribute("actividades"));
		System.out.println(s.getAttribute("gold"));
		return "index.jsp";
	}
	
	@GetMapping("/actividades")
	public String actividades() {
		return"actividades.jsp";
	}
}
