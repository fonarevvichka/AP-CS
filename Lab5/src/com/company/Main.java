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
        // find value caller

        String choice = "";
        do {
            System.out.println("What entry are you looking for? ");
            found = findValue(numbers, size, cin.nextInt());
            if
            System.out.println("Do you want to continue searching (yes/no)?: ");
        } while(choice.equals("yes"));
        // find value caller
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
    public static void findValue(int numbers[], int size, int query) {
        boolean found = false;
        int placeFound = 0;
        for(int i = 0; i < size; i++) {
            if(numbers[i] == query) {
                found = true;
                placeFound = i;
                i = size;
            }
        }
        return false;
    }
}
