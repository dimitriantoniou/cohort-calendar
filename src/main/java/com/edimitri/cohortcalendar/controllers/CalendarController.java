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

    public CalendarController(CohortRepository cohortRepository) {
        this.cohortRepository = cohortRepository;
    }

    /*Original calendars controller before ajax view
    @GetMapping(value="/calendars")
    public String allCalendars(){ return"/calendars/calendars";}*/

    @GetMapping("/calendars")
    public String index(Model model) {
        model.addAttribute("cohorts", cohortRepository.findAll());
        return "/calendars/ajax";
    }

    /*Functioning, non-filtering controller
    @GetMapping("/calendars.json")
    @ResponseBody
    public List<Cohort> viewAllCohortsInJSONFormat() {
        return cohortRepository.findAll();
    }*/

    @GetMapping("/calendars.json")
    @ResponseBody
    public List<Cohort> viewAllCohortsInJSONFormat(@RequestParam String campus) {
        //return cohortRepository.findByProgramType(programType);@RequestParam String programType
        return cohortRepository.findByCampus(campus);
        //return cohortRepository.findByCampus(campus);
        //return cohortRepository.findAll();
    }

    /*
    if (@RequestParam is null){return cohortRepository.findAll();
    }else if (@RequestParam is String campus){return cohortRepository.findByCampus(campus)
    } else if (@RequestParam is String programType){reutrn cohortRepository.findByProgramType(programType)
    }
     */
    //to use the controller, use as conditional; if query is blank --> findAll(); else --> else
        //then do the same set of conditionals in the ajax request

    //create a default state - if no parameter, pass the set of parameters to get all

    //use a cohortrepo variable and then return the method after the conditional
    //OR could have multiple returns, which prevents bugs from making a change that isn't made everywhere
    //variable=cohortRepo.findby____
    //return variable

    //could process the query string within the html


    @GetMapping("/calendars/ajax")
    public String viewAllCohortsWithAjax() {
        return "/calendars/ajax";
    }
}
