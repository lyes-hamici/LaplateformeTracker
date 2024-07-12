package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306/mon_ecole";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

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

    public ResultSet query(String sql) {
        ResultSet resultSet = null;
        try {
            Statement statement = this.conn.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Query execution failed: " + e.getMessage());
        }
        return resultSet;
    }

    public int execute(String sql) {
        int result = 0;
        try {
            Statement statement = this.conn.createStatement();
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Execution failed: " + e.getMessage());
        }
        return result;
    }
}
