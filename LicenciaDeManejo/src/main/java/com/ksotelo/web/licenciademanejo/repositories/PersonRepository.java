package com.ksotelo.web.licenciademanejo.repositories;

import com.ksotelo.web.licenciademanejo.models.PersonModel;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonModel, Long> {

	List<PersonModel> findAll();

	@Query(value = "SELECT p.* FROM persons p LEFT OUTER JOIN licenses l ON p.id = l.person_id WHERE l.id IS NULL;", nativeQuery = true)
	List<PersonModel> findByNoLicense();
}
