package com.ksotelo.web.licenciademanejo.controllers;

import com.ksotelo.web.licenciademanejo.models.LicenseModel;
import com.ksotelo.web.licenciademanejo.models.PersonModel;
import com.ksotelo.web.licenciademanejo.services.MainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private MainService mainServ;

	@RequestMapping("/")
	public String redirect() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index(Model model) {
		List<PersonModel> todos = mainServ.todosUsuarios();
		model.addAttribute("persons", todos);
		return "index.jsp";
	}

	// RUTAS PERSONA
	@GetMapping("/person/{id}")
	public String mostrarPersona(@PathVariable("id") Long id, Model model) {
		PersonModel persona = mainServ.findById(id);
		model.addAttribute("persona", persona);
		return "mostrarPersona.jsp";
	}
	
	@GetMapping("/person/new")
	public String formularioPersona(@ModelAttribute("newPerson") PersonModel persona) {
		return "nuevaPersona.jsp";
	}

	@PostMapping("/person/new")
	public String CrearPersona(@Valid @ModelAttribute("newPerson") PersonModel persona, BindingResult result) {
		
		
		if (result.hasErrors()) {
			return "nuevaPersona.jsp";
		} else {
			mainServ.createPerson(persona);
			return "redirect:/index";
		}
	}

	// RUTAS LICENCIAS
	@GetMapping("/licence/new")
	public String formularioLicencia(@ModelAttribute("newLicence") LicenseModel licence, Model model) {

		List<PersonModel> personas = mainServ.findByNoLicense();
		model.addAttribute("selectDef", mainServ.dato());
		model.addAttribute("personas", personas);
		return "nuevaLicencia.jsp";
	}

	@PostMapping("/licence/new")
	public String CrearLicencia(@Valid @ModelAttribute("newLicence") LicenseModel licence, BindingResult result,
			Model model) {
		if(licence.getPerson() == null) {
			model.addAttribute("selectDef", mainServ.dato());
			model.addAttribute("personas", mainServ.findByNoLicense());
			result.getAllErrors();
			return "nuevaLicencia.jsp";
		}
		if (result.hasErrors()) {
			model.addAttribute("selectDef", mainServ.dato());
			model.addAttribute("personas", mainServ.findByNoLicense());
			return "nuevaLicencia.jsp";
		} else {
			mainServ.createLicense(licence);
			return "redirect:/index";
		}
	}
}