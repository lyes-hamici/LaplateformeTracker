package org.example.view;

import java.util.Scanner;

public class AddMenu {
    public static void menu(Scanner scanner){
        String Name , Firstname , Age ;
        int Grade;
        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.print("Name : ");

        Name = scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("Firstname : ");
        Firstname = scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("Age : ");
        Age = scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("Grade : ");
        Grade = scanner.nextInt();



        System.out.println(); // Line break


        //call the function to add the new student

        scanner.close();
    }


}
