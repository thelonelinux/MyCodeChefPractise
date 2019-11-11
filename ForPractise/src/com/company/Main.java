package com.company;

import java.util.Scanner;

public class Main {

   static void printRepeating(int arr[], int size)
    {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++)
        {
            if (arr[ Math.abs(arr[i])] >= 0)
                arr[ Math.abs(arr[i])] = -arr[ Math.abs(arr[i])];
            else
                System.out.print(Math.abs(arr[i]) + " ");
        }
    }

    // Driver program
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 1, 6, 6, 6};
        int arr_size = arr.length;

        printRepeating(arr, arr_size);
    }
}
