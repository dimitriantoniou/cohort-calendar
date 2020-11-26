package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.Cohort;
import com.edimitri.cohortcalendar.models.Holiday;
import com.edimitri.cohortcalendar.repositories.CohortRepository;
import com.edimitri.cohortcalendar.services.CohortCalendarService;
import com.edimitri.cohortcalendar.models.CohortDay;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CohortController {

    private final CohortCalendarService cohortCalendarService;
    private final CohortRepository cohortRepository;
    public CohortController(CohortRepository cohortRepository, CohortCalendarService cohortCalendarService1) {
        this.cohortCalendarService = cohortCalendarService1;
        this.cohortRepository=cohortRepository;
    }

    @GetMapping("/cohorts")
    public String cohortsIndex(Model model) {
        List<Cohort> cohorts = cohortRepository.findAll();
        model.addAttribute("cohorts", cohorts);
        return "cohorts/cohorts";
    }

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

    @GetMapping("/cohorts/delete/{id}")
    public String deleteCohort(@PathVariable(value="id") Long id, Model model){
        Cohort cohort = cohortRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid holiday id: "+id));
        cohortRepository.delete(cohort);
        model.addAttribute("cohorts",cohortRepository.findAll());
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
                dayDisplay = cohortDay.getDate().getDayOfWeek().toString();
            }
            body += String.format("%s,%s,%s\n", cohortDay.getDate().toString(), cohortDay.getHours(), dayDisplay);
        }
        return body;
    }



}