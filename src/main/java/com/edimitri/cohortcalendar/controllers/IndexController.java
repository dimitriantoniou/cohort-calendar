package com.edimitri.cohortcalendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value="/")
    public String index(){
        return "index";
    }

    @GetMapping(value="/about")
    public String about(){return "about";}
/*
    @GetMapping(value="/login")
    public String login(){return"login";}
*/

    @GetMapping(value="/calendars")
    public String calendars(){return"calendars";}

    @GetMapping(value="/calendars/web-dev")
    public String webDev(){return"calendars/web-dev";}

    @GetMapping(value="/calendars/data-science")
    public String dataScience(){return"calendars/data-science";}

    @GetMapping(value="/calendars/sat")
    public String sat(){return"calendars/sat";}

    @GetMapping(value="/calendars/dal")
    public String dal(){return"calendars/dal";}

    @GetMapping(value="/register")
    public String register(){return "sign-up";}
}
