package com.edimitri.cohortcalendar.models;

import java.util.Date;

public class WebDevCohort {
    private String name;
    private Date startDate;
    private String program="Web Dev";
    private int cohortId;
    private static int nextId=1;
    private String description;

    public WebDevCohort(String name, String description) {
        this();
        this.name=name;
        this.description=description;
    }

    public WebDevCohort(){
        cohortId=nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getCohortId() {
        return cohortId;
    }

    public void setCohortId(int cohortId) {
        this.cohortId = cohortId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
