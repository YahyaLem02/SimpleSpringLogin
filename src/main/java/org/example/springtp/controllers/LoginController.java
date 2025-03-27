package org.example.springtp.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.springtp.entities.User;
import org.example.springtp.models.ManageLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "loginPage";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        ModelAndView model = new ModelAndView();

        if (ManageLogin.instance.checkCredentials(email, password)) {
            User user = ManageLogin.instance.getUserByEmail(email);
            session.setAttribute("user", user);

            model.addObject("username", user.getUsername());
            model.addObject("userList", ManageLogin.instance.getAllUsers());
            model.setViewName("WelcomePage");
        } else {
            model.addObject("message", "Email ou mot de passe incorrect.");
            model.setViewName("loginPage");
        }

        return model;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}