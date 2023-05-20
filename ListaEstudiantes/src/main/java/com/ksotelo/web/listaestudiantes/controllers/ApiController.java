package com.ksotelo.web.listaestudiantes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ksotelo.web.listaestudiantes.models.ContactModel;
import com.ksotelo.web.listaestudiantes.models.StudentModel;
import com.ksotelo.web.listaestudiantes.services.ApiService;

@RestController
public class ApiController {
	@Autowired
	private ApiService apiServ;
	
	//CREATE 
	@PostMapping("/student/create")
	public StudentModel createStudent(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, @RequestParam(value="age") int age) {
		
		StudentModel newStudent = new StudentModel(firstName, lastName, age);
		return apiServ.createStudent(newStudent);
	}

	@PostMapping("/contacts/create")
	public ContactModel createContact(@RequestParam(value = "address") String address,
			@RequestParam(value = "city") String city, @RequestParam(value="state") String state,
			@RequestParam(value= "student") StudentModel student) {
		ContactModel newcontact = new ContactModel(address, city, state, student);
		return apiServ.createContact(newcontact);
	}
	
	@GetMapping("/showStudents")
	public List<StudentModel> mostrarTodos() {
		return	apiServ.mostrarTodos();
	}
}
