package org.example.view;

import com.oracle.svm.core.posix.headers.Stat;
import org.example.App;
import org.example.model.FileManager;
import org.example.model.GradesRepo;
import org.example.model.StudentRepo;

import java.util.Scanner;

public class SearchMenu {
    public static void menu(Scanner scanner, StudentRepo studentRepo){

        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.println("1 : Show all students");
        System.out.println("2 : Search Students by stats");
        System.out.println("3 : Search Students by Firstname");
        System.out.println("4 : Search Students by Name");
        System.out.println("5 : Search Students by Age");
        System.out.println("6 : Search Students by Grade");
        System.out.println("7 : Go back");

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
                    StatMenu.menu(scanner);
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
                    Menu.menu(scanner,null,null,null); //change null with a getter for each element
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
