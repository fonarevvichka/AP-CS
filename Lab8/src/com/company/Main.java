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
        print(array, false);
        System.out.println("\n");
        Arrays.sort(array);
        print(array, true);
        System.out.println("\n");
//        for(int i = 0; i < 2; i++) {
//            System.out.println("What item would you like to search for? ");
//            int searchQuery = cin.nextInt();
//            int location = Arrays.binarySearch(array, searchQuery);
//            if (location >= 0)
//                System.out.println("status: found at index: " + location);
//            else
//                System.out.println("status: not found: " + location);
//        }
        binarySearch(array, 4, results);
        print(array, false);
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
    public static int[] binarySearch(int[]array, int searchQuery, int[] results) {
        results = binarySearch(array, searchQuery, 0, array.length/2, array.length-1, results);
        return results;
    }
    public static int[] binarySearch(int[] array, int searchQuery, int lowVal, int midVal, int highVal, int[] results) {
        if (lowVal == highVal) {
            results[1]++;
            results[0] = -1;
        }
        else if (array[midVal] < searchQuery) {
            results[1]++;
            return binarySearch(array, searchQuery, midVal + 1, midVal + (highVal - midVal) /2, highVal, results);
       }
       else if (array[midVal] > searchQuery){
            results[1] += 2;
            return binarySearch(array, searchQuery, lowVal, midVal - (highVal - midVal) /2, midVal - 1, results);
        } else {
            results[1] += 3;
            results[0] = midVal;
            return results;
        }
    return results;
    }
}
