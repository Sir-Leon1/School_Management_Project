package org.zidioschool.model;

import org.zidioschool.model.modelClasses.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;

    public StudentDAO() {
        this.connection = Model.getInstance().getDatabaseDriver().connect();
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setMiddleName(resultSet.getString("middle_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setAge(resultSet.getInt("age"));
                student.setPhone1(resultSet.getString("phone1"));
                student.setPhone2(resultSet.getString("phone2"));
                student.setEmail(resultSet.getString("email"));
                student.setGuardianPhone1(resultSet.getString("guardian_phone1"));
                student.setGuardianPhone2(resultSet.getString("guardian_phone2"));
                student.setGuardianEmail(resultSet.getString("guardian_email"));
                student.setIdNumber(resultSet.getString("id_number"));
                student.setClassId(resultSet.getInt("class_id"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<Student> getStudentsByClass(int classId) {
    List<Student> students = new ArrayList<>();
    String query = "SELECT * FROM students WHERE class_id = ?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, classId);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setMiddleName(resultSet.getString("middle_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setAge(resultSet.getInt("age"));
                student.setPhone1(resultSet.getString("phone1"));
                student.setPhone2(resultSet.getString("phone2"));
                student.setEmail(resultSet.getString("email"));
                student.setGuardianPhone1(resultSet.getString("guardian_phone1"));
                student.setGuardianPhone2(resultSet.getString("guardian_phone2"));
                student.setGuardianEmail(resultSet.getString("guardian_email"));
                student.setIdNumber(resultSet.getString("id_number"));
                student.setClassId(resultSet.getInt("class_id"));
                students.add(student);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return students;
}

    public Student getStudentById(int id) {
        Student student = null;
        String query = "SELECT * FROM students WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setFirstName(resultSet.getString("first_name"));
                    student.setMiddleName(resultSet.getString("middle_name"));
                    student.setLastName(resultSet.getString("last_name"));
                    student.setAge(resultSet.getInt("age"));
                    student.setPhone1(resultSet.getString("phone1"));
                    student.setPhone2(resultSet.getString("phone2"));
                    student.setEmail(resultSet.getString("email"));
                    student.setGuardianPhone1(resultSet.getString("guardian_phone1"));
                    student.setGuardianPhone2(resultSet.getString("guardian_phone2"));
                    student.setGuardianEmail(resultSet.getString("guardian_email"));
                    student.setClassId(resultSet.getInt("class_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public boolean addStudent(Student student) {
        String query = "INSERT INTO students (first_name, middle_name, last_name, age, phone1, phone2, email, guardian_phone1, guardian_phone2, guardian_email, class_id, id_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getMiddleName());
            statement.setString(3, student.getLastName());
            statement.setInt(4, student.getAge());
            statement.setString(5, student.getPhone1());
            statement.setString(6, student.getPhone2());
            statement.setString(7, student.getEmail());
            statement.setString(8, student.getGuardianPhone1());
            statement.setString(9, student.getGuardianPhone2());
            statement.setString(10, student.getGuardianEmail());
            statement.setInt(11, student.getClassId());
            statement.setString(12, student.getIdNumber());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateStudent(Student student) {
        String query = "UPDATE students SET first_name = ?, middle_name = ?, last_name = ?, age = ?, phone1 = ?, phone2 = ?, email = ?, guardian_phone1 = ?, guardian_phone2 = ?, guardian_email = ?, class_id = ?, id_number = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getMiddleName());
            statement.setString(3, student.getLastName());
            statement.setInt(4, student.getAge());
            statement.setString(5, student.getPhone1());
            statement.setString(6, student.getPhone2());
            statement.setString(7, student.getEmail());
            statement.setString(8, student.getGuardianPhone1());
            statement.setString(9, student.getGuardianPhone2());
            statement.setString(10, student.getGuardianEmail());
            statement.setInt(11, student.getClassId());
            statement.setString(12, student.getIdNumber());
            statement.setInt(13, student.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}