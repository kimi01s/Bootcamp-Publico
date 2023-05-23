package com.ksotelo.web.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.productosycategorias.models.CategoryModel;
import com.ksotelo.web.productosycategorias.models.ProductModel;

@Repository
public interface ProductRepo extends CrudRepository<ProductModel, Long>{
	
	List<ProductModel> findAll();
	List<ProductModel> findByCategoriesNotContains(CategoryModel category);
}