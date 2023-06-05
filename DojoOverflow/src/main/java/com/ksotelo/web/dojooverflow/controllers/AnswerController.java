package com.ksotelo.web.dojooverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ksotelo.web.dojooverflow.models.AnswerModel;
import com.ksotelo.web.dojooverflow.models.QuestionModel;
import com.ksotelo.web.dojooverflow.services.AnswerService;
import com.ksotelo.web.dojooverflow.services.QuestionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/answers")
public class AnswerController {
	@Autowired
	private QuestionService questionServ;
	@Autowired
	private AnswerService answerServ;
	@PostMapping("/new")
	public String newAnswer(@Valid @ModelAttribute("newAnswer") AnswerModel newAnswer, BindingResult result,
			Model viewModel) {
		if(result.hasErrors()) {
			return"showQuestion.jsp";
		}
		Long idQuestion = newAnswer.getQuestion().getId();
		QuestionModel question = questionServ.findById(idQuestion);
		viewModel.addAttribute("question", question);
		answerServ.createAnswer(newAnswer);
		return "redirect:/questions/show/"+idQuestion;
	}
}