package org.example.view;

import org.example.model.StudentRepo;

import java.util.Scanner;

public class StatMenu {
    public static void menu(Scanner scanner){

        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.println("1 : Show average grades of the school");
        System.out.println("2 : Search average grades students info");
        System.out.println("3 : Average age of the school");
        System.out.println("4 : Go to the main menu");

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
                    //BinaryConverter.ConverterToBinary(scanner);
                    break;

                case "2":
                    AverageStudentsInfo.menu(scanner);
                    break;

                case "3":
                    //OctalConverter.ConverterToOctal(scanner);
                    break;



                case "4":
                    System.out.println("-----------------------");
                    Menu.menu(scanner,null,null,null); //change null with a getter for each element
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
