package com.ksotelo.web.proyectomvc.controllers;
import com.ksotelo.web.proyectomvc.models.BookModel;
import com.ksotelo.web.proyectomvc.services.BookService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookserv;
	
	@GetMapping("/")
	public String raiz(){
		return"redirect:/books";
	}
	@GetMapping("/books")
	public String index(Model model){
		List<BookModel> books = bookserv.allBooks();
		model.addAttribute("books",books);
		return"index.jsp";
	}
	
	//retorna la view con el formulario de agregar nuevo libro
	@GetMapping("/books/new")
	public String nuevoLibro(@ModelAttribute("newBook")BookModel bookmodel) {
		return"newBook.jsp";
	}
	
	//obtiene los datos del formulario y los guarda.
	@PostMapping("/books/new")
	public String registraNuevoLibro(@Valid @ModelAttribute("newBook")BookModel bookmodel,
			BindingResult result) {
		if(result.hasErrors()) {
			return"newBook.jsp";
		}else {
			bookserv.createBook(bookmodel);
		return"redirect:/books";
		}
	}
	
	//obtiene el libro a través del id del libro y luego lo muestra en una view
	@GetMapping("/books/{bookId}")
	public String mostrarLibro(Model model, @PathVariable("bookId") Long bookId) {
		model.addAttribute("libro",bookserv.findBook(bookId));
		return"mostrarLibro.jsp";
	}
	
	//obtiene el libro a través de la id, y luego lo pinta en el formulario para editarse
	@GetMapping("/books/edit/{bookId}")
	public String editarLibro(@ModelAttribute("editBook") BookModel bookmodel, 
			Model model, @PathVariable("bookId") Long bookId) {
		model.addAttribute("libro", bookserv.findBook(bookId));
		return"editarLibro.jsp";
	}
	
	//obtiene los datos del formulario editado y lo actualiza
	//tiene errores
	@PutMapping("/books/edit/{bookId}")
	public String editarLibro(@ModelAttribute("editBook") BookModel bookmodel, 
			BindingResult result, @PathVariable("bookId") Long bookId) {
		if(result.hasErrors()) {
			return"editarLibro.jsp";
		}else {
			bookserv.updateBook(bookmodel);
			return"redirect:/books";
		}
	}
	@GetMapping("/books/delete/{bookId}")
	public String eliminarLibro(@PathVariable("bookId") Long bookId) {
		bookserv.deleteBook(bookId);
		return "redirect:/books";
	}

}
