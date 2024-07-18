package org.example.view;

import org.example.PublicInstances;

import java.util.Scanner;

public class AverageStudentsInfo {
    public static void menu(Scanner scanner){
        int id;
        System.out.println(); // Line break

        System.out.println("----------------------");
        System.out.print("ID of the student : ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println(); // Line break

        double studentAverage = PublicInstances.gradesRepo.studentAverage(id);
        System.out.println("Grades average for student is " + studentAverage + " / 20");
    }
}
