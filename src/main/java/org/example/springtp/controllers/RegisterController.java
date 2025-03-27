package org.example.springtp.controllers;

import org.example.springtp.models.ManageLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @GetMapping("/")
    public String showRegisterPage() {
        return "inscription";
    }

    @PostMapping("/register")
    public ModelAndView register(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String passwordConfirm) {

        ModelAndView model = new ModelAndView();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
            model.addObject("error", "Tous les champs sont obligatoires.");
            model.setViewName("inscription");
            return model;
        }

        if (!password.equals(passwordConfirm)) {
            model.addObject("error", "Les mots de passe ne correspondent pas.");
            model.setViewName("inscription");
            return model;
        }

        if (ManageLogin.instance.getUserByEmail(email) != null) {
            model.addObject("error", "Cette adresse email est déjà utilisée.");
            model.setViewName("inscription");
            return model;
        }

        ManageLogin.instance.addUser(username, email, password);
        model.addObject("message", "Inscription réussie ! Vous pouvez maintenant vous connecter.");
        model.setViewName("loginPage");
        return model;
    }
}