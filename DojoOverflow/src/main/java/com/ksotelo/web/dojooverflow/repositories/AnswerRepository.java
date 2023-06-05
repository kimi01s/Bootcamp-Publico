package com.ksotelo.web.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.dojooverflow.models.AnswerModel;

@Repository
public interface AnswerRepository extends CrudRepository<AnswerModel, Long>{

}