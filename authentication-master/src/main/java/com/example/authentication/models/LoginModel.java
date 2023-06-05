package com.example.authentication.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginModel {
	@Email(message = "email no válido")
	@NotBlank(message = "campo email no puede estar vacío")
	private String email;

	@NotBlank(message = "por favor ingresa una contraseña")
	@Size(min = 8, max = 20, message = "password debe tener entre 8 y 20 caracteres")
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginModel() {
		
	}
}
