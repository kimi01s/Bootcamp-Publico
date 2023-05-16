package com.ksotelo.web.paneldeidiomas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ksotelo.web.paneldeidiomas.models.LanguageModel;
import com.ksotelo.web.paneldeidiomas.services.LangService;

@RestController
public class LangApi {
	
	@Autowired
	private LangService langServ;

	// obtiene todos los lenguajes de la api
	@RequestMapping("/api/languages")
	public List<LanguageModel> allLang() {
		return langServ.allLanguages();
	}

	//crea un nuevo lenguaje
	@PostMapping("/api/create")
	public LanguageModel create(@RequestParam(value = "name") String name,
			@RequestParam(value = "creator") String creator,
			@RequestParam(value = "currentVersion") String currentVersion) {
		
		LanguageModel newLang = new LanguageModel(name,creator,currentVersion);
		return langServ.createLang(newLang);
	}
	
	@RequestMapping("/api/language/{id}")
	public LanguageModel searchById(@PathVariable("id") Long id) {
		return langServ.findLangById(id);
	}
}
