package org.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepo {
    public Db db;

    public UserRepo(Db db) {
        this.db = db;
    }

    public boolean isValidUser(String username, String password) {
        boolean userExists = false;
        ResultSet rs = null;
        try {
            String query = "SELECT COUNT(*) AS count FROM user WHERE username = ? AND password = ?";
            PreparedStatement stmt = db.conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
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