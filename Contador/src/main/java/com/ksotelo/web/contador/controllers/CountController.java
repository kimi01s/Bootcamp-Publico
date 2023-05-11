package com.ksotelo.web.contador.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CountController {
	
	private void setSessionCount(HttpSession s, int numVeces) {
		s.setAttribute("contador", numVeces);
	}
	
	private void setSessionCountTwo(HttpSession s, int numVeces) {
		s.setAttribute("contadortwo", numVeces);
	}
	
	private int getSessionCountTwo(HttpSession s) {
		Object sValTwo = s.getAttribute("contadortwo");
		if(sValTwo == null) {
			setSessionCountTwo(s, 0);
			sValTwo = s.getAttribute("contadortwo");
		}
		return(Integer) sValTwo;
	}
	private int getSessionCount(HttpSession s) {
		Object sVal = s.getAttribute("contador");
		if(sVal == null) {
			setSessionCount(s, 0);
			sVal = s.getAttribute("contador");
		}
		return (Integer) sVal;
	}

	@RequestMapping("/")
	public String index(HttpSession s) {
		int conteoActual = getSessionCount(s);
		int conteoActualTwo = getSessionCountTwo(s);
		setSessionCount(s, conteoActual+1);
		setSessionCountTwo(s, conteoActualTwo+2);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession s, Model m) {
		m.addAttribute("contador", getSessionCount(s));
		return "counter.jsp";
	}
	@RequestMapping("/counterTwo")
	public String counterTwo(HttpSession s, Model m) {
		m.addAttribute("contadortwo", getSessionCountTwo(s));
		return "counterTwo.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession s) {
		s.invalidate();
		return"redirect:/counter";
	}
}
