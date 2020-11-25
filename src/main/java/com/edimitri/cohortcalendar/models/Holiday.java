package com.edimitri.cohortcalendar.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "holidays")
public class Holiday {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false, unique=true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Holiday(){}

    public Holiday(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String holidayName) {
        this.name= name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
