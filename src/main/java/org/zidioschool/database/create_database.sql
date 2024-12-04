-- Creates the database for the school management system
CREATE DATABASE IF NOT EXISTS zidio_school_db;
USE zidio_school_db;

-- Table to store teacher information
CREATE TABLE teachers
(
    id          INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
    first_name  VARCHAR(127) NOT NULL COMMENT 'Teacher first name',
    middle_name VARCHAR(127) COMMENT 'Teacher middle name',
    last_name   VARCHAR(127) COMMENT 'Teacher last name (optional)',
    phone_no    VARCHAR(127) NOT NULL UNIQUE COMMENT 'Teacher phone number',
    email       VARCHAR(127) NOT NULL UNIQUE COMMENT 'Teacher email'
) COMMENT = 'To store teacher specific information';

-- Table to store users for teacher login and registration
CREATE TABLE users
(
    id            INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
    email         VARCHAR(127) NOT NULL UNIQUE COMMENT 'Email for login (linked to teachers)',
    password_hash VARCHAR(255) NOT NULL COMMENT 'Password hash for authentication',
    teacher_id    INT          NOT NULL COMMENT 'Foreign key referencing teacher',
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Account creation time',
    FOREIGN KEY (teacher_id) REFERENCES teachers (id) ON DELETE CASCADE
) COMMENT = 'To store teacher login and registration details';

-- Table to store student information
CREATE TABLE students
(
    id              INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary Key',
    first_name      VARCHAR(127) NOT NULL COMMENT 'Student first name',
    middle_name     VARCHAR(127) COMMENT 'Student middle name (optional)',
    last_name       VARCHAR(127) COMMENT 'Student last name (optional)',
    age             INT          NOT NULL COMMENT 'Student age',
    phone1          VARCHAR(127) NOT NULL UNIQUE COMMENT 'Student primary phone number',
    phone2          VARCHAR(127) UNIQUE COMMENT 'Student secondary phone number (optional)',
    email           VARCHAR(127) NOT NULL UNIQUE COMMENT 'Student email',
    guardian_phone1 VARCHAR(127) NOT NULL COMMENT 'Guardian primary phone number',
    guardian_phone2 VARCHAR(127) COMMENT 'Guardian secondary phone number (optional)',
    guardian_email  VARCHAR(127) NOT NULL UNIQUE COMMENT 'Guardian email',
    class_id        INT COMMENT 'Foreign key referencing classes',
    FOREIGN KEY (class_id) REFERENCES classes (id) ON DELETE SET NULL
) COMMENT = 'To store student specific information';

-- Table to store class information
CREATE TABLE classes
(
    id             INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
    class_name     VARCHAR(127) NOT NULL UNIQUE COMMENT 'Name of class available for students',
    no_of_students INT          NOT NULL DEFAULT 0 COMMENT 'Number of students in the class',
    teacher_id     INT          COMMENT 'Foreign key referencing teachers',
    FOREIGN KEY (teacher_id) REFERENCES teachers (id) ON DELETE SET NULL
) COMMENT = 'To store class specific information';

-- Table to store subject information
CREATE TABLE subjects
(
    id           INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
    subject_name VARCHAR(127) NOT NULL UNIQUE COMMENT 'Name of the subject'
) COMMENT = 'To store subject specific information';

-- Junction table to assign teachers to subjects and classes
CREATE TABLE teacher_subject_class
(
    id         INT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
    teacher_id INT NOT NULL COMMENT 'Foreign key referencing teachers',
    subject_id INT NOT NULL COMMENT 'Foreign key referencing subjects',
    class_id   INT NOT NULL COMMENT 'Foreign key referencing classes',
    FOREIGN KEY (teacher_id) REFERENCES teachers (id) ON DELETE CASCADE,
    FOREIGN KEY (subject_id) REFERENCES subjects (id) ON DELETE CASCADE,
    FOREIGN KEY (class_id) REFERENCES classes (id) ON DELETE CASCADE,
    UNIQUE (teacher_id, subject_id, class_id)
) COMMENT = 'Assigns teachers to subjects and classes';
