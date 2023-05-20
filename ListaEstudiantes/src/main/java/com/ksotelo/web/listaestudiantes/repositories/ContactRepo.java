package com.ksotelo.web.listaestudiantes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ksotelo.web.listaestudiantes.models.ContactModel;

public interface ContactRepo extends CrudRepository<ContactModel, Long>{
	
}