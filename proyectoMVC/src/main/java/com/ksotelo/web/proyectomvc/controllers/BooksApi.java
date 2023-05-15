package com.ksotelo.web.proyectomvc.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ksotelo.web.proyectomvc.models.BookModel;
import com.ksotelo.web.proyectomvc.services.BookService;


@RestController
public class BooksApi {
	
//	private final BookService bookService;
//
//	public BooksApi(BookService bookService) {
//		this.bookService = bookService;
//	}
	@Autowired
	private BookService bookService;

	@RequestMapping("/api/books")
	public List<BookModel> index() {
		return bookService.allBooks();
	}

	@PostMapping(value = "/api/books")
	public BookModel create(@RequestParam(value = "title") String title, 
			@RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, 
			@RequestParam(value = "pages") Integer numOfPages) {
		BookModel book = new BookModel(title,desc, lang, numOfPages);
		return bookService.createBook(book);
	}

	@RequestMapping("/api/books/{id}")
	public BookModel show(@PathVariable("id") Long id) {
		BookModel book = bookService.findBook(id);
		return book;
	}
	
	   @PutMapping(value="/api/books/{id}")
		public BookModel update(@PathVariable("id") Long id,
				@RequestParam(value = "title") String title, 
				@RequestParam(value="description") String desc, 
				@RequestParam(value="language") String lang, 
				@RequestParam(value="pages") Integer numOfPages) {
		   
	        BookModel book = bookService.updateBook(id, title, desc, lang, numOfPages);
	        return book;
	    }
	    
	    @DeleteMapping(value="/api/books/{id}")
	    public void destroy(@PathVariable("id") Long id) {
	        bookService.deleteBook(id);
	    }
	    
}
