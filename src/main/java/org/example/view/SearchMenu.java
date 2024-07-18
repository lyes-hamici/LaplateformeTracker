package org.example.view;

import com.oracle.svm.core.posix.headers.Stat;

import org.example.model.FileManager;
import org.example.model.GradesRepo;
import org.example.model.StudentRepo;

import java.util.Scanner;

public class SearchMenu {
    public static void menu(Scanner scanner){

        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.println("1 : Search Students by firstname");
        System.out.println("2 : Search Students by lastname");
        System.out.println("3 : Search Students by age");
        System.out.println("4 : Search Students by grade");
        System.out.println("5 : Go back");

        System.out.println(); // Line break


        menuChoice(scanner);
    }

    public static void menuChoice(Scanner scanner) {
        try {
            System.out.print("Your choice: ");
            String value = scanner.nextLine();

            switch (value) {
                case "1":
                    String firstname;
                    System.out.print("Enter the firstname");
                    //OctalConverter.ConverterToOctal(scanner);
                    break;

                case "2":
                    String lastname;
                    System.out.print("Enter the lastname");
                    //AsciiConverter.scanText(scanner);
                    break;

                case "3":
                    int age;
                    System.out.print("Enter the age of the student");
                    //TextDecipher.textDecipher(scanner);
                    break;

                case "4":
                    String grade;
                    System.out.print("Enter the grade of the student");
                    //TextDecipher.textDecipher(scanner);
                    break;

                case "5":
                    System.out.println("-----------------------");
                    Menu.menu(scanner); //change null with a getter for each element
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
