package org.example.springtp.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.springtp.model.ManageLogin;
import org.example.springtp.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository LoginRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "loginPage";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        ModelAndView model = new ModelAndView();

        if (email.isEmpty() || password.isEmpty()) {
            model.addObject("error", "Tous les champs sont obligatoires.");
            model.setViewName("loginPage");
            return model;
        }

        if(!LoginRepository.findByEmail(email).getPassword().equals(password)) {
            model.addObject("error", "Email ou mot de passe incorrect.");
            model.setViewName("loginPage");
            return model;
        }

        session.setAttribute("email", email);
        model.setViewName("redirect:/");
        return model;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
