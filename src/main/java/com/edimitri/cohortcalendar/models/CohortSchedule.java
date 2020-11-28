package com.edimitri.cohortcalendar.models;

import javax.persistence.*;

@Entity
@Table(name = "cohortschedules")
public class CohortSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Cohort name;

    @Column (nullable=false)
    private int day;

    @Column
    private int week;

    @Column
    private int period;

    @Column
    private String lesson;

    @Column
    private boolean lectureHeavy;

    @Column
    private boolean exerciseHeavy;

    @Column
    private String module;

    @Column
    private String evaluation;

    @Column
    private String project;

    @Column
    private String gitWorkflow;

    @Column
    private String additionalPriorities;

}
