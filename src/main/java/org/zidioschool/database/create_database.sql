-- Drop existing database to apply new changes
DROP DATABASE IF EXISTS zidio_school_db;

-- Creates the database for the school management system
CREATE DATABASE IF NOT EXISTS zidio_school_db;
USE zidio_school_db;

-- Table to store class information
CREATE TABLE classes
(
    id             INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
    class_name     VARCHAR(127) NOT NULL UNIQUE COMMENT 'Name of class available for students',
    no_of_students INT          NOT NULL DEFAULT 0 COMMENT 'Number of students in the class'
) COMMENT = 'To store class specific information';

-- Table to store subject information
CREATE TABLE subjects
(
    id           INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
    subject_name VARCHAR(127) NOT NULL UNIQUE COMMENT 'Name of the subject taught'
) COMMENT = 'To store information about subjects available for teaching';

-- Table to store teacher information
CREATE TABLE teachers
(
    id          INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
    first_name  VARCHAR(127) NOT NULL COMMENT 'Teacher first name',
    middle_name VARCHAR(127) COMMENT 'Teacher middle name',
    last_name   VARCHAR(127) NOT NULL COMMENT 'Teacher last name',
    phone_no    VARCHAR(127) NOT NULL UNIQUE COMMENT 'Teacher phone number',
    email       VARCHAR(127) NOT NULL UNIQUE COMMENT 'Teacher email'
) COMMENT = 'To store teacher specific information';

-- Junction table to associate teachers with classes and subjects
CREATE TABLE teacher_class_subject
(
    id         INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
    teacher_id INT NOT NULL COMMENT 'Foreign key referencing teachers',
    class_id   INT NOT NULL COMMENT 'Foreign key referencing classes',
    subject_id INT NOT NULL COMMENT 'Foreign key referencing subjects',
    UNIQUE (teacher_id, class_id), -- Ensures a teacher teaches only one subject per class
    FOREIGN KEY (teacher_id) REFERENCES teachers (id),
    FOREIGN KEY (class_id) REFERENCES classes (id),
    FOREIGN KEY (subject_id) REFERENCES subjects (id)
) COMMENT = 'Associates each teacher with a specific class and subject';

-- Table to store student information
CREATE TABLE students
(
    id              INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary Key',
    id_number       INT UNIQUE COMMENT 'government Id number of a student',
    first_name      VARCHAR(127) NOT NULL COMMENT 'Student first name',
    middle_name     VARCHAR(127) COMMENT 'Student middle name (optional)',
    last_name       VARCHAR(127) NOT NULL COMMENT 'Student last name',
    age             INT          NOT NULL COMMENT 'Student age',
    phone1          VARCHAR(127) NOT NULL UNIQUE COMMENT 'Student primary phone number',
    phone2          VARCHAR(127) UNIQUE COMMENT 'Student secondary phone number (optional)',
    email           VARCHAR(127) NOT NULL UNIQUE COMMENT 'Student email',
    guardian_phone1 VARCHAR(127) NOT NULL COMMENT 'Guardian primary phone number',
    guardian_phone2 VARCHAR(127) COMMENT 'Guardian secondary phone number (optional)',
    guardian_email  VARCHAR(127) NOT NULL UNIQUE COMMENT 'Guardian email',
    class_id        INT COMMENT 'Foreign key referencing classes',
    FOREIGN KEY (class_id) REFERENCES classes (id)
) COMMENT = 'To store student specific information';
