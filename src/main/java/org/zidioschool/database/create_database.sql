-- Creates the database for the school management system
CREATE DATABASE IF NOT EXISTS zidio_school_db;
USE zidio_shool_db;

-- Tables to store Student information
CREATE TABLE students (
                          id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary Key',
                          first_name VARCHAR(127) NOT NULL COMMENT 'Student first name',
                          middle_name VARCHAR(127) NOT NULL COMMENT 'Student middle name',
                          last_name VARCHAR(127) COMMENT 'Student last name but is optional',
                          age INT NOT NULL COMMENT 'Student age',
                          phone1 VARCHAR(127) NOT NULL UNIQUE COMMENT 'Student first phone number',
                          phone2 VARCHAR(127) UNIQUE COMMENT 'Student second number but is optional',
                          email VARCHAR(127) UNIQUE NOT NULL COMMENT 'Students email',
                          guardian_phone1 VARCHAR(127) NOT NULL COMMENT 'Guardian phone number',
                          guardian_phone2 VARCHAR(127) COMMENT 'Guardian second phone',
                          guardian_email VARCHAR(127) NOT NULL UNIQUE COMMENT 'Guardian email',
                          class_id INT NOT NULL COMMENT 'Foreign key referencing classes',
                          FOREIGN KEY (class_id) REFERENCES classes(id)
) COMMENT = 'To store student specific information';

-- Table to store classes information
CREATE TABLE classes (
                         id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
                         class_name VARCHAR(127) NOT NULL UNIQUE COMMENT 'Name of classes available for student to take',
                         teacher VARCHAR(127) NOT NULL COMMENT 'Teacher teaching the class',
                         no_of_students INT NOT NULL DEFAULT 0 COMMENT 'Number of students in the class',
                         teacher_id INT NOT NULL COMMENT 'Foreign key referencing teachers',
                         FOREIGN KEY (teacher_id) REFERENCES teachers(id)
) COMMENT = 'To store class specific information';

-- Table to store teacher specific information
CREATE TABLE teachers (
                          id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
                          first_name VARCHAR(127) NOT NULL COMMENT 'Student first name',
                          middle_name VARCHAR(127) NOT NULL COMMENT 'Student middle name',
                          last_name VARCHAR(127) COMMENT 'Student last name but is optional',
                          phone_no VARCHAR(127) NOT NULL UNIQUE COMMENT 'Phone number of the teacher',
                          class VARCHAR(127) NOT NULL UNIQUE COMMENT 'Name of class teacher is assigned to',
                          class_id INT NOT NULL COMMENT 'Foreign key referencing classes',
                          FOREIGN KEY (class_id) REFERENCES classes(id)
) COMMENT = 'To store teacher specific information';