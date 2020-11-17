package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.User;
import org.springframework.stereotype.Controller;
import com.edimitri.cohortcalendar.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserRepository userdao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDdao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    public class PasswordEncoder {
        public String encode(String password) {
            return password;
        }
    }
}