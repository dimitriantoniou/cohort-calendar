package com.edimitri.cohortcalendar.controllers;

import com.edimitri.cohortcalendar.models.Cohort;
import com.edimitri.cohortcalendar.repositories.CohortRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CalendarController {
    private CohortRepository cohortRepository;

    @GetMapping(value="/calendars")
    public String calendars(){return"calendars/calendars";}


    @GetMapping(value="/calendars/web-dev")
    public String webDev(){return"calendars/web-dev";}

    @GetMapping(value="/calendars/data-science")
    public String dataScience(){return"calendars/data-science";}

    @GetMapping(value="/calendars/sat")
    public String sat(){return"calendars/sat";}

    @GetMapping(value="/calendars/dal")
    public String dal(){return"calendars/dal";}
}
