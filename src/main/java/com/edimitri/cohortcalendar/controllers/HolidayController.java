package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.Holiday;
import com.edimitri.cohortcalendar.repositories.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HolidayController {

    private final HolidayRepository holidayRepository;

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

    @GetMapping("/holidays/{id}/edit")
    public String showUpdateHolidayForm(@PathVariable("id") Long id, Model model){
        Holiday holiday=holidayRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid holiday id: " +id));
        model.addAttribute("holiday",holiday);
        return "holidays/edit";
    }
    @PostMapping("holidays/{id}/edit")
    public String editHoliday(@PathVariable Long id, @Valid Holiday editedHoliday, Model model){
        editedHoliday.setId(id);
        editedHoliday.setName(editedHoliday.getName());
        holidayRepository.save(editedHoliday);
        return "redirect:/holidays";
    }

    /*
    @PostMapping("/holidays/edit/{id}")
    public String updateHoliday(@PathVariable long id, @Valid Holiday holiday, Model model){
        holidayRepository.save(holiday);
        model.addAttribute("holidays",holidayRepository.findAll());
        return "redirect:/holidays";
    }*/

    @GetMapping("/holidays/delete/{id}")
    public String deleteHoliday(@PathVariable(value="id") Long id, Model model){
        Holiday holiday = holidayRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid holiday id: "+id));
        holidayRepository.delete(holiday);
        model.addAttribute("holidays",holidayRepository.findAll());
        return "redirect:/holidays";
    }
}


