package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.User;
import org.springframework.stereotype.Controller;
import com.edimitri.cohortcalendar.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;


@Controller
public class UserController {

    private Users users;
    private PasswordEncoder passwordEncoder;
    private UserRepository userDao;

    public UserController(Users users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("sign-up")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

}
/*
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
