package com.edimitri.cohortcalendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value="/")
    public String index(){
        return "calendars/calendars";
    }

    @GetMapping(value="/about")
    public String about(){return "about";}
/*
    @GetMapping(value="/login")
    public String login(){return"login";}
*/


}
