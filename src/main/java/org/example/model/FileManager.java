package org.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private Db db;

    public FileManager(Db db) {
        this.db = db;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        ResultSet rs = db.query(query, null);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");

                // Fetch grades for the student
                List<Integer> grades = getGradesForStudent(id);

                students.add(new Student(id, firstName, lastName, age, grade, grades));
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
        return students;
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

    public void exportStudentsToJson() {
        List<Student> students = getAllStudents();

        // Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // String json = gson.toJson(students);

        // try (FileWriter writer = new FileWriter(filePath)) {
        //     writer.write(json);
        //     System.out.println("Students exported to JSON successfully.");
        // } catch (IOException e) {
        //     System.err.println("Error writing to file: " + e.getMessage());
        // }
    }
}
