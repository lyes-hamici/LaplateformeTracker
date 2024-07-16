package org.example.view;

import java.util.Scanner;

public class ImportExportMenu {
    public static void menu(Scanner scanner){

        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.println("1 : Import");
        System.out.println("2 : Export");
        System.out.println("3 : Quit");


        System.out.println(); // Line break


        menuChoice(scanner);

        scanner.close();
    }

    public static void menuChoice(Scanner scanner) {
        try {
            System.out.print("Your choice: ");
            String value = scanner.nextLine();

            switch (value) {
                case "1":
                    //call import function
                    break;

                case "2":
                    //call export function
                    break;


                case "3":
                    System.out.println("-----------------------");
                    System.out.println("Looking forward to seeing you again.");
                    System.out.println("-----------------------");
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
