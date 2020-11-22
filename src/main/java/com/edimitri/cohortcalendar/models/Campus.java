package com.edimitri.cohortcalendar.models;
import javax.persistence.*;

@Entity
@Table(name = "campuses")
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String campusName;
}

