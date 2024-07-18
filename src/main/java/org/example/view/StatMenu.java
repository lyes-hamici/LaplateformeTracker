package org.example.view;

import org.example.PublicInstances;

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
    }

    public static void menuChoice(Scanner scanner) {
        try {
            System.out.print("Your choice: ");
            String value = scanner.nextLine();

            switch (value) {
                case "1":
                    double gradesAverage = PublicInstances.gradesRepo.schoolAverage();
                    System.out.println("The grades average of the school is " + gradesAverage + " / 20");
                    break;

                case "2":
                    AverageStudentsInfo.menu(scanner);
                    break;

                case "3":
                    int ageAverage = PublicInstances.studentRepo.getSchoolAgeAverage();
                    System.out.println("The age average of the school is " + ageAverage + " years");
                    break;



                case "4":
                    System.out.println("-----------------------");
                    Menu.menu(scanner); //change null with a getter for each element
                    break;
                default:
                    System.out.println("Invalid choice");
                    menuChoice(scanner);
                    break;
            }
            Menu.menu(scanner);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
