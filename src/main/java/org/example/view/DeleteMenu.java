package org.example.view;


import org.example.PublicInstances;
import org.example.model.StudentRepo;

import java.util.Scanner;

public class DeleteMenu {
    public static void menu(Scanner scanner){
        int id;
        System.out.println(); // Line break
        System.out.println("----------------------");
        System.out.print("Id : ");

        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println(); // Line break


        PublicInstances.studentRepo.deleteStudent(id);

    }

}
