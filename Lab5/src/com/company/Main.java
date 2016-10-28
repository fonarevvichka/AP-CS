// Vichka Fonarev
// F BLock AP-CS
// 10/27/16
// Lab 5


package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int size = getSize(cin);
        int[] numbers = new int[size];
        fillArray(numbers, size, cin);

        int userChoice;
        boolean stop = false;
        while (!stop) {
            System.out.println("Please select your option: " + "\n" +
                                "1. Display the array" + "\n" +
                                "2. Search for an entry" + "\n" +
                                "3. Sort the smallest digit" + "\n" +
                                "4. rotate the array" + "\n" +
                                "5. Delete all zeroes" + "\n" +
                                "0. Quit");
            userChoice = cin.nextInt();
            switch(userChoice) {
                case 1:
                    printArray(numbers, size);
                    System.out.println("\n");
                    break;
                case 2:
                    findValue(numbers, size, cin);
                    System.out.println("\n");
                    break;
                case 3:
                    smallest(numbers, size);
                    printArray(numbers, size);
                    System.out.println("\n");
                    break;
                case 4:
                    rotate(numbers, size, cin);
                    printArray(numbers, size);
                    System.out.println("\n");
                    break;
                case 5:
                    numbers = deleteZeroes(numbers, size);
                    size = numbers.length;
                    printArray(numbers, size);
                    System.out.println("\n");
                    break;
                case 0:
                    stop = true;
            }
        }
    }

    public static void printArray(int numbers[], int arrayLength) {
        System.out.printf("%-15s", "Size of array: ");
        System.out.println(arrayLength);

        System.out.printf("%-17s", "array positions:");
        for (int i = 0; i < arrayLength; i++)
            System.out.printf("%5s", i);
        System.out.print("\n");
        System.out.printf("%-17s", "array entries:");
        for (int i = 0; i < arrayLength; i++)
            System.out.printf("%5s", numbers[i]);
    }
    public static int getSize(Scanner cin) {
        System.out.println("Please enter the size of your array:");
        return (cin.nextInt());
    }
    public static void fillArray(int numbers[], int arrayLength, Scanner cin) {
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Please enter the value for position: " + i);
            numbers[i] = cin.nextInt();
        }
    }
    public static void findValue(int numbers[], int size, Scanner cin) {
        System.out.print("\n");
        do {
            System.out.println("What entry? ");
            int query = cin.nextInt();
            boolean found = false;
            int placeFound = 0;
            for (int i = 0; i < size; i++) {
                if (numbers[i] == query) {
                    found = true;
                    placeFound = i;
                    i = size;
                }
            }
            if (found) {
                System.out.println("status: found at position: " + placeFound);
            } else {
                System.out.println("status: not found");
            }
            System.out.println("Do you want to continue searching (yes/no)?: ");
        } while (cin.next().equals("yes"));
    }
    public static void smallest(int numbers[], int size) {
        int smallestValue = 666;
        int tempValue, changeAdd = 0;
        for (int i = 0; i < size; i++) {
            tempValue = numbers[i];
            if (tempValue < smallestValue) {
                smallestValue = tempValue;
                changeAdd = i;
            }
        }
        if (changeAdd != 0) {
            numbers[changeAdd] = numbers[0];
            numbers[0] = smallestValue;
        }
    }
    public static void rotate(int numbers[], int size, Scanner cin) {
        String yesVno = "";
        do {
            System.out.println("How many steps? ");
            int steps = cin.nextInt();
            int temp = 0, temp2 = 0;
            if (steps > 0) {
                for (int i = 0; i < steps; i++) {
                    for (int k = 0; k < size; k++) {
                        if (k == 0) {
                            temp = numbers[k];
                            numbers[k] = numbers[size - 1];
                        } else {
                            temp2 = temp;
                            temp = numbers[k];
                            numbers[k] = temp2;
                        }
                    }
                }
            } else {
                for (int i = 0; i < steps * -1; i++) {
                    for(int k = size -1; k >= 0; k--) {
                        if (k == size - 1) {
                            temp = numbers[k];
                            numbers[k] = numbers[0];
                        } else {
                            temp2 = temp;
                            temp = numbers[k];
                            numbers[k] = temp2;
                        }
                    }
                }
            }
            printArray(numbers, size);
            System.out.println("\n");
            System.out.println("search again (yes/no)? ");
            yesVno = cin.next();
        } while (yesVno.equals("yes"));
    }
    public static int[] deleteZeroes(int numbers[], int size) {
        int newLength = 0;
        for(int i = 0; i < size; i++) {
            if(numbers[i] == 0) {
                newLength++;
            }
        }
        newLength = size - newLength;
        int[] newArray = new int[newLength];
        for (int k = 0; k < newLength; k++) {
            for (int i = 0; i < size; i++) {
                if (numbers[i] != 0) {
                    newArray[k] = numbers[i];
                    numbers[i] = 0;
                    break;
                }
            }
        }

        for(int i = 0; i < newLength; i++){
            System.out.println(newArray[i]);
        }
        return newArray;
    }
}
