package com.ksotelo.web.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.dojooverflow.models.QuestionModel;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionModel, Long>{

	List<QuestionModel> findAll();
}