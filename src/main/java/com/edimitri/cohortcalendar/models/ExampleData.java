package com.edimitri.cohortcalendar.models;

import java.util.ArrayList;

public class ExampleData {
    static ArrayList<Example> examples = new ArrayList<>();

    //getAll
    public static ArrayList<Example> getAll(){
        return examples;
    }

    //add
    public static void add (Example newExample){
        examples.add(newExample);
    }
    //remove
    public static void remove (int id){
        Example exampleToRemove=getById(id);
        examples.remove(exampleToRemove);
    }

    //getById
    public static Example getById(int id){
        Example theExample=null;
        for (Example potentialExample : examples){
            if (potentialExample.getExampleId()==id){
                theExample=potentialExample;
            }
        }
        return theExample;
    }
}
