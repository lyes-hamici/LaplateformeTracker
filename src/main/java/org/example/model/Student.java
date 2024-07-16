package org.example.model;
import java.util.List;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String grade;
    private List<Integer> grades;

    public Student(int id, String firstName, String lastName, int age, String grade, List<Integer> grades) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.grade = grade;
        this.grades = grades;
    }
    @Override
    public String toString() {
        return  firstName + " " + lastName + " {" +
                "\n id=" + id +
                ",\n firstName='" + firstName + '\'' +
                ",\n lastName='" + lastName + '\'' +
                ",\n age=" + age +
                ",\n grade='" + grade + '\'' +
                ",\n grades=" + grades +
                "\n}\n";
    }

    // ----------------- Getters and Setters -------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }
}

