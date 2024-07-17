package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.model.*;
import org.example.view.*;

// import com.oracle.svm.core.option.APIOption.List;
import java.util.List;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws Exception {
        Db db = new Db();
        UserRepo userRepo = new UserRepo(db);
        GradesRepo gradesRepo = new GradesRepo(db);
        StudentRepo studentRepo = new StudentRepo(db, gradesRepo);
        FileManager fileManager = new FileManager(studentRepo, db);

        Scanner scanner = new Scanner(System.in);
        LoginMenu.menu(scanner, userRepo);
        Menu.menu(scanner, gradesRepo, studentRepo,fileManager);
        db.endConnection();
        scanner.close();
    }
}
