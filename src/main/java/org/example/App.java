package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.model.Db;
import org.example.model.UserRepo;
import org.example.model.FileManager;


public class App {

    public static void main(String[] args) throws Exception {
        Db db = new Db();
        UserRepo userRepo = new UserRepo(db);
        FileManager fileManager = new FileManager(db);

        // Testing purposes
        boolean isValidUser = userRepo.isValidUser("root", "root");
        if (isValidUser) {
            System.out.println("User is valid");
        } else {
            System.out.println("User is not valid");
        }

        fileManager.exportStudentsToJson();

        // End testing purposes

        // Menu.menu();
        db.endConnection();
    }
}
