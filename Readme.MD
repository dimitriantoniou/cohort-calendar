
## Codeup Cohort Calendar Application Overview


The Cohort Calendar is the master calendar for Codeup. 
It centralizes cohorts, holidays, adn calendars.


The application receives the following inputs: cohort name, program type, campus, start date, holidays, and daily hours values. 
The application then outputs the graduation date and a gantt chart visualization of the cohort calendars.

Visitors can log in or sign up. Users can view cohort, holiday, and calendar details. Admins can add, edit, and delete cohorts and holidays.

## Demo
Live demo can be viewed here: https://www.codeupcalendar.com

## User stories

#### As a visitor, I can:
- login
- sign up as a user: automatically be authenticated with Codeup domain, or require admin approval for new domains 
- view a description of available features and views
- search for key terms like a cohort name, date, or event

#### As a user, I can:
- login/logout
- view cohort information: name, program type, campus location, start date, grad date, contact hours
- view cohort calendars, filtering by campus or program type
- view holidays: name, date


#### As an admin, I can:
- manage users (Add, Delete, Update)
- manager user permissions
- add, edit, or delete cohorts
- add, edit, or delete holidays

#### Feature List
- [x] register and authenticate users and login
- [x] restrict views based on user permissions
- [x] add, edit, and delete holidays
- [x] assign holidays 0 hour values
- [x] add, edit, and delete cohorts
- [x] automatically calculate graduation dates based on start date, hours, and holidays
- [x] render a visualization to show cohort overlaps
- [x] filter calendar views by program or campus
- [ ] filter cohorts by program, campus, or year
- [ ] render a table to show daily lesson delivery schedule



## To Do
- [x] abstract class for program type that initializes contact hours and daily hours and declares start date and name
- [x] cohort class that extends program type and a constructor with name and start date
- [x] create a cohort form view
- [x] create a CohortData class to store temporary data
- [x] create a cohortcontroller
- [x] build footer fragment
- [x] create holiday model class with name, date, and hours properties
- [x] create holiday constructor
- [x] implement login functionality
- [x] add register page link
- [x] update cohort form to appropriate data inputs
- [x] get navbar dropdown menu to work
- [x] fix spring security dependencies issue
- [x] implement sign up and login functionality with spring security
- [x] Programmatic login after registering a user
- [x] Skip login page if user is authenticated
- [x] add springboot devtools
- [x] create PostMapping for login to profile page
- [x] create holidays view fragment and form
- [x] display data from MySQL holidays table to a table on holidays view
- [x] display data from mysql cohorts to cohorts view table
- [x] add 'all calendars' to calendars dropdown
- [x] build feature that hides login/logout depending on authenticated status
- [x] add scripts to individual calendar views for dropdown functionality
- [x] replace holidays view 'add holiday' form with an 'edit holidays' button
- [x] build 'holidays/edit' view and method
- [x] replace cohorts view 'add cohort' form with an 'edit cohorts' button
- [x] build 'cohorts/edit' view and method
- [x] add a calendar to the all calendars view
- [x] implement fullcalendar
- [x] add js calendar to all calendar views
- [x] get logo to show up in nav bar
- [x] fix date by removing time within date column in holidays and cohorts tables
- [x] fix bug: cannot click calendar dropdown view while on the "all calendars" page
- [x] fix "delete" feature on holidays
- [x] fix "edit" feature on holidays
- [x] fix "delete" feature on cohorts
- [x] fix "edit" feature on cohorts
- [x] fix add cohort feature in CohortController
- [x] fix add holiday feature in HolidayController
- [x] fix date formatting in new holiday form submission: date is appearing 1 day behind - timezone issue?
- [x] fix bug in holiday form submission: name is not saving
- [x] finish grad date calculation feature
- [x] add grad date values to cohort view grid
- [x] implement a gantt chart to show cohort calendars
- [x] html forms accepting dates are saving strings, but need to be stored in DB as Dates
- [ ] populate a Google Calendar with cohort information
- [x] connect gantt chart to cohorts table to change from static to dynamic data input
- [x] create unique gantt chart views for each calendar subdivision 
- [ ] add filter to cohorts to view by program, city, or year
- [x] make cohort chart sort chronologically by start date
- [ ] add holidays filter to select year
- [x] make holidays chart sort chronoligically
- [x] add warning popup when deleting cohorts or holidays


#### Database
- [x] add campuses table and seed
- [x] build db design
- [x] fix sql file and seed holidays table
- [x] fix sql file seed cohorts table
- [x] create db table for program type 
- [x] create db table for campus
- [x] add grad date column to cohort db
- [x] create a table for lesson delivery

#### Permissions
- [ ] restrict 'edit' and 'delete' features to admins
- [ ] add login functionality with google 0auth2



#### Calculating end date
- [x] assign hours values to days of the week
- [x] given a date, determine the day of the week using LocalDate and assign appropriate hours value
- [x] cross-echeck currentdate against holidays
- [x] start on the startDate
- [x] add hours value to totalHours
- [x] move to next date, while totalHours<contactHours (stop when we hit ContactHours)  

#### Rendering Calendar
- [x] write a controller method to retrieve cohort name, start date, grad date, campus, and program type from the cohorts database and return json 
- [x] concatenate 'program' and 'campus' to use as "Resource" field 
- [x] addColumns for gantt chart requirements
- [x] add rows for each cohort
- [x] pass null values for unnecessary fields
- [x] retrieve json data with an ajax request 
- [x] pass data into draw chart
- [x] add function to select and filter by resource (campus/program) type
- [x] remove alternate calendar views and turn links into buttons for viewing on "Calendars" page
- [ ] build a feature to auto calculate percent completion
- [x] active button filter is a different color


#### Bugs
- [x] campuses/program name case sensitivity matching/displaying issue
- [x] footer is floating
- [x] login form input boxes are not aligned
- [ ] search bar is not centered
- [x] username/email name mismatch
- [x] footer is covering page content
- [x] footer not present on all pages
- [x] footer on calendars page has blank space below it
- [ ] home page buttons are not on the same horizontal line
- [x] horizontal lines on cohorts and holidays don't extend across edit and delete
- [x] calendar buttons dont match color scheme
- [x] center cohort calendar buttons
- [x] time zone translation issue: dates added to holiday/cohort are being stored 1 day earlier 
- [x] 2020 grad dates not correct
- [ ] daily hours does not differentiate between WD and DS - both have the same daily hours
- [ ] edit profile submit button returns 404 error


