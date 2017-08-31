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
    private Scanner scan;
    private Student[] list;
    private QuickSort sort;
    private int choice;
    
    public void usingApp()
    {
        sort = new QuickSort();
        scan = new Scanner(System.in).useDelimiter("[\r\n]");
        do
        {
            System.out.println("Enter the size of the list of students to sort out.");
            int size = handleInt();
            list = new Student[size];
            for(int count = 0; count < size; count++)
            {
                Student student;
                boolean alreadyExist;
                do
                {
                    alreadyExist = false;
                    System.out.println("Enter the average result for this student.");
                    int grade = handleInt();
                    System.out.println("Enter the student's name.");
                    String name = scan.next();
                    System.out.println();
                    student = new Student(grade, name);
                    if(count != 0)
                    {
                        for(int element = 0; element < size; element++)
                        {
                            Student students = list[element];
                            if(element < count)
                            {
                                if(students.getGrade() == grade)
                                {
                                    if(students.getName().equals(name))
                                    {
                                        alreadyExist = true;
                                    }
                                }
                            }
                        }
                    }
                    if(alreadyExist)
                    {
                        System.out.println("The student's grade and name is already exists.");
                    }

                }
                while(alreadyExist);
                list[count] = student;
            }

            System.out.println("Display Unsorted Students.");
            for(Student students : list)
            {
                students.printStudent();
            }
            
            System.out.println();
            
            sort.sortByName(list, 0, size - 1);

            System.out.println("Display Sorted Students by Name.");
            for(Student students : list)
            {
                students.printStudent();
            }
            
            System.out.println();
            
            sort.sortByGrade(list, 0, size - 1);

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
