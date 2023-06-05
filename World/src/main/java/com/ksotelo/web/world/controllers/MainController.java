package com.ksotelo.web.world.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ksotelo.web.world.services.ApiService;

@Controller
public class MainController {

	@Autowired
	private ApiService apiServ;

	@GetMapping("/")
	public String raiz() {
		return "index.jsp";
	}

	@GetMapping("/consulta/1")
	public String consultaUno(Model viewModel) {
		List<Object[]> sloveno = apiServ.paisesHablaSloveno();
		viewModel.addAttribute("paisesSloveno", sloveno);
		return "consultaUno.jsp";
	}

	@GetMapping("/consulta/2")
	public String consultaDos(Model viewModel) {
		List<Object[]> totalCiudadesPorPais = apiServ.totalCiudadesPorPais();
		viewModel.addAttribute("totalCiudadesxPais", totalCiudadesPorPais);
		return "consultaDos.jsp";
	}

	@GetMapping("/consulta/3")
	public String consultaTres(Model viewModel) {
		List<Object[]> mexicoQuinientos = apiServ.mexicoMayorQuinientos();
		viewModel.addAttribute("mexicoQuinientos", mexicoQuinientos);
		return "consultaTres.jsp";
	}

	@GetMapping("/consulta/4")
	public String consultaCuatro(Model viewModel) {
		List<Object[]> paisesMayor = apiServ.paisesMayor();
		viewModel.addAttribute("paisesMayor", paisesMayor);
		return "consultaCuatro.jsp";
	}

	@GetMapping("/consulta/5")
	public String consultaCinco(Model viewModel) {
		List<Object[]> paisesMayorArea = apiServ.paisesMayorArea();
		viewModel.addAttribute("paisesMayorArea", paisesMayorArea);
		return "consultaCinco.jsp";
	}

	@GetMapping("/consulta/6")
	public String consultaSeis(Model viewModel) {
		List<Object[]> paisesSoloMonarchyAreaYExpectativa = apiServ.paisesSoloMonarchyAreaYExpectativa();
		viewModel.addAttribute("paisesSoloMonarchyAreaYExpectativa", paisesSoloMonarchyAreaYExpectativa);
		return "consultaSeis.jsp";
	}
	@GetMapping("/consulta/7")
	public String todasCiudadesArgBuenosAiresMayor(Model viewModel) {
		List<Object[]> todasCiudadesArgBuenosAiresMayor = apiServ.todasCiudadesArgBuenosAiresMayor();
		viewModel.addAttribute("todasCiudadesArgBuenosAiresMayor", todasCiudadesArgBuenosAiresMayor);
		return "consultaSiete.jsp";
	}
	@GetMapping("/consulta/8")
	public String sumaPaisesRegion(Model viewModel) {
		List<Object[]> sumaPaisesRegion = apiServ.sumaPaisesRegion();
		viewModel.addAttribute("sumaPaisesRegion", sumaPaisesRegion);
		return "consultaOcho.jsp";
	}
}
