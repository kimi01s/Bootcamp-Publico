package com.ksotelo.web.listaestudiantes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ksotelo.web.listaestudiantes.models.StudentModel;

public interface StudentsRepo extends CrudRepository<StudentModel, Long>{

List<StudentModel> findAll();
	@Query(value="SELECT p.* FROM students p LEFT OUTER JOIN contacts l ON p.id = l.student_id WHERE l.id IS NULL;", 
			nativeQuery=true)
	List<StudentModel> findByNoContact();
}
