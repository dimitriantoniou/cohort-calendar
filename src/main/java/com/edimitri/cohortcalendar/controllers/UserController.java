package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.*;
import com.edimitri.cohortcalendar.services.UserService;
import com.google.inject.internal.Errors;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*@Autowired
    private UserRoles userRoles;*/

    @Autowired
    private UserService userService;

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

    /*@PostMapping("/users/create")
    public String saveUser(@Valid User user, Errors validation, Model m){

        String username = user.getUsername();
        User existingUsername = userRepository.findByUsername(username);
        User existingEmail = userRepository.findByEmail(user.getEmail());

*//*
        if(existingUsername != null){

            validation.rejectValue("username", "user.username", "Duplicated username " + username);

        }

        if(existingEmail != null){

            validation.rejectValue("email", "user.email", "Duplicated email " + user.getEmail());

        }

 *//*

        if (validation.hasErrors()) {
            m.addAttribute("errors", validation);
            m.addAttribute("user", user);
            return "users/create";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Custom validation if the username is taken

        User newUser = UserRepository.save(user);

        UserRole ur = new UserRole();
        ur.setRole("ROLE_USER");
        ur.setUserId(newUser.getId());
        userRoles.save(ur);

        // Programmatic login after registering a user
        UserService.authenticate(user);

        m.addAttribute("user", user);
        return "redirect:/";

    }*/


    @GetMapping("/users/profile")
    public String showProfile(Model viewModel){
        User logUser = UserService.loggedInUser();

        if(logUser == null){
            viewModel.addAttribute("msg", "You need to be logged in to be able to see this page");
            return "errora";
        }
        return "redirect:/users/" + UserService.loggedInUser().getId();
    }
    @GetMapping("/users/{id}")
    public String showUser(@PathVariable Long id, Model viewModel){
        User user = userRepository.getOne(id);
        viewModel.addAttribute("user", user);
        viewModel.addAttribute("sessionUser", UserService.loggedInUser());
        viewModel.addAttribute("showEditControls", UserService.canEditProfile(user));
        return "users/profile";
    }


    @GetMapping("/users/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model viewModel){
        User user = userRepository.getOne(id);
        viewModel.addAttribute("user", user);
        viewModel.addAttribute("showEditControls", UserService.canEditProfile(user));
        return "users/edit";
    }
    @PostMapping("/users/{id}/edit")
    public String editUser(@PathVariable Long id, @Valid User editedUser, Errors validation, Model m){

        editedUser.setId(id);

        if (validation.hasErrors()) {
            m.addAttribute("errors", validation);
            m.addAttribute("user", editedUser);
            m.addAttribute("showEditControls", checkEditAuth(editedUser));
            return "users/edit";
        }
        editedUser.setFirstName(editedUser.getFirstName());
        editedUser.setLastName(editedUser.getLastName());
        editedUser.setEmail(editedUser.getEmail());
        editedUser.setPassword(passwordEncoder.encode(editedUser.getPassword()));
        userRepository.save(editedUser);
        return "redirect:/users/" + UserService.loggedInUser().getId();
    }

    public Boolean checkEditAuth(User user){
        return UserService.isLoggedIn() && (user.getId() == UserService.loggedInUser().getId());
    }

    @GetMapping("/users/all-users")
    public String allUsers() {
        return "users/all-users";
    }


}