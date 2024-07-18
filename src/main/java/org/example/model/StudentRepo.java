package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRepo {
    private Db db;
    private GradesRepo gradesRepo;
    public StudentRepo(Db db, GradesRepo gradesRepo)
    {
        this.db = db;
        this.gradesRepo = gradesRepo;
    }

    //---------------------------- Get Students -------------------------//
    public List<Student> getResult(String query)
    {
        List<Student> students = new ArrayList<>();
        ResultSet rs = db.query(query, null);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");

                // Fetch grades for the student
                List<Integer> grades = this.gradesRepo.getGradesForStudent(id);

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

    //--------------------------- ASC -----------------------//
    public List<Student> ASCFirstName() {
        String query = "SELECT * FROM student ORDER BY first_name ASC";
        return getResult(query);
    }

    public List<Student> ASCLastName() {
        String query = "SELECT * FROM student ORDER BY last_name ASC";
        return getResult(query);
    }

    public List<Student> ASCAge() {
        String query = "SELECT * FROM student ORDER BY age ASC";
        return getResult(query);
    }

    public List<Student> ASCGrade() {
        String query = "SELECT * FROM student ORDER BY grade ASC";
        return getResult(query);
    }

    //--------------------------- DSC -----------------------//
    public List<Student> DSCFirstName() {
        String query = "SELECT * FROM student ORDER BY first_name DSC";
        return getResult(query);
    }

    public List<Student> DSCLastName() {
        String query = "SELECT * FROM student ORDER BY last_name DSC";
        return getResult(query);
    }

    public List<Student> DSCAge() {
        String query = "SELECT * FROM student ORDER BY age DSC";
        return getResult(query);
    }

    public List<Student> DSCGrade() {
        String query = "SELECT * FROM student ORDER BY grade DSC";
        return getResult(query);
    }



    //--------------------------- ADD -----------------------//
    public void addStudent(String firstname, String lastname, int age, String grade) {
        String query = "INSERT INTO student (first_name, last_name, age, grade) VALUES (?, ?, ?, ?)";
        db.execute(query, firstname, lastname, age, grade);
    }

    //--------------------------- UPDATE -----------------------//
    public void updateStudent(int id, String firstname, String lastname, int age, String grade) {
        String query = "UPDATE student SET first_name = ?, last_name = ?, age = ?, grade = ? WHERE id = ?";
        db.execute(query, firstname, lastname, age, grade, id);
    }


    //--------------------------- DELETE -----------------------//
    public void deleteStudent(int id) {
        String query = "DELETE FROM student WHERE id = ?";
        db.execute(query, id);
    }

}
