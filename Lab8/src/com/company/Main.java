package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner cin = new Scanner(System.in);
        int[] array = generateArray();
        int[] results = new int[2];
        results[0] = 1;
        System.out.println("Part 1");
        print(array, false);
        System.out.println("\n");
        Arrays.sort(array);
        print(array, true);
        System.out.println("\n" + "Part 2" + "\n");
        for(int i = 0; i < 2; i++) {
            System.out.println("What item would you like to search for? ");
            int searchQuery = cin.nextInt();
            int location = Arrays.binarySearch(array, searchQuery);
            if (location >= 0)
                System.out.println("status: found at index: " + location);
            else
                System.out.println("status: not found: " + location);
        }
        System.out.println("\n" + "Part 3");
        for(int i = 0; i < 2; i++) {
            System.out.println("What entry? ");
            results = binarySearch(array, cin.nextInt());

            if (results[1] == -1)
                System.out.println("Status: entry not found after " + results[0] + " probes");
            else
                System.out.println("Status: entry found at index " + results[1] + " after " + results[0] + " probes");
        }
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
    public static int[] binarySearch(int[] array, int searchQuery) {
        int[] results = new int[2];
        results[0] = 0;
        results[1] = -1;
        int lowVal = 0;
        int midVal;
        int highVal = array.length-1;

        while(highVal >= lowVal) {
            midVal = (highVal + lowVal)/2;
            if(array[midVal] == searchQuery) {
                results[0]++;
                results[1] = midVal;
                return results;
            } else if (array[midVal] > searchQuery) {
                results[0]+= 2;
                highVal = midVal-1;
            } else {
                results[0]+= 2;
                lowVal = midVal+1;
            }
        }
    return results;
    }
}
