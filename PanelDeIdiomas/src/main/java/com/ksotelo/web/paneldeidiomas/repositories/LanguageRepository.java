package com.ksotelo.web.paneldeidiomas.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.paneldeidiomas.models.LanguageModel;

@Repository
public interface LanguageRepository extends CrudRepository<LanguageModel, Long>{
	
	List<LanguageModel> findAll();
}
