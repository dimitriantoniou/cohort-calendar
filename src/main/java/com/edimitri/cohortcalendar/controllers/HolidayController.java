package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.Cohort;
import com.edimitri.cohortcalendar.models.Holiday;
import com.edimitri.cohortcalendar.repositories.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HolidayController {

    private HolidayRepository holidayRepository;

    @Autowired
    public HolidayController(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @GetMapping("/holidays")
    public String cohortsIndex(Model model) {
        List<Holiday> holidays = holidayRepository.findAll();
        model.addAttribute("holidays", holidays);
        return "holidays/holidays";
    }

    @GetMapping("/holidays/add")
    public String showAddHolidayForm(Model model){
        model.addAttribute("holiday",new Holiday());
        return "holidays/add";
    }
    @PostMapping("/holidays/add")
    public String addHoliday(@ModelAttribute Holiday holiday) {
        holidayRepository.save(holiday);
        return "redirect:/holidays";
    }

    @GetMapping("/holidays/edit/{id}")
    public String showUpdateHolidayForm(@PathVariable("id") long id, Model model){
        Holiday holiday=holidayRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid holiday id: " +id));
        model.addAttribute("holiday",holiday);
        return "holidays/edit";
    }
    @PostMapping("/holidays/edit/{id}")
    public String updateHoliday(@PathVariable("id") long id, @Valid Holiday holiday, Model model){
        holidayRepository.save(holiday);
        model.addAttribute("holidays",holidayRepository.findAll());
        return "redirect:/holidays";
    }

    @GetMapping("/holidays/delete")
    public String showDeleteHolidayOptions(Model model){
        return "holidays/delete";
    }

    @PostMapping("/holidays/delete")
    public String deleteHolidayByName(@ModelAttribute Holiday holiday){
        holidayRepository.delete(holiday);
        return "redirect:/holidays";
    }

}


