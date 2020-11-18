package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.User;
import com.edimitri.cohortcalendar.models.UserWithRoles;
import com.edimitri.cohortcalendar.repositories.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import com.edimitri.cohortcalendar.repositories.UserRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private Roles roles;

    @Autowired
    public UserController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            UserRepository userRezpository, PasswordEncoder passwordEncoder1, Roles roles
    ) {
        this.userRepository = userRezpository;
        this.passwordEncoder = passwordEncoder1;
        this.roles = roles;
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
        userRepository.save(user);
        authenticate(user);
        return "redirect:/profile";
    }

    private void authenticate(User user) {
        UserDetails userDetails = new UserWithRoles(user, Collections.emptyList());
        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(auth);
    }

    @GetMapping("/profile")
    public String profile(){
        return "users/profile";
    }
}