package com.ksotelo.web.lookify.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "songs")
public class MusicModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "titulo no puede estar vacío")
	@Size(min = 5, message = "el campo titulo debe tener un mínimo de 5 carácteres")
	private String titulo;

	@NotBlank(message = "debe agregar un artista")
	@Size(min = 5, message = "el campo artista debe tener un mínimo de 5 carácteres")
	private String artista;

	@NotNull(message = "debe seleccionar una clasificación")
	@Min(1)
	@Max(10)
	private Integer clasificacion;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public Integer getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Integer clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Date getcreatedAt() {
		return createdAt;
	}

	public void setcreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getupdatedAt() {
		return updatedAt;
	}

	public void setupdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public MusicModel(
			@NotBlank(message = "titulo no puede estar vacío") @Size(min = 5, message = "el campo titulo debe tener un mínimo de 5 carácteres") String titulo,
			@NotBlank(message = "debe agregar un artista") @Size(min = 5, message = "el campo artista debe tener un mínimo de 5 carácteres") String artista,
			@NotNull(message = "debe seleccionar una clasificación") @Min(100) Integer clasificacion) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.clasificacion = clasificacion;
	}

	public MusicModel() {
	}

}