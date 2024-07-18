package org.example.model;

import org.example.PublicInstances;

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
    public StudentRepo(Db db)
    {
        this.db = db;
    }

    //---------------------------- Get Students -------------------------//
    public List<Student> getResult(String query, String[] params )
    {
        List<Student> students = new ArrayList<>();
        ResultSet rs = db.query(query, params);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");

                // Fetch grades for the student
                List<Integer> grades = PublicInstances.gradesRepo.getGradesForStudent(id);

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

    public int getSchoolAgeAverage() {
        String query = "SELECT AVG(age) FROM student";
        ResultSet rs = db.query(query, null);
        int averageAge = 0;
        try {
            if (rs.next()) {
                averageAge = (int) Math.round(rs.getDouble(1));
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
        return averageAge;
    }

    public List<Student> getAllStudents() {
        String query = "SELECT * FROM student";
        return getResult(query, null);
    }

    public List<Student> getAllStudentsDESC() {
        String query = "SELECT * FROM student ORDER BY id DESC";
        return getResult(query, null);
    }
//----------------------------- SORTING ------------------------------------//
    //--------------------------- ASC -----------------------//
    public List<Student> ASCFirstName() {
        String query = "SELECT * FROM student ORDER BY first_name ASC";
        return getResult(query, null);
    }

    public List<Student> ASCLastName() {
        String query = "SELECT * FROM student ORDER BY last_name ASC";
        return getResult(query, null);
    }

    public List<Student> ASCAge() {
        String query = "SELECT * FROM student ORDER BY age ASC";
        return getResult(query, null);
    }

    public List<Student> ASCGrade() {
        String query = "SELECT * FROM student ORDER BY grade ASC";
        return getResult(query, null);
    }

    //--------------------------- DSC -----------------------//
    public List<Student> DSCFirstName() {
        String query = "SELECT * FROM student ORDER BY first_name DESC";
        return getResult(query, null);
    }

    public List<Student> DSCLastName() {
        String query = "SELECT * FROM student ORDER BY last_name DESC";
        return getResult(query, null);
    }

    public List<Student> DSCAge() {
        String query = "SELECT * FROM student ORDER BY age DESC";
        return getResult(query, null);
    }

    public List<Student> DSCGrade() {
        String query = "SELECT * FROM student ORDER BY grade DESC";
        return getResult(query, null);
    }

//-------------------------------------------SEARCH-----------------------------//

    public List<Student> searchStudentAge(int age) {
        String query = "SELECT * FROM student WHERE age = ?";
        String[] params = {String.valueOf(age)};
        return getResult(query, params);
    }

    public List<Student> searchStudentGrade(String grade) {
        String query = "SELECT * FROM student WHERE grade = ?";
        String[] params = {grade};
        return getResult(query, params);
    }

    public List<Student> searchStudentFirstName(String firstName) {
        String query = "SELECT * FROM student WHERE first_name = ?";
        String[] params = {firstName};
        return getResult(query, params);
    }

    public List<Student> searchStudentLastName(String lastName) {
        String query = "SELECT * FROM student WHERE last_name = ?";
        String[] params = {lastName};
        return getResult(query, params);
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
