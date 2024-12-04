//package org.zidioschool.model;
//
//import org.zidioschool.model.modelClasses.Teacher;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TeacherDAO {
//    private Connection connection;
//
//    public TeacherDAO() {
//        this.connection = Model.getInstance().getDatabaseDriver().connect();
//    }
//
//    public List<Teacher> getAllTeachers() {
//        List<Teacher> teachers = new ArrayList<>();
//        String query = "SELECT * FROM teachers";
//
//        try (PreparedStatement statement = connection.prepareStatement(query);
//             ResultSet resultSet = statement.executeQuery()) {
//
//            while (resultSet.next()) {
//                Teacher teacher = new Teacher();
//                teacher.setId(resultSet.getInt("id"));
//                teacher.setFirstName(resultSet.getString("first_name"));
//                teacher.setLastName(resultSet.getString("last_name"));
//                teacher.setEmail(resultSet.getString("email"));
//                teacher.setPhone(resultSet.getString("phone"));
//                teacher.setDepartment(resultSet.getString("department"));
//                teachers.add(teacher);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return teachers;
//    }
//
//    public Teacher getTeacherById(int id) {
//        Teacher teacher = null;
//        String query = "SELECT * FROM teachers WHERE id = ?";
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    teacher = new Teacher();
//                    teacher.setId(resultSet.getInt("id"));
//                    teacher.setFirstName(resultSet.getString("first_name"));
//                    teacher.setLastName(resultSet.getString("last_name"));
//                    teacher.setEmail(resultSet.getString("email"));
//                    teacher.setPhone(resultSet.getString("phone"));
//                    teacher.setDepartment(resultSet.getString("department"));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return teacher;
//    }
//
//    public boolean addTeacher(Teacher teacher) {
//        String query = "INSERT INTO teachers (first_name, last_name, email, phone, department) VALUES (?, ?, ?, ?, ?)";
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, teacher.getFirstName());
//            statement.setString(2, teacher.getLastName());
//            statement.setString(3, teacher.getEmail());
//            statement.setString(4, teacher.getPhone());
//            statement.setString(5, teacher.getDepartment());
//            return statement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
//    public boolean updateTeacher(Teacher teacher) {
//        String query = "UPDATE teachers SET first_name = ?, last_name = ?, email = ?, phone = ?, department = ? WHERE id = ?";
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, teacher.getFirstName());
//            statement.setString(2, teacher.getLastName());
//            statement.setString(3, teacher.getEmail());
//            statement.setString(4, teacher.getPhone());
//            statement.setString(5, teacher.getDepartment());
//            statement.setInt(6, teacher.getId());
//            return statement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
//    public boolean deleteTeacher(int id) {
//        String query = "DELETE FROM teachers WHERE id = ?";
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setInt(1, id);
//            return statement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//}