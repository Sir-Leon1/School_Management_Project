package org.zidioschool.model;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDriver {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String JDBC_URL = dotenv.get("DB_URL");
    private static final String USERNAME = dotenv.get("DB_USERNAME");
    private static final String PASSWORD = dotenv.get("DB_PASSWORD");
    private static Connection connection;

    public DatabaseDriver() {
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Database connection established");
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public Connection connect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error occured in connect method: " +e.getMessage());
        }

        return connect;
    }

    public void closeConnection() {
        try {
            if (connection != null) connection.close();
            System.out.println("Database connection closed");
        } catch (SQLException e) {
            System.out.println("Error occured in closing connection: " +e);
            e.printStackTrace();
        }
    }
}
