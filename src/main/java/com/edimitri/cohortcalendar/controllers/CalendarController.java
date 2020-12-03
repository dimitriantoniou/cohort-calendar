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

    //http servlet request
    //url.getQuery()

    @GetMapping("/calendars.json")
    @ResponseBody
    public List<Cohort> viewAllCohortsInJSONFormat(@RequestParam(required=false) String campus, @RequestParam(required=false) String programType) {
        System.out.println(campus+programType);
        if (campus == null && programType==null) {
            return cohortRepository.findAll();
        }else if (campus!=null){
            return cohortRepository.findByCampus(campus);
        }else if (programType!=null){
            return cohortRepository.findByProgramType(programType);
        }else{
            return cohortRepository.findAll();
        }
        //return cohortRepository.findByProgramType(programType);@RequestParam String programType
        //return cohortRepository.findByCampus(campus);
        //return cohortRepository.findByCampus(campus);
        //return cohortRepository.findAll();

    }

    /* Pseudo code for controller conditional logic
    if (@RequestParam is null){return cohortRepository.findAll();
    }else if (@RequestParam is String campus){return cohortRepository.findByCampus(campus)
    } else if (@RequestParam is String programType){return cohortRepository.findByProgramType(programType)
    }
     */
    //to use the controller, use as conditional; if query is blank --> findAll(); else --> else
        //then do the same set of conditionals in the ajax request

    //use a cohortrepo variable and then return the method after the conditional
    //variable=cohortRepo.findby____
    //return variable
    //OR could have multiple returns



    @GetMapping("/calendars/ajax")
    public String viewAllCohortsWithAjax() {
        return "/calendars/ajax";
    }
}
