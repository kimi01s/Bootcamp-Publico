package com.ksotelo.web.licenciademanejo.repositories;

import com.ksotelo.web.licenciademanejo.models.LicenseModel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface LicenseRepository extends CrudRepository<LicenseModel, Long>{

	List<LicenseModel> findAll();
	public LicenseModel findTopByOrderByNumberDesc();
}