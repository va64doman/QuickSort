/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortapp;

import java.util.*;

/**
 *
 * @author Van Do
 */
public class AppClass 
{
    // All methods must include scanner to allow user to input data
    private Scanner scan;
    // Set array of students as list
    private Student[] list;
    // Allow to access quick sort class
    private QuickSort sort;
    // Set choice as integer
    private int choice;
    // Handle the application's function
    public void usingApp()
    {
        // Set sort as object
        sort = new QuickSort();
        // Set scan to enter name including spaces
        scan = new Scanner(System.in).useDelimiter("[\r\n]");
        // Iterate while the user wants to keep going
        do
        {
            // Enter the size of the array
            System.out.println("Enter the size of the list of students to sort out.");
            int size = handleInt();
            // Set list's size
            list = new Student[size];
            // Iterate loop until reaches to list's size
            for(int count = 0; count < size; count++)
            {
                // Set student's object
                Student student;
                // Set alreadyExist as boolean
                boolean alreadyExist;
                // Continue this loop when duplication is involved
                do
                {
                    // Set alreadyExist to false
                    alreadyExist = false;
                    int grade;
                    // Continue entering grade while grade is less than 0 or greater than 100
                    // To avoid inconsistent real life result to users
                    do
                    {
                        // Enter average result for this student
                        System.out.println("Enter the average result for this student.");
                        grade = handleInt();
                        if(grade < 0 || grade > 100)
                        {
                            System.out.println("Grade must be between 0 to 100 inclusively.");
                        }
                    }
                    while(grade < 0 || grade > 100);
                    // Enter this student's name
                    System.out.println("Enter the student's name.");
                    String name = scan.next();
                    System.out.println();
                    // Set student's object from grade and name
                    student = new Student(grade, name);
                    // If the list is not empty
                    if(count != 0)
                    {
                        // Iterate list
                        for(int element = 0; element < size; element++)
                        {
                            // Set students as list[element]
                            Student students = list[element];
                            // If the next element from list is not empty
                            if(element < count)
                            {
                                // If grade is the same from input
                                if(students.getGrade() == grade)
                                {
                                    // If name is the same from input
                                    if(students.getName().equals(name))
                                    {
                                        // Set alreadyExist to true to avoid duplication
                                        alreadyExist = true;
                                    }
                                }
                            }
                        }
                    }
                    // If object is already exists from list, display this message
                    if(alreadyExist)
                    {
                        System.out.println("The student's grade and name is already exists.");
                    }
                }
                while(alreadyExist);
                // Add student to list
                list[count] = student;
            }
            // Display unsorted list using for each loop
            System.out.println("Display Unsorted Students.");
            for(Student students : list)
            {
                students.printStudent();
            }
            System.out.println();
            // Sort list by name
            sort.sortByName(list, 0, size - 1);
            // Display sorted list by name
            System.out.println("Display Sorted Students by Name.");
            for(Student students : list)
            {
                students.printStudent();
            }
            System.out.println();
            // Sort list by grade
            sort.sortByGrade(list, 0, size - 1);
            // Display sorted list by grade
            System.out.println("Display Sorted Students by Grade.");
            for(Student students : list)
            {
                students.printStudent();
            }
            System.out.println();
            // Display this message if wanted to continue this app
            System.out.println("Do you want to continue? Yes (1) or No (Any number)");
            choice = handleInt();
        }
        while(choice == 1);
    }
    // Handle integer inputs
    private int handleInt()
    {
        int input = 0;
        // Assuming this continue in a loop until the user has entered the integer
        boolean loop = true;
        // Continue this loop until the user has entered the input correctly
        while(loop)
        {
            // Try and catch error if the user has not entered the integer
            try
            {
                input = scan.nextInt();
                System.out.println();
                loop = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Try again. Wrong input.");
                scan.nextLine();
            }
        }
        return input;
    }
}
