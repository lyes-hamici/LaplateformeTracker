package org.example.view;

import org.example.model.FileManager;
import org.example.model.GradesRepo;
import org.example.model.StudentRepo;
import org.example.model.UserRepo;

import java.util.Scanner;

public class Menu {
    public static void menu(Scanner scanner, GradesRepo gradesRepo, StudentRepo studentRepo, FileManager fileManager){
        String text = "La Plateforme_ Tracker";

        int textLength = text.length();
        int lineWidth = textLength + 4;

        // Print the top line of asterisks
        for (int i = 0; i < lineWidth; i++) {
            System.out.print("*");
        }
        System.out.println(); // Line break

        // Print the line of text surrounded by asterisks
        System.out.println("* " + text + " *");

        // Print the bottom line of asterisks
        for (int i = 0; i < lineWidth; i++) {
            System.out.print("*");
        }
        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.println("1 : Add a student");
        System.out.println("2 : Remove a student");
        System.out.println("3 : Search for a student");
        System.out.println("4 : Display all students");
        System.out.println("5 : Import/Export data");
        System.out.println("6 : Edit a student");
        System.out.println("7 : Quit");

        System.out.println(); // Line break

        menuChoice(scanner, gradesRepo, studentRepo,fileManager);

    }

    public static void menuChoice(Scanner scanner, GradesRepo gradesRepo, StudentRepo studentRepo, FileManager fileManager) {
        try {
            System.out.print("Your choice: ");
            String value = scanner.nextLine();

            switch (value) {
                case "1":
                    AddMenu.menu(scanner,studentRepo);
                    break;

                case "2":
                    DeleteMenu.menu(scanner, studentRepo);
                    break;

                case "3":
                    //SearchMenu.menu(scanner, studentRepo);
                    break;

                case "4":
                    ShowMenu.menu(scanner, studentRepo);
                    break;

                case "5":
                    //ImportExportMenu.menu(scanner);
                    break;

                case "6":
                    EditMenu.menu(scanner, studentRepo);
                    break;

                case "7":
                    System.out.println("-----------------------");
                    System.out.println("Looking forward to seeing you again.");
                    System.out.println("-----------------------");
                    break;
                default:
                    System.out.println("Invalid choice");
                    //menuChoice(scanner);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
