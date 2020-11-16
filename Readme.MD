
## Codeup Cohort Calendar Application Overview


The Cohort Calendar is the master calendar for Codeup. 
It records start dates, graduation dates, holidays, and daily/weekly hours.


The application receives the following inputs: program, contact hours, start date, holidays, daily hours values
The application outputs the graduation date and a full calendar.

Visitors can view calendars. Users can view calendar details. Admins can add, edit, and delete calendars.


## User stories

#### As a visitor, I can:
- read about the site, login, or view calendars
- view calendars by location, program, or year
- search for key terms like a cohort name, date, or event
- view the calendar for any individual cohort by name
- easily access key calendar information, like start dates, graduation dates, and holidays
- login or sign-up as a user and create a profile page with automated auth with Codeup domain
- non Codeup domains need approval by admin

#### As a user, I can:
- add new cohorts
- edit cohort calendars by program, location, start date
- add comments to cohort calendars with post confirmation
- edit cohort calendars that I have edit access to by program, location, start date


#### As an admin, I can:
- manage users (Add, Delete, Update)
- manager user permissions

#### Feature List
- register users and login auth
- input a start date and contact hours
- assign week-day values
- assign holidays and no-class days
- output a graduation date
- give users permissions to edit different calendars
- moderate comments, including hiding/deleting

## To Do
- ~~abstract class for program type that initializes contact hours and daily hours and declares start date and name~~
- ~~cohort class that extends program type and a constructor with name and start date~~
- ~~create a cohort form view~~
- ~~create a CohortData class to store temporary data~~
- ~~create a cohortcontroller~~
- ~~build db design~~
- ~~build footer fragment~~
- ~~create holiday model class with name, date, and hours properties~~
- ~~create holiday constructor~~
- create holidays view fragment
- implement login functionality
- add register page link
- update cohort form to appropriate data inputs
- fix sql file and seed holidays table
- fix sql file seed cohorts table
- create table for program type 
- create table for campus
- ~~get navbar dropdown menu to work~~


## Demo
Live demo can be viewed here:

## Database Design

