package org.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private StudentRepo studentRepo;

    public FileManager(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
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


    }


}
