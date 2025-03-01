package org.example.view;

import org.example.App;
import org.example.model.StudentRepo;

import java.util.Scanner;

public class ShowMenu {
    public static void menu(Scanner scanner){

        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.println("1 : ASC");
        System.out.println("2 : DSC");
        System.out.println("3 : Go back");


        System.out.println(); // Line break


        menuChoice(scanner);
    }

    public static void menuChoice(Scanner scanner) {
        try {
            System.out.print("Your choice: ");
            String value = scanner.nextLine();

            switch (value) {
                case "1":
                    ShowMenuAsc.menu(scanner);
                    break;

                case "2":
                    ShowMenuDsc.menu(scanner);
                    break;


                case "3":
                    System.out.println("-----------------------");
                    Menu.menu(scanner);
                    break;
                default:
                    System.out.println("Invalid choice");
                    menuChoice(scanner);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
