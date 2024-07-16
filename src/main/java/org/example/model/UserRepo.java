package org.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepo {
    private Db db;

    public UserRepo(Db db) {
        this.db = db;
    }

    public boolean isValidUser(String username, String password) {
        boolean userExists = false;
        ResultSet rs = null;
        try {
            String query = "SELECT COUNT(*) AS count FROM user WHERE username = ? AND password = ?";
            String[] params = {username, password};
            rs = db.query(query, params);
            if (rs.next() && rs.getInt("count") > 0) {
                userExists = true;
            }
        } catch (SQLException e) {
            System.err.println("Error processing the result set: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close the ResultSet: " + e.getMessage());
                }
            }
        }
        return userExists;
    }
}