package com.example.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.authentication.models.UserModel;
import com.example.authentication.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// registrar el usuario y hacer Hash a su password
	public UserModel registerUser(UserModel user, BindingResult resultado) {
		UserModel userRegistrado = userRepository.findByEmail(user.getEmail());
		if (userRegistrado != null) {
			resultado.rejectValue("email", "Matches", "correo electrónico ya existe");
			return user;
		}
		if (!user.getPassword().equals(user.getPasswordConfirmation())) {
			resultado.rejectValue("password", "Matches", "contraseñas no coinciden");
		}else {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
		}
		return user;

	}

	// encontrar un usuario por su email
	public UserModel findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	// encontrar un usuario por su id
	public UserModel findUserById(Long id) {
		Optional<UserModel> u = userRepository.findById(id);

		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	// autenticar usuario(LOGIN)
	public boolean authenticateUser(String email, String password, BindingResult resultado) {
		// primero encontrar el usuario por su email
		UserModel user = userRepository.findByEmail(email);
		// si no lo podemos encontrar por su email, retornamos false
		if (user == null) {
			resultado.rejectValue("email", "Matches", "correo electronico no valido");
			return false;
		} else {
			// si el password coincide devolvemos true, sino, devolvemos false
			if (BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				resultado.rejectValue("password", "Matches", "contraseña no valida");
				return false;
			}
		}
	}
}
