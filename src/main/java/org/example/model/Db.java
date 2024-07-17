package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
    /* CLass that allow the connection with the database and execute querys */
    private static final String URL = "jdbc:mysql://localhost:3306/mon_ecole";
    private static final String USER = "root";
    private static final String PASSWORD = "root!";

    public Connection conn;

    public Db() {
        this.conn = connect();
    }

    public static Connection connect() {
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established successfully!");

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Failed to establish connection: " + e.getMessage());
        }

        return connection;
    }

    public void endConnection() {
        if (this.conn != null) {
            try {
                this.conn.close();
                System.out.println("Connection closed successfully!");
            } catch (SQLException e) {
                System.err.println("Failed to close the connection: " + e.getMessage());
            }
        }
    }

    public ResultSet query(String sql, String[] params) {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = this.conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setString(i + 1, params[i]);
                }
            }
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.err.println("Query execution failed: " + e.getMessage());
        }
        return resultSet;
    }

    public int execute(String sql, Object... params) {
        int result = 0;
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Execution failed: " + e.getMessage());
        }
        return result;
    }

    public void clearAllTables() {
        try {
            Statement statement = this.conn.createStatement();
            statement.executeUpdate("DELETE FROM student");
            statement.executeUpdate("DELETE FROM grades");
        } catch (SQLException e) {
            System.err.println("Failed to clear tables: " + e.getMessage());
        }
    }
}
