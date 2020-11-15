#Codeup Cohort Calendar Application
##Overview
The Cohort Calendar is the master calendar for Codeup. 
It records start dates, graduation dates, holidays, and daily/weekly hours.


The application receives the following inputs: program, contact hours, start date, holidays, daily hours values
The application outputs the graduation date and a full calendar.

Visitors can view calendars. Users can view calendar details. Admins can add, edit, and delete calendars.

##Demo
Live demo can be viewed here:

##Database Design


## User stories

#### As a visitor, I can:
- read about the site, login, or view calendars
- view calendars by location, program, or year
- search for key terms like a cohort name, date, or event
- view the calendar for any individual cohort by name

#### As a user, I can:
- add new cohorts
- edit cohort calendars by program, location, start date

####As an admin, I can:
- manage users (Add, Delete, Update)
- manager user permissions

####Feature List
- register users and login auth
- input a start date and contact hours
- assign week-day values
- assign holidays and no-class days
- output a graduation date

##To Do
- ~~abstract class for program type that initializes contact hours and daily hours and declares start date and name~~
- ~~cohort class that extends program type and a constructor with name and start date~~
- ~~create a cohort form view~~
- ~~create a CohortData class to store temporary data~~
- ~~create a cohortcontroller~~
- figure out how to get the cohort data submitted on the form to show up on the table
in the cohorts view when redirected
- get dropdown to work

## Project Organization
- controllers
- models
- views

## Project setup and run