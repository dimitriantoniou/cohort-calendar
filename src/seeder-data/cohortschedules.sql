use cohort_calendar_db;

INSERT INTO cohortschedules(day, period, lesson, lecture_heavy,exercise_heavy, module, evaluation, project, git_workflow,additional_priorities)
VALUES (1, 1, 'Set up, class kick-off; intro to mac, terminal, git',false, false, 'Intro', '','','',''),
       (2, 1, 'Finish set up; intro to Git and GitHub',false, false, 'JavaScript I', '','','work on main/master; push to main/master',''),
       (3, 1, 'Intro to JavaScript',false, false, 'JavaScript I', '','','',''),
       (4, 1, 'Intro to JavaScript; JavaScript with HTML',false, false, 'JavaScript I', '','','',''),
       (5, 1, 'JavaScript with HTML; Functions',true, true, 'JavaScript I', '','','',''),
       (6, 1, 'Git Branching; Functions Walkthrough; Conditionals',false, false, 'JavaScript I', '','','',''),
       (7, 1, 'Git Branching; Practice Assessment',false, false, 'JavaScript I', '','','',''),
       (8, 1, 'Assessment; Review of Assessment; Intro to JavaScript Testing',false, false, 'JavaScript I', 'First JS Assessment','','Introduce branches earlier and use the practice assessment as a tool for teaching it',''),
       (9, 1, 'Conditionals Questions; Loops',false, true, 'JavaScript I', '','','',''),
       (10, 1, 'Loops (cont); Arrays intro',true, false, 'JavaScript I', '','','',''),
       (11, 1, 'Manipulating arrays; Objects',true, true, 'JavaScript I', '','','',''),
       (12, 1, 'Lab Day',false, false, 'JavaScript I', '','','','How to Succeed at Codeup'),
       (13, 1, 'Assessment; Assessment walkthrough; Objects',true, true, 'JavaScript I', 'Second JS Assessment','','',''),
       (14, 1, 'Math Object; Intro to HTML',false, false, 'JavaScript I', '','','',''),
       (12, 1, '',false, false, 'JavaScript I', '','','','');