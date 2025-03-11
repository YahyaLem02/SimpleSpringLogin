package org.example.springtp.controllers;

import org.example.springtp.model.Login;
import org.example.springtp.model.User;
import org.example.springtp.repositories.LoginRepository;
import org.example.springtp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginRepository loginRepository;

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

        if (loginRepository.findByEmail(email) != null) {
            model.addObject("error", "Cet email est déjà utilisé.");
            model.setViewName("inscription");
            return model;
        }

        Login login = new Login(email, password);
        loginRepository.save(login);

        User user = new User();
        user.setUsername(username);
        user.setLogins(Collections.singletonList(login));
        userRepository.save(user);

        model.setViewName("redirect:/login");
        return model;
    }
}