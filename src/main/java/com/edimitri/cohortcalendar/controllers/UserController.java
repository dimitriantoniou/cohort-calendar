package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.Cohort;
import com.edimitri.cohortcalendar.models.CohortDay;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

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
/*
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
    }*/

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

    @GetMapping("/user/{id}")
    public String profile(){
        return "users/profile";
    }

    @GetMapping("/user/{id}/edit")
    public String showUpdateProfileForm(@PathVariable("id") Long id, Model model){
        User user=userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("invalid user id: " +id));
        model.addAttribute("user",user);
        return"cohorts/edit";
    }
    @PostMapping("user/{id}/edit")
    public String editProfile(@PathVariable Long id, @Valid User editedUser, Model model){
        editedUser.setId(id);
        editedUser.setFirstName(editedUser.getFirstName());
        editedUser.setLastName(editedUser.getLastName());
        editedUser.setUsername(editedUser.getUsername());
        editedUser.setPassword(editedUser.getPassword());
        userRepository.save(editedUser);
        return"redirect:/profile";
    }

    @GetMapping("/users/all-users")
    public String allUsers() {
        return "users/all-users";
    }


}