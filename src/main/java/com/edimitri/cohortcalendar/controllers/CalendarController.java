package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.Event;
import com.edimitri.cohortcalendar.repositories.EventRepository;
import com.edimitri.cohortcalendar.services.CalendarEventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CalendarController {
    private EventRepository eventRepository;

    @GetMapping(value="/calendars")
    public String calendars(Model model){
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events",events);
        return"calendars/calendars";
    }

    /*@PostMapping("/calendars")
    public String addEvent(@ModelAttribute Event event){
        List<Event> events = CalendarEventService.getEvents(Event.getName());
        EventRepository.save(event);
        return"redirect:/calendars/calendars";
    }*/

    @GetMapping(value="/calendars/web-dev")
    public String webDev(){return"calendars/web-dev";}

    @GetMapping(value="/calendars/data-science")
    public String dataScience(){return"calendars/data-science";}

    @GetMapping(value="/calendars/sat")
    public String sat(){return"calendars/sat";}

    @GetMapping(value="/calendars/dal")
    public String dal(){return"calendars/dal";}
}
