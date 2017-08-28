/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortapp;

/**
 *
 * @author Van Do
 */

public class Student
{
    // Finialised student's grade and name using the parameterised constructor
    private final int grade;
    private final String name;
    // Insert student
    public Student(int sGrade, String sName)
    {
        grade = sGrade;
        name = sName;
    }
    // Get student's grade
    public int getGrade()
    {
        return grade;
    }
    // Get student's name
    public String getName()
    {
        return name;
    }
    // Print student's details
    public void printStudent()
    {
        System.out.println(grade + " " + name);
    }
    
}
