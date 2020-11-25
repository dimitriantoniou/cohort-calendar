package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.Cohort;
import com.edimitri.cohortcalendar.models.CohortDay;
import com.edimitri.cohortcalendar.repositories.CohortRepository;
import com.edimitri.cohortcalendar.services.CohortCalendarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CohortController {

    private CohortRepository cohortRepository;

    //Douglas code
    private final CohortCalendarService cohortCalendarService;

    public CohortController(CohortRepository cohortRepository,CohortCalendarService cohortCalendarService) {
        this.cohortRepository = cohortRepository;
        //Douglas code
        this.cohortCalendarService = cohortCalendarService;
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

    //Douglas code
    @GetMapping("/get-calendar/{year}/{month}/{day}")
    @ResponseBody
    public String getCalendar(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
        List<CohortDay> calendar = cohortCalendarService.getCalendar(LocalDate.of(year, month, day) );
        String body = "";

        for (CohortDay cohortDay: calendar) {
            String dayDisplay = "";
            if(cohortDay.getHoliday() != null) {
                dayDisplay = String.format("%s", cohortDay.getHoliday().getName());
            } else {
                dayDisplay = cohortDay.getHolidayDate().getDayOfWeek().toString();
            }
            body += String.format("%s,%s,%s\n", cohortDay.getHolidayDate().toString(), cohortDay.getHours(), dayDisplay);
        }

        return body;
    }



}