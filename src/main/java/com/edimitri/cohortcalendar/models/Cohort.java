package com.edimitri.cohortcalendar.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cohorts")
public class Cohort {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Date startDate;

    @Column(nullable=false)
    private long programType;

    @Column(nullable=false)
    private long campus;

    @Column(nullable=false)
    private int contactHours;

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

    public long getCohortId() {
        return id;
    }

    public void setCohortId(int cohortId) {
        this.id = cohortId;
    }

}
