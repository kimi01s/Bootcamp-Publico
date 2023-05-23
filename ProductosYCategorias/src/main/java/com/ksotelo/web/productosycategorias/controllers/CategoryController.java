package com.ksotelo.web.productosycategorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ksotelo.web.productosycategorias.models.CategoryModel;
import com.ksotelo.web.productosycategorias.models.ProductCategoryModel;
import com.ksotelo.web.productosycategorias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {
	@Autowired
	private MainService mainServ;

	// CREATE
	@GetMapping("/categories/new")
	public String formCategory(@ModelAttribute("newCategory") CategoryModel newCategory) {
		return "newCategory.jsp";
	}

	@PostMapping("/categories/new")
	public String newCategory(@Valid @ModelAttribute("newCategory") CategoryModel newCategory, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		}
		mainServ.newCategory(newCategory);
		return "redirect:/index";
	}

	// READ
	@GetMapping("/allCategories")
	public String allCategories(Model model) {
		model.addAttribute("allCat", mainServ.showAllCategories());
		return "mostrarCategorias.jsp";
	}

	@GetMapping("/categories/{catId}")
	public String category(@PathVariable("catId") Long catId, @ModelAttribute("asoCat") ProductCategoryModel proCat,
			Model viewModel) {
		CategoryModel category = mainServ.showCategory(catId);
		viewModel.addAttribute("categoria", category);
		viewModel.addAttribute("productos", mainServ.categoriaSinProducto(category));
		return "mostrarCategoria.jsp";
	}

	// UPDATE
	@GetMapping("/category/edit/{idCat}")
	public String formUpdateCategory(@PathVariable("idCat") Long idCat,
			@ModelAttribute("updateCat") CategoryModel category, Model viewModel) {
		viewModel.addAttribute("category", mainServ.showCategory(idCat));
		return "editarCategoria.jsp";
	}

	@PutMapping("/category/edit/{idCat}")
	public String UpdateCategory(@PathVariable("idCat") Long idCat, 
			@ModelAttribute("updateCat") CategoryModel category,
			BindingResult result) {
		if(result.hasErrors()) {
			return"editarCategoria.jsp";
		}else {
			mainServ.updateCategory(category);
			return"redirect:/allCategories";
		}

	}
	// DELETE

	// DELETE PRODUCTO CON SU FOREIGN KEY
	@GetMapping("/categories/delete/{idCategoria}")
	public String eliminarProducto(@PathVariable("idCategoria") Long idCategoria) {
		mainServ.deleteCategory(idCategoria);
		return "redirect:/allCategories";
	}
}
