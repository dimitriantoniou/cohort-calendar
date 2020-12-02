
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
- manage campuses
- manage programs

#### Feature List
- register users and login auth
- assign week-day values
- assign holidays and no-class days
- input a start date and contact hours to output graduation
- render a visualization to show cohort overlaps
- render a table to show daily lesson delivery schedule
- give users permissions to edit different calendars
- moderate comments, including hiding/deleting

## To Do
- ~~abstract class for program type that initializes contact hours and daily hours and declares start date and name~~
- ~~cohort class that extends program type and a constructor with name and start date~~
- ~~create a cohort form view~~
- ~~create a CohortData class to store temporary data~~
- ~~create a cohortcontroller~~
- ~~build footer fragment~~
- ~~create holiday model class with name, date, and hours properties~~
- ~~create holiday constructor~~
- ~~implement login functionality~~
- ~~add register page link~~
- ~~update cohort form to appropriate data inputs~~
- ~~get navbar dropdown menu to work~~
- ~~fix spring security dependencies issue~~
- ~~implement sign up and login functionality with spring security~~
- ~~Programmatic login after registering a user~~
- ~~Skip login page if user is authenticated~~
- ~~add springboot devtools~~
- ~~create PostMapping for login to profile page~~
- ~~create holidays view fragment and form~~
- ~~display data from MySQL holidays table to a table on holidays view~~
- ~~display data from mysql cohorts to cohorts view table~~
- ~~add 'all calendars' to calendars dropdown~~
- ~~build feature that hides login/logout depending on authenticated status~~
- ~~add scripts to individual calendar views for dropdown functionality~~
- ~~replace holidays view 'add holiday' form with an 'edit holidays' button~~
- ~~build 'holidays/edit' view and method~~
- ~~replace cohorts view 'add cohort' form with an 'edit cohorts' button~~
- ~~build 'cohorts/edit' view and method~~
- ~~add a calendar to the all calendars view~~
- ~~implement fullcalendar~~
- ~~add js calendar to all calendar views~~
- ~~get logo to show up in nav bar~~
- ~~fix date by removing time within date column in holidays and cohorts tables~~
- ~~fix bug: cannot click calendar dropdown view while on the "all calendars" page~~
- ~~fix "delete" feature on holidays~~
- ~~fix "edit" feature on holidays~~
- ~~fix "delete" feature on cohorts~~
 - ~~fix "edit" feature on cohorts~~
- ~~fix add cohort feature in CohortController~~
- ~~fix add holiday feature in HolidayController~~
- ~~fix date formatting in new holiday form submission: date is appearing 1 day behind - timezone issue?~~
- ~~fix bug in holiday form submission: name is not saving~~
- ~~finish grad date calculation feature~~
- ~~add grad date values to cohort view grid~~
- ~~implement a gantt chart to show cohort calendars~~
- ~~html forms accepting dates are saving strings, but need to be stored in DB as Dates~~
- populate a Google Calendar with cohort information
- connect gantt chart to cohorts table to change from static to dynamic data input
- create unique gantt chart views for each calendar subdivision 

#### Database
- ~~add campuses table and seed~~
- ~~build db design~~
- ~~fix sql file and seed holidays table~~
- ~~fix sql file seed cohorts table~~
- ~~create db table for program type~~ 
- ~~create db table for campus~~
- ~~add grad date column to cohort db~~
- create a table for lesson delivery
- add filter to cohorts to view by program, city, or year
- make cohort chart sort chronologically by start date
- add holidays filter to select year
- make holidays chart sort chronoligically

#### Permissions
- restrict edit and delete features to admins
- add login functionality with google 2ath



#### Calculating end date
- ~~assign hours values to days of the week~~
- ~~given a date, determine the day of the week using LocalDate and assign appropriate hours value~~
- ~~cross-echeck currentdate against holidays~~
- ~~start on the startDate~~
- ~~add hours value to totalHours~~
- ~~move to next date, while totalHours<contactHours (stop when we hit ContactHours)~~  

#### Rendering Calendar
- ~~write a controller method to retrieve cohort name, start date, grad date, campus, and program type from the cohorts database and return json~~ 
- ~~concatenate 'program' and 'campus' to use as "Resource" field~~ 
- ~~addColumns for gantt chart requirements~`
- ~~add rows for each cohort~~
- ~~pass null values for unnecessary fields~~
- ~~retrieve json data with an ajax request~~ 
- ~~pass data into draw chart~~
- add function to select and filter by resource (campus/program) type
- remove alternate calendar views and turn links into buttons for viewing on "Calendars" page
- build a feature to auto calculate percent completion

## Demo
Live demo can be viewed here:
