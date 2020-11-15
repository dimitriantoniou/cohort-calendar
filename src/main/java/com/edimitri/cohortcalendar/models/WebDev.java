package com.edimitri.cohortcalendar.models;

import java.util.Date;

abstract class WebDev {
    public float contactHours=670;
    public float mondayHours=7;
    public float tuesdayHours=6;
    public float wednesdayHours= (float) 3.5;
    public float thursdayHours= (float) 6.5;
    public float fridayHours=7;
    public String name;
    public Date startDate;

    public WebDev(String name) {
        this.name = name;
    }
}
