package com.ksotelo.web.listaestudiantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksotelo.web.listaestudiantes.models.ContactModel;
import com.ksotelo.web.listaestudiantes.models.StudentModel;
import com.ksotelo.web.listaestudiantes.repositories.ContactRepo;
import com.ksotelo.web.listaestudiantes.repositories.StudentsRepo;

@Service
public class ApiService {

	@Autowired
	private ContactRepo contactRepo;
	@Autowired
	private StudentsRepo studentRepo;
	
	//STUDENT
		public List<StudentModel> mostrarTodos(){
			return studentRepo.findAll();	
		}
		public StudentModel createStudent(StudentModel s) {
			return studentRepo.save(s);
		} 
		public List<StudentModel> findByNoContact() {
			return studentRepo.findByNoContact();
		}

		//CONTACT
		public ContactModel createContact(ContactModel c) {
			return contactRepo.save(c);
		}
}
