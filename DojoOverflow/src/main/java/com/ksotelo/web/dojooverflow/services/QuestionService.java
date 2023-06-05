package com.ksotelo.web.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksotelo.web.dojooverflow.models.QuestionModel;
import com.ksotelo.web.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepo;
	
	public QuestionModel createQuestion(QuestionModel newQuestion) {
		return questionRepo.save(newQuestion);
	}
	public List<QuestionModel> findAll(){
		return questionRepo.findAll();
	}
	public QuestionModel findById(Long id) {
		return questionRepo.findById(id).orElse(null);
	}
}