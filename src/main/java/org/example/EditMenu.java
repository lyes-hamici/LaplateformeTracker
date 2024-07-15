package org.example;

import java.util.Scanner;

public class EditMenu {
    public static void menu(Scanner scanner){
        String Name , Firstname , Age ;
        int Grade , id;
        System.out.println(); // Line break

        System.out.println("----------------------");
        System.out.print("ID : ");
        id = scanner.nextInt();

        System.out.println("----------------------");
        System.out.print("New Name : ");

        Name = scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("New Firstname : ");
        Firstname = scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("New Age : ");
        Age = scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("New Grade : ");
        Grade = scanner.nextInt();



        System.out.println(); // Line break


        //call the function to Edit student

        scanner.close();
    }
}
