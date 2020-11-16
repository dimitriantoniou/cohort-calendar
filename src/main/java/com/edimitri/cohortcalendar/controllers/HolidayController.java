package com.edimitri.cohortcalendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolidayController {
    @RequestMapping(value="/holidays")
    public String index(){
        return "holidays";
    }
}
