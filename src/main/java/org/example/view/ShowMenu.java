package org.example.view;

import org.example.model.StudentRepo;

import java.util.Scanner;

public class ShowMenu {
    public static void menu(Scanner scanner, StudentRepo studentRepo){

        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.println("1 : ASC");
        System.out.println("2 : DSC");
        System.out.println("3 : Quit");


        System.out.println(); // Line break


        menuChoice(scanner, studentRepo);

        scanner.close();
    }

    public static void menuChoice(Scanner scanner, StudentRepo studentRepo) {
        try {
            System.out.print("Your choice: ");
            String value = scanner.nextLine();

            switch (value) {
                case "1":
                    ShowMenuAsc.menu(scanner, studentRepo);
                    break;

                case "2":
                    ShowMenuDsc.menu(scanner, studentRepo);
                    break;


                case "3":
                    System.out.println("-----------------------");
                    System.out.println("Looking forward to seeing you again.");
                    System.out.println("-----------------------");
                    break;
                default:
                    System.out.println("Invalid choice");
                    menuChoice(scanner, studentRepo);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
