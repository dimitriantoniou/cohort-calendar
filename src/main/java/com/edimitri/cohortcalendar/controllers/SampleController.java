package com.edimitri.cohortcalendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import com.edimitri.cohortcalendar.models.Example;

@Controller
@RequestMapping("sample")
public class SampleController {
    static ArrayList<Example> examples = new ArrayList<>();

    //request path: /sample
    @RequestMapping(value="")
    public String sample(Model model){

        model.addAttribute("examples",examples);
        model.addAttribute("title","My Sample");
        return "sample/sample";
    }

    @RequestMapping(value="add", method= RequestMethod.GET)
    public String displayAddSampleForm(Model model){
        model.addAttribute("title","Add Sample");
        return"sample/add";
    }

    @RequestMapping(value="add",method=RequestMethod.POST)
    public String processAddSampleForm(@RequestParam String exampleName, @RequestParam String exampleDescription){
        Example newExample = new Example(exampleName, exampleDescription);
        examples.add(newExample);

        //redirect to /sample
        return "redirect:";
    }

    @RequestMapping(value="remove",method=RequestMethod.GET)
    public String displayRemoveExampleForm(Model model){
        model.addAttribute("examples",examples);
        model.addAttribute("title","Remove Example");
        return "sample/remove";
    }

    @RequestMapping(value="remove",method=RequestMethod.POST)
    public String processRemoveExampleForm(@RequestParam ArrayList<String> example){
        for(String anExample : example){
            examples.remove(anExample);
        }
        return "redirect:";
    }

}
