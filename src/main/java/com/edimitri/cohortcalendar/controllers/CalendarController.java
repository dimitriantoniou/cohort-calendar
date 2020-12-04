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

    @GetMapping("/calendars")
    public String index(Model model) {
        model.addAttribute("cohorts", cohortRepository.findAll());
        return "/calendars/ajax";
    }

    @GetMapping("/calendars.json")
    @ResponseBody
    public List<Cohort> viewAllCohortsInJSONFormat(@RequestParam(required=false) String campus, @RequestParam(required=false) String programType) {
//        System.out.println(campus+programType);
        if (campus == null && programType==null) {
            return cohortRepository.findAll();
        }else if (campus!=null){
            return cohortRepository.findByCampus(campus);
        }else if (programType!=null){
            return cohortRepository.findByProgramType(programType);
        }else{
            return cohortRepository.findAll();
        }
    }

    @GetMapping("/calendars/ajax")
    public String viewAllCohortsWithAjax() {
        return "/calendars/ajax";
    }
}
