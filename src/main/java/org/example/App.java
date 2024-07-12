package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.model.Db;
import org.example.model.UserRepo;


public class App {

    public static void main(String[] args) throws Exception {
        Db db = new Db();
        UserRepo userRepo = new UserRepo(db);
        boolean isValid = userRepo.isValidUser("root", "root");
        System.out.println(isValid);
        db.endConnection();

        // Menu.menu();
    }
}
