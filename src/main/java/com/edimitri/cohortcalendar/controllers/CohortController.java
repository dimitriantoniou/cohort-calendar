package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.Cohort;
import com.edimitri.cohortcalendar.repositories.CohortRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CohortController {

    private CohortRepository cohortRepository;

    public CohortController(CohortRepository cohortRepository) {
        this.cohortRepository = cohortRepository;
    }


    @GetMapping("/cohorts")
    public String cohortsIndex(Model model) {
        List<Cohort> cohorts = cohortRepository.findAll();
        model.addAttribute("cohorts", cohorts);
        return "cohorts/cohorts";
    }
    /*
    @GetMapping("/cohorts")
    public String showAddCohortForm() {
        return "cohorts/cohorts";
    */

    @GetMapping("/cohorts/add")
    public String showAddCohortForm(Model model) {
        model.addAttribute("cohort", new Cohort());
        return "cohorts/add";
    }

    @PostMapping("/cohorts/add")
    public String saveCohort(@ModelAttribute Cohort cohort) {
        cohortRepository.save(cohort);
        return "redirect:/cohorts";
    }


}