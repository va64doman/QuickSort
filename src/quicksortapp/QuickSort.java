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

public class QuickSort 
{
    // Sorting part of the array by grade
    private int partitionByGrade(Student[] student, int low, int high)
    {
        // Set the pivot value by the right student's grade from the partition
        int pivot = student[high].getGrade();
        // Set small by deducting low by 1
        int small = low - 1;
        // Iterate until count is less than high, set count to low
        for(int count = low; count < high; count++)
        {
            // If this student's grade is less than pivot
            if(student[count].getGrade() <= pivot)
            {
                // Increment small by 1
                small++;
                // Swap student[small] and student[count]
                swap(student, small, count);
            }
        }
        // Swap student[small + 1] and student[high]
        swap(student, small + 1, high);
        // Return small + 1 as integer
        return small + 1;
    }
    // Sort part of array by name
    private int partitionByName(Student[] student, int low, int high)
    {
        // Set pivot by the right student's name from partition
        String pivot = student[high].getName();
        // Identical to partitionByGrade
        int small = low - 1;
        // Identical iteration
        for(int count = low; count < high; count++)
        {
            // Check if the order if the selected student's name is first or equal to pivot
            if(student[count].getName().compareToIgnoreCase(pivot) <= 0)
            {
                // Increment small by 1 and swap student[small] and student[count]
                small++;
                swap(student, small, count);
            }
        }
        // Swap student[small + 1] and student[high]
        swap(student, small + 1, high);
        // Return small + 1 as integer
        return small + 1;
    }
    // Swap two values
    private void swap(Student[] student, int left, int right)
    {
        // Set temp as student[temp] to avoid losing this data
        Student temp = student[left];
        // Set student[left] as student[right]
        student[left] = student[right];
        // Set student[right] as temp
        student[right] = temp;
    }
    // Sort grade
    public void sortByGrade(Student[] student, int low, int high)
    {
        // If low is less than high, start sorting
        if(low < high)
        {
            // Set middle value from partition
            int mid = partitionByGrade(student, low, high);
            // Sort again between low and middle - 1
            sortByGrade(student, low, mid - 1);
            // Sort again between middle + 1 and high
            sortByGrade(student, mid + 1, high);
        }
    }
    // Sort name
    public void sortByName(Student[] student, int low, int high)
    {
        // Same to sortByGrade
        if(low < high)
        {
            int mid = partitionByName(student, low, high);
            sortByName(student, low, mid - 1);
            sortByName(student, mid + 1, high);
        }

    }
}
