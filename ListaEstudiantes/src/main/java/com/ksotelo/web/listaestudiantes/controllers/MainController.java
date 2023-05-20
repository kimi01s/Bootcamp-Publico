package com.ksotelo.web.listaestudiantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ksotelo.web.listaestudiantes.models.ContactModel;
import com.ksotelo.web.listaestudiantes.models.StudentModel;
import com.ksotelo.web.listaestudiantes.services.ApiService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private ApiService apiServ;

	@GetMapping("/")
	public String index(Model viewModel) {
		return "index.jsp";
	}

	// READ
	// muestra todos los estudiantes
	@GetMapping("/students")
	public String mostrarEstudiantes(Model viewModel) {
		viewModel.addAttribute("listaEstudiantes", apiServ.mostrarTodos());
		return "allStudents.jsp";
	}

	// CREATE

	// muestra el formulario para agregar nuevo estudiante
	@GetMapping("/students/new")
	public String formStudent(@ModelAttribute("newStudent") StudentModel newStudent) {
		return "newStudent.jsp";
	}

	// envia los datos al backend y los guarda
	@PostMapping("/students/new")
	public String newStudent(@Valid @ModelAttribute("newStudent") StudentModel newStudent, BindingResult result) {
		if (result.hasErrors()) {
			return "newStudent.jsp";
		} else {
			apiServ.createStudent(newStudent);
			return "redirect:/";
		}
	}

	// muestra el formulario para agregar el contacto
	@GetMapping("/contact/new")
	public String formContact(@ModelAttribute("newContact") ContactModel newContact, Model viewModel) {
		viewModel.addAttribute("studentsNoContact", apiServ.findByNoContact());
		return "newContact.jsp";
	}

	// envia los datos al backend y los guarda
	@PostMapping("/contact/new")
	public String newContact(@Valid @ModelAttribute("newContact") ContactModel newContact, BindingResult result,
			Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("studentsNoContact", apiServ.findByNoContact());
			return "newContact.jsp";
		} else {
			apiServ.createContact(newContact);
			return "redirect:/";
		}
	}
	
	
}
