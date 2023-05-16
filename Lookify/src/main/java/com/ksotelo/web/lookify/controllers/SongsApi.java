package com.ksotelo.web.lookify.controllers;
import com.ksotelo.web.lookify.models.MusicModel;
import com.ksotelo.web.lookify.services.MusicService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class SongsApi {
	private final MusicService musicserv;

	public SongsApi(MusicService musicserv) {
		this.musicserv = musicserv;
	}
	
	//CREATE
	@PostMapping("/songs/create")
	public MusicModel createSong(@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "artista") String artista,
			@RequestParam(value = "clasificacion") Integer clasificacion) {
		
		MusicModel newSong = new MusicModel(titulo,artista,clasificacion);
		return musicserv.createSong(newSong);
	}
	
	//READ
	@GetMapping("/songslist")
	public List<MusicModel> listSongs(){
		return musicserv.allSongs();
	}
	
	//UPDATE
	@PutMapping(value="/song/update/{id}")
	public MusicModel updateSong(@PathVariable("id") Long id, 
			@RequestParam(value = "titulo") String titulo,
			@RequestParam(value = "artista") String artista,
			@RequestParam(value = "clasificacion") Integer clasificacion) {
		
		MusicModel song = musicserv.updateSong(id, titulo, artista, clasificacion);
		return song;
	}
	
	//DELETE
	@DeleteMapping(value="song/delete/{id}")
    public void deleteSong(@PathVariable("id") Long id) {
		musicserv.deleteSong(id);
    }
}