package org.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradesRepo {
    private Db db;
    public GradesRepo (Db db) {
        this.db = db;
    }
    public List<Integer> getGradesForStudent(int studentId) {
        List<Integer> grades = new ArrayList<>();
        String query = "SELECT value FROM grades WHERE student_id = ?";
        String[] params = {String.valueOf(studentId).trim()};
        ResultSet rs = db.query(query,params);
        try {
            while (rs.next()) {
                int value = rs.getInt("value");
                grades.add(value);
            }
        } catch (SQLException e) {
            System.err.println("Error processing the grades result set: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close the ResultSet: " + e.getMessage());
                }
            }
        }
        return grades;
    }

    public void addGrade(int studentId, int value) {
        String query = "INSERT INTO grades (student_id, value) VALUES (?, ?)";
        db.execute(query, studentId, value);
    }

    public double schoolAverage() {
        String query = "SELECT AVG(value) FROM grades";
        ResultSet rs = db.query(query, null);
        double average = 0;
        try {
            if (rs.next()) {
                average = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.err.println("Error processing the school average result set: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("Failed to close the ResultSet: " + e.getMessage());
                }
            }
        }
        return average;
    }

    public double studentAverage(int studentId) {
            String query = "SELECT AVG(value) FROM grades WHERE student_id = ?";
            String[] params = {String.valueOf(studentId).trim()};
            ResultSet rs = db.query(query, params);
            double average = 0;
            try {
                if (rs.next()) {
                    average = rs.getDouble(1);
                }
            } catch (SQLException e) {
                System.err.println("Error processing the student average result set: " + e.getMessage());
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        System.err.println("Failed to close the ResultSet: " + e.getMessage());
                    }
                }
            }
            return average;
    }
}
