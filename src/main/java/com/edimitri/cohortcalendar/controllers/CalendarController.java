package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.Cohort;
import com.edimitri.cohortcalendar.repositories.CohortRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class CalendarController {

    private final CohortRepository cohortRepository;
    public CalendarController (CohortRepository cohortRepository){
        this.cohortRepository=cohortRepository;
    }

    /*Original calendars controller before ajax view
    @GetMapping(value="/calendars")
    public String allCalendars(){ return"/calendars/calendars";}*/

    @GetMapping("/calendars")
    public String index(Model model) {
        model.addAttribute("cohorts", cohortRepository.findAll());
        return "/calendars/ajax";
    }

    @GetMapping("/calendars.json")
    @ResponseBody
    public List<Cohort> viewAllCohortsInJSONFormat() {
        return cohortRepository.findAll();
    }

    //use @RequestParam to  change url query string
    //multi-value parameter: @RequestParam List<type> name
    //mapping all parameters: @RequestParam Map <type1, type 2> allParams


    @GetMapping("/calendars/ajax")
    public String viewAllCohortsWithAjax() {
        return "/calendars/ajax";
    }

    @GetMapping(value="/calendars/web-dev")
    public String webDev(){return"calendars/web-dev";}

    @GetMapping(value="/calendars/data-science")
    public String dataScience(){return"calendars/data-science";}

    @GetMapping(value="/calendars/sat")
    public String sat(){return"calendars/sat";}

    @GetMapping(value="/calendars/dal")
    public String dal(){return"calendars/dal";}
}
