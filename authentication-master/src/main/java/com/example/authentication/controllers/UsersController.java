package com.example.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.authentication.models.LoginModel;
import com.example.authentication.models.UserModel;
import com.example.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UsersController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(@ModelAttribute("user") UserModel newUser) {
		return "registrationPage.jsp";
	}

	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") UserModel newUser, BindingResult result, Model viewModel) {
		UserModel usuarioRegistrado = userService.registerUser(newUser, result);
		if (result.hasErrors()) {
			return "registrationPage.jsp";
		}
		if(usuarioRegistrado != null) {
			viewModel.addAttribute("succesRegister", "Gracias por registrarte, por favor login");
			return"redirect:/home";
		}
		return "registrationPage.jsp";
	}

	@GetMapping("/login")
	public String formLogin(@ModelAttribute("login") LoginModel login) {
		return "loginPage.jsp";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LoginModel login, BindingResult result, HttpSession session,
			Model viewModel) {
		if (result.hasErrors()) {
			return "loginPage.jsp";
		}
		if(userService.authenticateUser(login.getEmail(), login.getPassword(), result)) {
			UserModel u = userService.findByEmail(login.getEmail());
			session.setAttribute("userId", u.getId());
			return "redirect:/home";
		}
		return "loginPage.jsp";
	}

	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
		UserModel u = userService.findUserById(userId);
		model.addAttribute("user", u);
		return "homePage.jsp";
		}else {
			return "redirect:/login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
//		session.removeAttribute("userId");
//		model.addAttribute("message", "Data removed successfully");
		return "redirect:/login";
	}
}
