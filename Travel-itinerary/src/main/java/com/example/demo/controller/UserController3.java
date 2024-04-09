package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.UserType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/users")
public class UserController3 {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("username", username);
            if (user.getUserType().equals("ADMIN")) {
                modelAndView.setViewName("redirect:/admin/login");
            } else if (user.getUserType().equals("PROVIDER")) {
                modelAndView.setViewName("redirect:/provider/login");
            } else {
                modelAndView.setViewName("redirect:/user/login");
            }
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/login?error=true");
            return modelAndView;
        }
    }

    @GetMapping("/admin/login")
    public String showAdminLoginForm() {
        return "admin_login";
    }

    @GetMapping("/provider/login")
    public String showProviderLoginForm() {
        return "provider_login";
    }

    @GetMapping("/user/login")
    public String showUserLoginForm() {
        return "user_login";
    }
}
