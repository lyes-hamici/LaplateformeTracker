package org.example.view;

import com.oracle.svm.core.posix.headers.Stat;

import org.example.PublicInstances;
import org.example.model.FileManager;
import org.example.model.GradesRepo;
import org.example.model.Student;
import org.example.model.StudentRepo;

import java.util.ArrayList;
import java.util.List;
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
        List<Student> students = new ArrayList<>();
        try {
            System.out.print("Your choice: ");
            String value = scanner.nextLine();

            switch (value) {
                case "1":
                    String firstname;
                    System.out.print("Enter the firstname: ");
                    firstname = scanner.nextLine();
                    firstname = firstname.trim();

                    students = PublicInstances.studentRepo.searchStudentFirstName(firstname);
                    break;

                case "2":
                    String lastname;
                    System.out.print("Enter the lastname: ");
                    lastname = scanner.nextLine();
                    lastname = lastname.trim();

                    students = PublicInstances.studentRepo.searchStudentLastName(lastname);
                    break;

                case "3":
                    int age;
                    System.out.print("Enter the age of the student: ");
                    age = scanner.nextInt();
                    scanner.nextLine();

                    students = PublicInstances.studentRepo.searchStudentAge(age);
                    break;

                case "4":
                    String grade;
                    System.out.print("Enter the grade of the student: ");
                    grade = scanner.nextLine();
                    grade = grade.trim();

                    students = PublicInstances.studentRepo.searchStudentGrade(grade);
                    break;

                case "5":
                    System.out.println("-----------------------");
                    Menu.menu(scanner);
                    break;
                default:
                    System.out.println("Invalid choice");
                    menuChoice(scanner);
                    break;
            }
            for (Student student : students) {
                System.out.println(student);
            }
            Menu.menu(scanner);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
