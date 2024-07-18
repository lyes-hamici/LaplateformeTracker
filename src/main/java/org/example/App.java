package org.example;

import org.example.model.*;
import org.example.view.*;

// import com.oracle.svm.core.option.APIOption.List;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws Exception {
        /*
        Db db = new Db();
        PublicInstances.userRepo = new UserRepo(db);
        PublicInstances.gradesRepo = new GradesRepo(db);
        PublicInstances.studentRepo = new StudentRepo(db);
        PublicInstances.fileManager = new FileManager(db);
         */


        Scanner scanner = new Scanner(System.in);
        LoginMenu.menu(scanner);
        Menu.menu(scanner);
        PublicInstances.db.endConnection();
        scanner.close();
    }
}
