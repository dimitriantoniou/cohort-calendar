package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.Cohort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="cohorts")
public class CohortController {

    /*
    @RequestMapping(value="")
    public String cohort(Model model){
        model.addAttribute("cohorts", CohortData.getAll());
        return "cohorts";
    }
     */

    @RequestMapping(value="", method= RequestMethod.GET)
    public String displayAddCohortForm(Model model){
        model.addAttribute("title","Add Cohort");
        return"cohorts";
    }

    /*
    @RequestMapping(value="",method=RequestMethod.POST)
    public String processAddCohortForm(@ModelAttribute Cohort newCohort){
        CohortData.add(newCohort);
        return "redirect:";
    }


     */

}
