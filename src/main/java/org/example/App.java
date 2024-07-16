package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.model.*;
import org.example.view.*;

// import com.oracle.svm.core.option.APIOption.List;
import java.util.List;


public class App {

    public static void main(String[] args) throws Exception {
        Db db = new Db();
        UserRepo userRepo = new UserRepo(db);
        GradesRepo gradesRepo = new GradesRepo(db);
        StudentRepo studentRepo = new StudentRepo(db, gradesRepo);
        FileManager fileManager = new FileManager(studentRepo);


        // Testing purposes

        boolean isValidUser = userRepo.isValidUser("root", "root");
        if (isValidUser) {
            System.out.println("User is valid");
        } else {
            System.out.println("User is not valid");
        }
        
        List<Student> students = studentRepo.getAllStudents();
        for (Student student : students ) {
            System.out.println(student);
        }

        fileManager.exportStudentsToJson();

        // End testing purposes

        Menu.menu();
        db.endConnection();
    }
}
