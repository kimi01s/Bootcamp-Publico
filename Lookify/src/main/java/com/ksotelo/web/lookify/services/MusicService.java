package com.ksotelo.web.lookify.services;
import com.ksotelo.web.lookify.models.MusicModel;
import com.ksotelo.web.lookify.repositories.MusicRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class MusicService {
	@Autowired
	private MusicRepository musicrepo;
	
	//CREATE
	public MusicModel createSong(MusicModel m) {
		return musicrepo.save(m);
	}
	//READ
	
	//read all
	public List<MusicModel> allSongs(){
		return musicrepo.findAll();
	}
	//read by id
	public MusicModel findSongById(Long id) {
		Optional<MusicModel> optionalSong = musicrepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;
		}
	}
	
	public List<MusicModel> searchTopTen() {
		return musicrepo.findTop10ByOrderByClasificacionDesc();
	}
	//UPDATE
	public MusicModel updateSong(Long id, String titulo, String artista, Integer clasificacion) {
		Optional<MusicModel> updateSong = musicrepo.findById(id);
		
		if(updateSong.isPresent()) {
			MusicModel nuevaCancion = new MusicModel();
			nuevaCancion.setId(id);
			nuevaCancion.setTitulo(titulo);
			nuevaCancion.setArtista(artista);
			nuevaCancion.setClasificacion(clasificacion);
			musicrepo.save(nuevaCancion);
		}
		return new MusicModel();
	}
	
	//DELETE
	
	public void deleteSong(Long id) {
		Optional<MusicModel> deleteSong = musicrepo.findById(id);
		if(deleteSong.isPresent()) {
			musicrepo.deleteById(id);
		}
	}
	public List<MusicModel> findByArtista(String artist){
		return musicrepo.findByArtista(artist);
	}
}