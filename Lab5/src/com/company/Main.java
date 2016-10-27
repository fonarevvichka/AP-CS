package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        boolean found;
        int size = getSize(cin);
        int[] numbers = new int[size];
        fillArray(numbers, size, cin);

        printArray(numbers, size);
//        findValue(numbers, size, cin);
        System.out.print("\n");
        System.out.print("\n");
//        rotate(numbers, size, cin);a
        size = deleteZeroes(numbers, size);
        printArray(numbers, size);
    }

    public static void printArray(int numbers[], int arrayLength) {
        System.out.print("array positions: ");
        for(int i = 0; i < arrayLength; i++)
            System.out.print(i + " ");
        System.out.print("\n");
        System.out.print("array entries:   ");
        for(int i = 0; i < arrayLength; i++)
            System.out.print(numbers[i] + " ");
    }
    public static int getSize(Scanner cin) {
        System.out.println("Please enter the size of your array: ");
        return(cin.nextInt());
    }
    public static void fillArray(int numbers[], int arrayLength, Scanner cin) {
        for(int i = 0; i < arrayLength; i++) {
            System.out.println("Please enter the value for position: " + i);
            numbers[i] = cin.nextInt();
        }
    }
    public static void printSize(int size) {
        System.out.println("Size of array: " + size);
    }
    public static void findValue(int numbers[], int size, Scanner cin) {
        System.out.print("\n");
        do {
           System.out.println("What entry? ");
            int query = cin.nextInt();
            boolean found = false;
            int placeFound = 0;
            for(int i = 0; i < size; i++) {
                if (numbers[i] == query) {
                    found = true;
                    placeFound = i;
                    i = size;
                }
            }
            if(found) {
                System.out.println("status: found at position: " + placeFound);
            } else {
                System.out.println("status: not found");
            }
            System.out.println("Do you want to continue searching (yes/no)?: ");
        } while(cin.next().equals("yes"));
    }
    public static void smallest(int numbers[], int size) {
        int smallestValue = 666;
        int tempValue, changeAdd = 0;
        for(int i = 0; i < size; i++) {
            tempValue = numbers[i];
            if(tempValue < smallestValue) {
                smallestValue = tempValue;
                changeAdd = i;
            }
        }
        if(changeAdd != 0) {
            numbers[changeAdd] = numbers[0];
            numbers[0] = smallestValue;
        }
    }
    public static void rotate(int numbers[], int size, Scanner cin) {
        System.out.println("How many steps? ");
        int steps = cin.nextInt();
        int temp = 0, temp2 = 0;
        if(steps > 0) {
            for(int i = 0; i < steps; i++) {
                for(int k = 0; k < size; k++) {
                    if(k == 0){
                        temp = numbers[k];
                        numbers[k] = numbers[size -1];
                   } else {
                        temp2 = temp;
                        temp = numbers[k];
                        numbers[k] = temp2;
                    }
                }
            }
        } else {
            for(int i = size - 1; i >= 0; i--) {
                if(i == size-1) {
                    temp = numbers[i];
                    numbers[i] = numbers[0];
                } else {
                    temp2 = temp;
                    temp = numbers[i];
                    numbers[i] = temp2;
                }
            }
        }
    }
    public static int deleteZeroes(int numbers[], int size) {
       int newSize = size;
        for(int i = 0; i < size; i++) {
           if(numbers[i] == 0) {
               if(i == size -1) {
                   newSize--;
                   i = size;
               } else {
                   numbers[i] = numbers[i + 1];
                   numbers[i + 1] = 0;
                   newSize--;
                 System.out.println(newSize);
               }
           }
       }
        return newSize;
    }
}
