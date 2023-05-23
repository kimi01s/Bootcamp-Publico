package com.ksotelo.web.productosycategorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ksotelo.web.productosycategorias.models.ProductCategoryModel;
import com.ksotelo.web.productosycategorias.services.MainService;

@Controller
public class ProductsCategoriesController {

	@Autowired
	private MainService mainServ;

	//CREATE
	@PostMapping("/aso/{idProducto}")
	public String asociarCategoriaProducto(@PathVariable("idProducto") Long idProducto,
			@ModelAttribute("asociacion") ProductCategoryModel prodCat, Model viewModel, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "mostrarProducto.jsp";
		}
		mainServ.crearVinculo(prodCat);
		return "redirect:/products/" + idProducto;
	}

	@PostMapping("/asociacion/{idCat}")
	public String asociarProductoCategoria(@PathVariable("idCat") Long idCat,
			@ModelAttribute("asoCat") ProductCategoryModel prodCat, Model viewModel, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return"mostrarCategoria.jsp";
		}else {
			mainServ.crearVinculo(prodCat);
			return"redirect:/categories/"+ idCat;
		}
	}
	
	//DELETE
	@GetMapping("/productandcat/delete/{idCat}/{idProd}")
	public String deleteCategoryOfProduct(@PathVariable("idCat") Long idCat, @PathVariable("idProd") Long idProd) {
		mainServ.deleteVinculo(idCat, idProd);
		return"redirect:/products/"+idProd;
	}
	@GetMapping("/productandcat/deleteProd/{idProd}/{idCat}")
	public String deleteProductOfCategory(@PathVariable("idProd") Long idProd, @PathVariable("idCat") Long idCat) {
		mainServ.deleteVinculo(idCat, idProd);
		return"redirect:/categories/"+idCat;
	}
}