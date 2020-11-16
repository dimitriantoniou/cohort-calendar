use cohort_calendar_db;

INSERT INTO users(email, first_name, is_admin, last_name, password)
VALUES ('dimitri@codeup.com', 'Dimitri', true, 'Antoniou', 'codeup'),
       ('liz@codeup.com', 'Liz', true, 'Maya', 'codeup'),
       ('jason@codeup.com', 'Jason', true, 'Straughan', 'codeup'),
       ('katie@codeup.com', 'Katie', false, 'Facemire', 'codeup');
