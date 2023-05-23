package com.ksotelo.web.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.productosycategorias.models.ProductCategoryModel;

@Repository
public interface ProductsCategoriesRepo extends CrudRepository<ProductCategoryModel, Long>{
	List<ProductCategoryModel> findByCategory_idAndProduct_id(Long Category, Long Product);
}