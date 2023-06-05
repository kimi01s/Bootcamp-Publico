package com.ksotelo.web.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksotelo.web.dojooverflow.models.AnswerModel;
import com.ksotelo.web.dojooverflow.models.QuestionModel;
import com.ksotelo.web.dojooverflow.models.TagsModel;
import com.ksotelo.web.dojooverflow.services.QuestionService;
import com.ksotelo.web.dojooverflow.services.TagService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	@Autowired
	private QuestionService questionServ;
	@Autowired
	private TagService tagServ;

	@GetMapping("/new")
	public String formQuestion() {
		return "newQuestion.jsp";
	}

	@PostMapping("/new")
	public String newQuestion(@RequestParam("question") String question, @RequestParam("tags") String tags) {
		String[] tagsSplit = tags.split(",");

		List<String> t = Arrays.asList(tagsSplit);
		ArrayList<TagsModel> tList = new ArrayList<TagsModel>();

		t.forEach((x) -> {
			TagsModel newT = new TagsModel();
			System.out.println(x);
			newT.setName(x.strip());
			TagsModel findTag = tagServ.findByName(x.strip());
			if (findTag == null) {
				tagServ.createTag(newT);
				tList.add(newT);
			}
			tList.add(findTag);
		});
		
		QuestionModel questionModel = new QuestionModel(question, tList);
		questionServ.createQuestion(questionModel);
		return "redirect:/";
	}
	
	@GetMapping("/show/{id}")
	public String showQuestion(@ModelAttribute("newAnswer") AnswerModel answer, @PathVariable("id") Long id, Model viewModel) {
		QuestionModel question = questionServ.findById(id);
		viewModel.addAttribute("question", question);
		return"showQuestion.jsp";
	}
}