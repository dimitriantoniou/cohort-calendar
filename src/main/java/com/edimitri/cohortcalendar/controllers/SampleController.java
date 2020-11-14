package com.edimitri.cohortcalendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sample")
public class SampleController {
    //request path: /sample
    @RequestMapping(value="")
    public String sample(){
        return "sample/sample";
    }
}
