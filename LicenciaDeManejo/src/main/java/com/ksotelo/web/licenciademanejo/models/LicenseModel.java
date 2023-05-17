package com.ksotelo.web.licenciademanejo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "licenses")
public class LicenseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int number;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationDate;
	@NotBlank(message = "debe ingresar un estado")
	private String state;
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private PersonModel person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public PersonModel getPerson() {
		return person;
	}

	public void setPerson(PersonModel person) {
		this.person = person;
	}

	public Date getcreatedAt() {
		return createdAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	public Date getupdatedAt() {
		return updatedAt;
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public LicenseModel() {

	}

	public LicenseModel(int number, Date expirationDate, String state, PersonModel person) {
		this.number = number;
		this.expirationDate = expirationDate;
		this.state = state;
		this.person = person;
	}

}