package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.model.UserType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        userRepository.save(user); // Save user data to the database
        model.addAttribute("successMessage", "User registered successfully!");
        return "register";
    }



// @Controller
// public class UserController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    
    // @GetMapping("/admin/home")
    // public String adminHome() {
    //     return "admin_home";
    // }
    
    // @GetMapping("/service/home")
    // public String serviceHome() {
    //     return "service_home";
    // }
    
    // @GetMapping("/user/home")
    // public String userHome() {
        //     return "home";
    @GetMapping("/admin/login")
    public String showAdminLoginForm() {
        return "admin_login";
    }

    @PostMapping("/admin/login")
    public String adminLsogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password) && user.getUserType().equals("ADMIN")) {
            return "admin_home";
        } else {
            return "error_page";
        }
    }

    @PostMapping("/provider/login")
    public String providerLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password) && user.getUserType().equals("PROVIDER")) {
            return "provider_home";
        } else {
            return "error_page";
        }
    }


    @PostMapping("/user/login")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password) && user.getUserType().equals("USER")) {
            return "home";
        } else {
            return "error_page";
        }
    }

    @GetMapping("/admin/home")
    public String showAdminHomePage() {
        return "admin_home";
    }

    @GetMapping("/provider/login")
    public String showServiceProviderLoginForm() {
        return "provider_login";
    }

    @GetMapping("/user/login")
    public String showNormalUserLoginForm() {
        return "user_login";
    }

}
