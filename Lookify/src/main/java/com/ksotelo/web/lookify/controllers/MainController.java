package com.ksotelo.web.lookify.controllers;
import com.ksotelo.web.lookify.models.MusicModel;
import com.ksotelo.web.lookify.services.MusicService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private MusicService musicserv;

	// redireccionamiento
	@GetMapping("/")
	public String redirect() {
		return "redirect:/index";
	}

	// página main
	@GetMapping("/index")
	public String index() {
		return "index.jsp";
	}

	// READ
	// obtiene todas las canciones y retorna a la view para mostrarlas
	@GetMapping("/songs")
	public ModelAndView songs(Model model) {
		model.addAttribute("songs", musicserv.allSongs());
		return new ModelAndView("songsTable.jsp", "findsong", new MusicModel());
	}

	@GetMapping("/songs/search")
	public String findSongByArtist(@ModelAttribute("findsong") MusicModel music, Model model) {
		return "redirect:/songs/search/"+music.getArtista();
	}
	
	@GetMapping("/songs/search/{artista}")
	public ModelAndView readSongsByArtist(@PathVariable("artista") String artista, Model model) {
		List<MusicModel> lista = musicserv.findByArtista(artista);
		if(lista.isEmpty()) {
			return new ModelAndView("findArtistSongs.jsp", "findsong", new MusicModel());
		}else {
		model.addAttribute("songs", lista);
		model.addAttribute("artista", artista);
		System.out.println(artista);
		return new ModelAndView("findArtistSongs.jsp", "findsong", new MusicModel());
		}
	}

	// READ
	// obtiene la canción y la muestra en la view a través del ID
	@GetMapping("/song/view/{id}")
	public String viewSong(Model model, @PathVariable("id") Long id) {
		model.addAttribute("song", musicserv.findSongById(id));
		return "detalleCancion.jsp";
	}

	// obtiene el top 10 de las canciones obtenidas por la clasificacion
	@GetMapping("/songs/topten")
	public String topTen(Model model) {
		model.addAttribute("songs", musicserv.searchTopTen());
		return "topTen.jsp";
	}

	// CREATE
	// obtiene el formulario y redirecciona al mismo conectandose a través del model
	// attribute
	@GetMapping("/song/new")
	public String formCancion(@ModelAttribute("newSong") MusicModel songmodel) {
		return "newSong.jsp";
	}

	// obtiene los datos de los campos del formulario y luego los guarda a través
	// del método createSong
	@PostMapping("/song/new")
	public String registraCancion(@Valid @ModelAttribute("newSong") MusicModel musicmodel, BindingResult result) {
		if (result.hasErrors()) {
			return "newSong.jsp";
		} else {
			musicserv.createSong(musicmodel);
			return "redirect:/songs";
		}
	}

	// DELETE
	// obtiene el id de la canción y la elimina
	@GetMapping("/song/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		musicserv.deleteSong(id);
		return "redirect:/songs";
	}

}