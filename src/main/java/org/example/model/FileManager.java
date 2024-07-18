package org.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.PublicInstances;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileManager {
    private Db db;

    public FileManager(Db db) {
        this.db = db;
    }

    public void exportStudentsToJson() {
        List<Student> students = PublicInstances.studentRepo.getAllStudents();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(students);

        try (FileWriter writer = new FileWriter("./files/export.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importStudentsFromJson() {
        db.clearAllTables();
        String filePath = "./files/import.json"; // Specify the path to your JSON file
        JSONParser parser = new JSONParser();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            Object obj = parser.parse(content);
            JSONArray studentsArray = (JSONArray) obj;

            for (Object o : studentsArray) {
                JSONObject student = (JSONObject) o;
                long id = (long) student.get("id");
                String firstname = (String) student.get("firstName");
                String lastname = (String) student.get("lastName");
                long age = (long) student.get("age"); 
                String grade = (String) student.get("grade");
                JSONArray grades = (JSONArray) student.get("grades");

                PublicInstances.studentRepo.addStudent(firstname, lastname, (int) age, grade);

                for (Object g : grades) {
                    int gradeValue = ((Long) g).intValue();
                    // Assuming addGrade method exists and inserts grade into the grades table
                    PublicInstances.gradesRepo.addGrade((int) id, gradeValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
