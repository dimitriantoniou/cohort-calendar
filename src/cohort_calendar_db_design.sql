CREATE DATABASE IF NOT EXISTS cohortcalendar_db;
USE cohortcalendar_db;

CREATE TABLE users (
id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       first_name VARCHAR(50) NOT NULL,
                       last_name  VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       PRIMARY KEY (id)
);)