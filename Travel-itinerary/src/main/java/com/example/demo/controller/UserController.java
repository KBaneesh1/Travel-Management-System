package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
}

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.ui.Model;

// @Controller
// public class UserController {

//     @GetMapping("/login")
//     public String showLoginForm() {
//         return "login";
//     }

//     @PostMapping("/login")
//     public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
//         // Add your authentication logic here
//         // For demonstration purposes, let's assume a simple hardcoded authentication
//         if ("admin".equals(username) && "password".equals(password)) {
//             return "redirect:/home"; // Redirect to home page upon successful login
//         } else {
//             model.addAttribute("error", "Invalid username or password");
//             return "login"; // Return to login page with error message
//         }
//     }

//     @GetMapping("/home")
//     public String home() {
//         return "home";
//     }

//     @GetMapping("/register")
//     public String showRegistrationForm(Model model) {
//         model.addAttribute("user", new User());
//         return "register";
//     }

//     @PostMapping("/register")
//     public String registerUser(@ModelAttribute("user") User user, Model model) {
//         // Add your user registration logic here
//         // For demonstration purposes, let's assume we just print the user details
//         System.out.println("User registered: " + user.getUsername() + ", " + user.getEmail());
//         model.addAttribute("successMessage", "User registered successfully!");
//         return "register";
//     }
// }
