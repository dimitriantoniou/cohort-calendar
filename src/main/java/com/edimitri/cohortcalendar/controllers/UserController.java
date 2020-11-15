package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value="/register")
    public String register(){
        return "register";
    }

    /*
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User newUser, Model model){
        String email=newUser.getEmail();

        //if(emailExists!=null){//if email user already exists (is not null)
        }

     */
    }