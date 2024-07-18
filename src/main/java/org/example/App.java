package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.model.*;
import org.example.view.*;

// import com.oracle.svm.core.option.APIOption.List;
import java.util.List;
import java.util.Scanner;


public class App {
    public static UserRepo userRepo;
    public static GradesRepo gradesRepo;
    public static StudentRepo studentRepo;
    public static FileManager fileManager;

    public static void main(String[] args) throws Exception {
        Db db = new Db();
        userRepo = new UserRepo(db);
        gradesRepo = new GradesRepo(db);
        studentRepo = new StudentRepo(db, gradesRepo);
        fileManager = new FileManager(studentRepo, db);

        Scanner scanner = new Scanner(System.in);
        LoginMenu.menu(scanner, userRepo);
        Menu.menu(scanner);
        db.endConnection();
        scanner.close();
    }
}
