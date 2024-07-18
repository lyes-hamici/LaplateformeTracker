package org.example.view;

import org.example.PublicInstances;
import org.example.model.Student;
import org.example.model.StudentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowMenuDsc {
    public static void menu(Scanner scanner){

        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.println("1 : Show all students");
        System.out.println("3 : Sort Students by firstname");
        System.out.println("4 : Sort Students by lastname");
        System.out.println("5 : Sort Students by age");
        System.out.println("6 : Sort Students by grade");
        System.out.println("7 : Go to the main menu");

        System.out.println(); // Line break


        menuChoice(scanner);
    }

    public static void menuChoice(Scanner scanner) {
        List<Student> students = new ArrayList<>();
        try {
            System.out.print("Your choice: ");
            String value = scanner.nextLine();

            switch (value) {
                case "1":
                    students = PublicInstances.studentRepo.getAllStudentsDESC();
                    break;
                case "3":
                    students = PublicInstances.studentRepo.DSCFirstName();
                    break;

                case "4":
                    students = PublicInstances.studentRepo.DSCLastName();

                    break;

                case "5":
                    students = PublicInstances.studentRepo.DSCAge();

                    break;

                case "6":
                    students = PublicInstances.studentRepo.DSCGrade();
                    break;

                case "7":
                    System.out.println("-----------------------");
                    Menu.menu(scanner);
                    break;
                default:
                    System.out.println("Invalid choice");
                    menuChoice(scanner);
                    break;
            }
            for (Student student : students)
            {
                System.out.println(student);
            }
            Menu.menu(scanner);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
