package com.edimitri.cohortcalendar.models;

public class Example {
    private String name;
    private String description;
    private int exampleId;
    private static int nextId=1;

    public Example(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Example(){
        exampleId=nextId;
        nextId++;
    }

    public int getExampleId() {
        return exampleId;
    }

    public void setExampleId(int exampleId) {
        this.exampleId = exampleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
