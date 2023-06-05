package com.ksotelo.web.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.dojooverflow.models.TagsModel;

@Repository
public interface TagRepository extends CrudRepository<TagsModel, Long>{
	TagsModel findByName(String name);
}