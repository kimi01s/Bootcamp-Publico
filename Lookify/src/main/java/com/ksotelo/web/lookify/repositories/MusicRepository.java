package com.ksotelo.web.lookify.repositories;
import com.ksotelo.web.lookify.models.MusicModel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface MusicRepository extends  CrudRepository<MusicModel,Long> {

	List<MusicModel> findAll();
	List<MusicModel> findTop10ByOrderByClasificacionDesc();
	List<MusicModel> findByArtista(String artista);
}