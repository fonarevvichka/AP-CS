package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner cin = new Scanner(System.in);
        int[] array = generateArray();
        print(array, false);
        System.out.println("\n");
        Arrays.sort(array);
        print(array, true);
        System.out.println("\n");

        System.out.println("What item would you like to search for? ");
        int searchQuery = cin.nextInt();
        int location = Arrays.binarySearch(array, searchQuery);
        if (location >= 0 )
            System.out.println("status: found at index: " + location);
        else
            System.out.println("status: not found: " + location);
    }
    public static int[] generateArray() {
        Random randomizer = new Random();
        int [] array = new int[randomizer.nextInt(31) + 20];
        for(int i = 0; i < array.length; i++) {
            array[i] = randomizer.nextInt(100);
        }
        return array;
    }
    public static void print(int[] array, boolean done) {
        if(!done)
            System.out.println("Original array of " + array.length + " elements:");
        else
            System.out.println("Sorted array of " + array.length + " elements:");
        for (int i = 1; i <= array.length; i++) {
            if(i%10 == 0)
                System.out.println(array[i-1] + " ");
            else
                System.out.print(array[i-1] + " ");
        }
    }
    @Override
    public static int[] binarySearch(int[] array, int searchQuery) {
        int low = 0;
        int high = array.length - 1;
        int[] results = new int[2];

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = array[mid];

            if (midVal < searchQuery)
                low = mid + 1;
            else if (midVal > searchQuery)
                high = mid - 1;
            else
                low = 200; // key found
        }
       if(low == 200) {
           results[0] = 
       }
    }
}
