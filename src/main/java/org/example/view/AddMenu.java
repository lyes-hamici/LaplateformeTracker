package org.example.view;
import org.example.PublicInstances;
import java.util.Scanner;

public class AddMenu {
    public static void menu(Scanner scanner){
        String lastname,firstname , grade ;
        int age;
        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.print("Firstname : ");

        firstname = scanner.nextLine();
        firstname = firstname.trim();

        System.out.println("----------------------");
        System.out.print("Lastname : ");

        lastname = scanner.nextLine();
        lastname = lastname.trim();

        System.out.println("----------------------");
        System.out.print("Age : ");
        age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("----------------------");
        System.out.print("Grade : ");
        grade = scanner.nextLine();
        grade = grade.trim();



        System.out.println(); // Line break


        PublicInstances.studentRepo.addStudent(firstname, lastname, age, grade);
        System.out.println("Etudiant ajouté avec succés");

        Menu.menu(scanner);
    }
}
