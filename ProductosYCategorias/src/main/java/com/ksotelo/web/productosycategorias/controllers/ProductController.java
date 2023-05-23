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

import com.ksotelo.web.productosycategorias.models.ProductCategoryModel;
import com.ksotelo.web.productosycategorias.models.ProductModel;
import com.ksotelo.web.productosycategorias.services.MainService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

	@Autowired
	private MainService mainServ;

	// CREATE
	@GetMapping("/products/new")
	public String formProduct(@ModelAttribute("newProduct") ProductModel newProduct) {
		return "newProduct.jsp";
	}

	@PostMapping("/products/new")
	public String newProduct(@Valid @ModelAttribute("newProduct") ProductModel newProduct, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}
		mainServ.newProduct(newProduct);
		return "redirect:/index";
	}

	// READ
	@GetMapping("/products/{idProducto}")
	public String mostrarProducto(@PathVariable("idProducto") Long idProducto,
			@ModelAttribute("asociacion") ProductCategoryModel prodCat, Model viewModel) {
		ProductModel producto = mainServ.showProducto(idProducto);
		viewModel.addAttribute("producto", producto);
		viewModel.addAttribute("categorias", mainServ.productoSinCategoria(producto));

		return "mostrarProducto.jsp";
	}
	// UPDATE

	@GetMapping("/products/edit/{idProduct}")
	public String formUptdate(@PathVariable("idProduct") Long idProduct,
			@ModelAttribute("updateProd") ProductModel product, Model viewModel) {
		viewModel.addAttribute("producto", mainServ.showProducto(idProduct));
		return"editarProducto.jsp";
	}
	
	@PutMapping("/products/edit/{idProduct}")
	public String updateProduct(@PathVariable("idProduct") Long idProduct,
			@ModelAttribute("updateProd") ProductModel product, BindingResult result) {
		if(result.hasErrors()) {
			return"editarProducto.jsp";
		}else {
			mainServ.updateProduct(product);
			return"redirect:/index";
		}
	}

	// DELETE PRODUCTO CON SU FOREIGN KEY
	@GetMapping("/products/delete/{idProducto}")
	public String eliminarProducto(@PathVariable("idProducto") Long idProducto) {
		mainServ.deleteProduct(idProducto);
		return "redirect:/index";
	}
}