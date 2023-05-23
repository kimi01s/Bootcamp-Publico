package com.ksotelo.web.productosycategorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksotelo.web.productosycategorias.models.CategoryModel;
import com.ksotelo.web.productosycategorias.models.ProductCategoryModel;
import com.ksotelo.web.productosycategorias.models.ProductModel;
import com.ksotelo.web.productosycategorias.repositories.CategoryRepo;
import com.ksotelo.web.productosycategorias.repositories.ProductRepo;
import com.ksotelo.web.productosycategorias.repositories.ProductsCategoriesRepo;

@Service
public class MainService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductsCategoriesRepo procatRepo;
	
	//PRODUCTOS
	
	//CREATE
	public ProductModel newProduct(ProductModel newProduct) {
		return productRepo.save(newProduct);
	}
	//READ
	public List<ProductModel> showAll(){
		return productRepo.findAll();
	}
	public ProductModel showProducto(Long idProducto) {
		return productRepo.findById(idProducto).orElse(null);
	}
	public List<ProductModel> categoriaSinProducto(CategoryModel category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	//UPDATE
	
	public ProductModel updateProduct(ProductModel product) {
		ProductModel actualizarProducto = productRepo.findById(product.getId()).orElse(null);
		actualizarProducto.setId(product.getId());
		actualizarProducto.setName(product.getName());
		actualizarProducto.setDescription(product.getDescription());
		actualizarProducto.setPrice(product.getPrice());
		productRepo.save(actualizarProducto);
		return actualizarProducto;
	}
	//DELETE
	public void deleteProduct(Long idProducto) {
		Optional <ProductModel> eliminarProducto = productRepo.findById(idProducto);
		if(eliminarProducto.isPresent()) {
			procatRepo.deleteById(idProducto);
			productRepo.deleteById(idProducto);
		}
	}
	
	//CATEGORIAS
	
	//CREATE
	public CategoryModel newCategory(CategoryModel newCategory) {
		return categoryRepo.save(newCategory);
	}
	
	//READ
	public CategoryModel showCategory(Long idCategory) {
		return categoryRepo.findById(idCategory).orElse(null);
	}
	public List<CategoryModel> productoSinCategoria(ProductModel product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public List<CategoryModel> showAllCategories(){
		return categoryRepo.findAll();
	}
	
	//UPDATE
	
	public CategoryModel updateCategory (CategoryModel category) {
		CategoryModel actualizarCategoria = categoryRepo.findById(category.getId()).orElse(null);
		actualizarCategoria.setId(category.getId());
		actualizarCategoria.setName(category.getName());
		categoryRepo.save(actualizarCategoria);
		return actualizarCategoria;
		
	}
	
	//DELETE
	public void deleteCategory(Long idCategory) {
		Optional <CategoryModel> eliminarCategoria = categoryRepo.findById(idCategory);
		if(eliminarCategoria.isPresent()) {
			categoryRepo.deleteById(idCategory);
		}
	}
	//TABLA INTERMEDIA
	
	//CREATE
	public ProductCategoryModel crearVinculo(ProductCategoryModel newProdAndCat) {
		return procatRepo.save(newProdAndCat);
	}
	
	//DELETE
	
	public void deleteVinculo(Long idCat, Long idProd) {
		List<ProductCategoryModel> prodDelete = procatRepo.findByCategory_idAndProduct_id(idCat, idProd);
		procatRepo.deleteAll(prodDelete);
	}
}