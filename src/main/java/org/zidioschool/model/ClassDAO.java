package org.zidioschool.model;

import org.zidioschool.model.modelClasses.Clss;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    private Connection connection;

    public ClassDAO() {
        this.connection = Model.getInstance().getDatabaseDriver().connect();
    }

    public List<Clss> getAllClasses() {
        List<Clss> classes = new ArrayList<>();
        String query = "SELECT * FROM classes";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Clss clss = new Clss();
                clss.setId(resultSet.getInt("id"));
                clss.setClassName(resultSet.getString("class_name"));
                classes.add(clss);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classes;
    }

    public Clss getClassById(int id) {
        Clss clss = null;
        String query = "SELECT * FROM classes WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    clss = new Clss();
                    clss.setId(resultSet.getInt("id"));
                    clss.setClassName(resultSet.getString("class_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clss;
    }

    public int getClassIdByName(String className) {
        String query = "SELECT id FROM classes WHERE class_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, className);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean addClass(Clss clss) {
        String query = "INSERT INTO classes (name) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, clss.getClassName());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateClass(Clss clss) {
        String query = "UPDATE classes SET name = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, clss.getClassName());
            statement.setInt(2, clss.getId());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteClass(int id) {
        String query = "DELETE FROM classes WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}