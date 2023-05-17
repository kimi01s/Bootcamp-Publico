package com.ksotelo.web.licenciademanejo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "persons")
public class PersonModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "nombre no puede estar vacío")
	private String firstName;

	@NotBlank(message = "apellido no puede estar vacío")
	private String lastName;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private LicenseModel license;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public LicenseModel getLicense() {
		return license;
	}

	public void setLicense(LicenseModel license) {
		this.license = license;
	}
	
	public Date getcreatedAt() {
		return createdAt;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}

	public Date getupdatedAt() {
		return updatedAt;
	}
	
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public PersonModel() {

	}

	public PersonModel(String firstName, String lastName, LicenseModel license) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.license = license;
	}

}