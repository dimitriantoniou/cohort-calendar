package com.edimitri.cohortcalendar.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cohorts")
public class Cohort {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false,unique=true)
    private String name;

    @Column(nullable=false)
    private Date startDate;

    @Column(nullable=false)
    private long programType;

    @Column(nullable=false)
    private long campus;

    @Column(nullable=false)
    private int contactHours;

    public Cohort(String name, Date startDate, long programType, long campus, int contactHours) {
        this();
        this.name = name;
        this.startDate = startDate;
        this.programType = programType;
        this.campus = campus;
        this.contactHours = contactHours;
    }

    public Cohort(){
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

    public long getCohortId() {
        return id;
    }

    public void setCohortId(int cohortId) {
        this.id = cohortId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProgramType() {
        return programType;
    }

    public void setProgramType(long programType) {
        this.programType = programType;
    }

    public long getCampus() {
        return campus;
    }

    public void setCampus(long campus) {
        this.campus = campus;
    }

    public int getContactHours() {
        return contactHours;
    }

    public void setContactHours(int contactHours) {
        this.contactHours = contactHours;
    }
}