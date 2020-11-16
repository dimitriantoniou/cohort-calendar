package com.edimitri.cohortcalendar.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cohorts")

public class Cohort {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;
    private Date startDate;
    private long program;
    private int cohortId;

    public Cohort(String name) {
        this.name=name;
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

}
