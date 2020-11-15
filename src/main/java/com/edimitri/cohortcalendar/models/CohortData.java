package com.edimitri.cohortcalendar.models;

import java.util.ArrayList;

public class CohortData {
        static ArrayList<WebDevCohort> cohorts = new ArrayList<>();

        //getAll
        public static ArrayList<WebDevCohort> getAll(){
            return cohorts;
        }

        //add
        public static void add (WebDevCohort newCohort){
            cohorts.add(newCohort);
        }

        //remove
        public static void remove (int id){
            WebDevCohort cohortToRemove=getById(id);
            cohorts.remove(cohortToRemove);
        }

        //getById
        public static WebDevCohort getById(int id){
            WebDevCohort theCohort=null;
            for (WebDevCohort potentialCohort : cohorts){
                if (potentialCohort.getCohortId()==id){
                    theCohort=potentialCohort;
                }
            }
            return theCohort;
        }
}
