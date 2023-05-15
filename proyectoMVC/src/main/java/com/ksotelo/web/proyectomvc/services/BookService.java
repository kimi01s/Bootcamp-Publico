package com.ksotelo.web.proyectomvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksotelo.web.proyectomvc.models.BookModel;
import com.ksotelo.web.proyectomvc.repositories.BookRepository;

@Service
public class BookService {

	// Agregando el book al repositorio como una dependencia
//	private final BookRepository bookRepo;
//	
//	public BookService(BookRepository BookRepo) {
//		this.bookRepo = BookRepo;
//	}
	@Autowired
	private BookRepository bookRepo;

	// Devolviendo todos los libros.
	public List<BookModel> allBooks() {
		return bookRepo.findAll();
	}

	// Creando un libro.
	public BookModel createBook(BookModel b) {
		return bookRepo.save(b);
	}

	// Obteniendo la información de un libro
	public BookModel findBook(Long id) {
		Optional<BookModel> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// servicio para actualizar libro
	public BookModel updateBook(Long id, String title, String desc, String lang, int pages) {
		Optional<BookModel> actualizarLibro = bookRepo.findById(id);
		if (actualizarLibro.isPresent()) {
			BookModel libroActualizado = new BookModel();
			libroActualizado.setId(id);
			libroActualizado.setTitle(title);
			libroActualizado.setDescription(desc);
			libroActualizado.setLanguage(lang);
			libroActualizado.setNumberOfPages(pages);
			bookRepo.save(libroActualizado);

		}
		return new BookModel();
	}

	public BookModel updateBook(BookModel bookmodel) {
		BookModel actualizarLibro = findBook(bookmodel.getId());
		actualizarLibro.setId(bookmodel.getId());
		actualizarLibro.setTitle(bookmodel.getTitle());
		actualizarLibro.setDescription(bookmodel.getDescription());
		actualizarLibro.setLanguage(bookmodel.getLanguage());
		actualizarLibro.setNumberOfPages(bookmodel.getNumberOfPages());
		bookRepo.save(actualizarLibro);
		return actualizarLibro;
	}

	public void deleteBook(Long id) {
		Optional<BookModel> actualizarLibro = bookRepo.findById(id);
		if (actualizarLibro.isPresent()) {
			bookRepo.deleteById(id);
		}
	}

}