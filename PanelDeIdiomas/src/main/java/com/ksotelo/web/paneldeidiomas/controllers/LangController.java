package com.ksotelo.web.paneldeidiomas.controllers;

import com.ksotelo.web.paneldeidiomas.models.LanguageModel;
import com.ksotelo.web.paneldeidiomas.services.LangService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
public class LangController {

	@Autowired
	private LangService langserv;

	@RequestMapping("/")
	public String redirect() {
		return "redirect:/languages";
	}

	// READ
	@GetMapping("/languages")
	public ModelAndView index(Model model) {
		List<LanguageModel> langs = langserv.allLanguages();
		model.addAttribute("langs", langs);
		return new ModelAndView("index.jsp");
	}

	@GetMapping("language/{id}")
	public String showLang(@PathVariable("id") Long id, Model model) {
		model.addAttribute("lang", langserv.findLangById(id));
		return "showLang.jsp";
	}

	@GetMapping("/language/new")
	public String newLang(@ModelAttribute("newLang") LanguageModel lang) {
		return "newLang.jsp";
	}

	@PostMapping("/language/new")
	public String newLang(@Valid @ModelAttribute("newLang") LanguageModel lang, BindingResult result) {
		if (result.hasErrors()) {
			return "newLang.jsp";
		} else {
			langserv.createLang(lang);
			return "redirect:/languages";
		}
	}

	@GetMapping("/language/edit/{id}")
	public String editarLang(@ModelAttribute("editLang") LanguageModel langModel, Model model,
			@PathVariable("id") Long id) {
		model.addAttribute("lang", langserv.findLangById(id));
		return "editarLang.jsp";
	}

	// obtiene los datos del formulario editado y lo actualiza
	// tiene errores

	@PutMapping("/language/edit/{id}")
	public String editarLang(@Valid @ModelAttribute("editLang") LanguageModel langModel, BindingResult result,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "editarLang.jsp";
		} else {
			langserv.updateLang(langModel);
			return "redirect:/languages";
		}
	}
//		@PutMapping("/books/edit/{bookId}")
//		public String editarLibro(@ModelAttribute("editBook") BookModel bookmodel, 
//				BindingResult result, @PathVariable("bookId") Long bookId) {
//			if(result.hasErrors()) {
//				return"editarLibro.jsp";
//			}else {
//				bookserv.updateBook(bookmodel);
//				return"redirect:/books";
//			}
//		}

	@GetMapping("/language/delete/{id}")
	public String deleteLang(@PathVariable("id") Long id) {
		langserv.deleteLang(id);
		return "redirect:/languages";
	}
}
