package org.example.view;

import org.example.App;
import org.example.model.StudentRepo;

import java.util.Scanner;

public class ShowMenuDsc {
    public static void menu(Scanner scanner, StudentRepo studentRepo){

        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.println("1 : Show all students");
        System.out.println("2 : Sort Students by ID");
        System.out.println("3 : Sort Students by Firstname");
        System.out.println("4 : Sort Students by Name");
        System.out.println("5 : Sort Students by Age");
        System.out.println("6 : Sort Students by Grade");
        System.out.println("7 : Go to the main menu");

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
                    //BinaryConverter.ConverterToBinary(scanner);
                    break;

                case "2":
                    //HexConverter.scanText(scanner);
                    break;

                case "3":
                    //OctalConverter.ConverterToOctal(scanner);
                    break;

                case "4":
                    //AsciiConverter.scanText(scanner);
                    break;

                case "5":
                    //TextDecipher.textDecipher(scanner);
                    break;

                case "6":
                    //TextDecipher.textDecipher(scanner);
                    break;

                case "7":
                    System.out.println("-----------------------");
                    Menu.menu(null,null,null,null);
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
