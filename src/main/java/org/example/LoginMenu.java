package org.example;


import java.util.Scanner;

public class LoginMenu {
    public static void menu() {

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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username : ");
        username = scanner.nextLine();

        System.out.println("-------------------");
        System.out.print("Password : ");
        passwd = scanner.nextLine();
    }
}