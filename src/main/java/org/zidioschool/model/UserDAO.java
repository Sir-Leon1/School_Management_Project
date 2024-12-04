package org.zidioschool.model;

import org.zidioschool.model.modelClasses.User;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        this.connection = Model.getInstance().getDatabaseDriver().connect();
    }

    public User getUserByUsername(String username) {
        User user = null;
        String query = "SELECT * FROM users WHERE email = ?";

        try (
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password_hash"));
                user.setTeacherId(resultSet.getInt("teacher_id"));
                user.setCreatedAt(resultSet.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void addUser(User user) {
        String query = "INSERT INTO users (email, password_hash, teacher_id) VALUES (?, ?, ?)";

        try (
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getTeacherId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}