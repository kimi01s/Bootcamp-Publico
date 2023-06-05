package com.ksotelo.web.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksotelo.web.dojooverflow.models.TagsModel;
import com.ksotelo.web.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepo;
	
	public TagsModel createTag(TagsModel newTag) {
		return tagRepo.save(newTag);
	}
	public TagsModel findByName(String name) {
		return tagRepo.findByName(name);
	}
}