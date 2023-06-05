package com.ksotelo.web.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksotelo.web.dojooverflow.models.AnswerModel;
import com.ksotelo.web.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository answerRepo;
	
	public AnswerModel createAnswer(AnswerModel answer) {
		return answerRepo.save(answer);
	}
}