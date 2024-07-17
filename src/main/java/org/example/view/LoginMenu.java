package org.example.view;


import org.example.model.UserRepo;

import java.util.Scanner;

public class LoginMenu {
    public static void menu(Scanner scanner, UserRepo userRepo) {
        boolean isValid = false;
        String passwd , username;

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
        System.out.println();

        while (!isValid)
        {
            System.out.print("Username : ");
            username = scanner.nextLine();

            System.out.println("-------------------");
            System.out.print("Password : ");
            passwd = scanner.nextLine();

            isValid = userRepo.isValidUser(username, passwd);
            System.out.println((!isValid) ? "Invalid username or password. Please restart" : "Bienvenue");
        }

    }
}