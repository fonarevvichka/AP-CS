// Vichka Fonarev
// F Block
// AP CS
// Due September

package com.company;

public class Lab1 {

    public static void main(String[] args) {
        displayFactors(30);
    }

    public static void displayFactors(int number) {
        System.out.println("The factors of " + number + " are: ");
        for (int i = 1; i < number; i++) {
            if((number % i) == 0) {
                System.out.print(i + ", ");
            }
        }
        System.out.println(number + ".");
    }

}

