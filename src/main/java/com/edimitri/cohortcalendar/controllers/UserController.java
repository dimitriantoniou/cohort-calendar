package com.edimitri.cohortcalendar.controllers;

import org.springframework.stereotype.Controller;
import com.edimitri.cohortcalendar.repositories.UserRepository;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;


@Controller
public class UserController {

    private UserRepository userDao;

    public UserController(UserRepository userDao){
        this.userDao=userDao;
    }
/*
    @GetMapping(value="/register")
    public String showSignupForm(Model model){
        model.addAttribute("user",new User());
        return "register";
    }


 */
/*
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User newUser, Model model) {
        String email = newUser.getEmail();
        String emailExists = userDao.findByEmail(email);

        if (emailExists != null) {//if email user already exists (is not null)
            validation.rejectValue("email", "user.email", email + " already exists in our records.");
        }
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "register";
        }
        String hash=passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(newUser);
        return"Redirect:/";
    }


 */

    }