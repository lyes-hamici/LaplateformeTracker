package org.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private StudentRepo studentRepo;
    private Db db;

    public FileManager(StudentRepo studentRepo, Db db) {
        this.studentRepo = studentRepo;
        this.db = db;
    }

    public void exportStudentsToJson() {
        List<Student> students = studentRepo.getAllStudents();
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
            // Step 1: Read JSON file into String
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Step 2: Parse JSON string to JSONArray
            Object obj = parser.parse(content);
            JSONArray studentsArray = (JSONArray) obj;

            // Step 3 & 4: Extract data and insert into database
            for (Object o : studentsArray) {
                JSONObject student = (JSONObject) o;
                String firstname = (String) student.get("firstName");
                String lastname = (String) student.get("lastName");
                long age = (long) student.get("age"); // JSON.simple treats numbers as longs
                String grade = (String) student.get("grade");
                // Assuming addStudent method exists and inserts data into the database
                this.studentRepo.addStudent(firstname, lastname, (int) age, grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
