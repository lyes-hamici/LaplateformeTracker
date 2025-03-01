package org.example.view;

import org.example.App;
import org.example.PublicInstances;
import org.example.model.StudentRepo;

import java.util.Scanner;

public class EditMenu {
    public static void menu(Scanner scanner){
        String lastname , firstname , grade ;
        int id, age;
        System.out.println(); // Line break

        System.out.println("----------------------");
        System.out.print("ID : ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("New lastname : ");

        lastname = scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("New firstname : ");
        firstname = scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("New age : ");
        age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("New grade : ");
        grade = scanner.nextLine();



        System.out.println(); // Line break

        PublicInstances.studentRepo.updateStudent(id,firstname,lastname, age, grade);
        System.out.println("Student edited successfully");
        Menu.menu(scanner);

    }
}
