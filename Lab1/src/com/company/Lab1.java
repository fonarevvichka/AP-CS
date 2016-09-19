// Vichka Fonarev
// F Block
// AP CS
// Due September

package com.company;

public class Lab1 {

    public static void main(String[] args) {
//        displayFactors(4);
        System.out.println(GCD(7, 28));
    }
    public static int GCD(int a, int b) {
        int i;

        if (a == 0 || b == 0)
            return -1;

        else if (a > b) {
           if ((a % b) == 0)
               return b;
           else {
               i = b - 1;

               while ((a % i) != 0 || (b % i) != 0) {

                   System.out.println(i);
                   i--;
               }
               return i;
           }
       }
       else if(b > a) {
           if ((b % a) == 0) {
               return a;
           }
           else {
               i = a - 1;
               while ((a % i) != 0 || (b % i) != 0) {
                   i--;
               }
               return i;
           }
       }
       else
            return a;
    }
    public static void displayFactors(int number) {
        System.out.print("The factors of " + number + " are: ");
        for (int i = 1; i < number; i++) {
            if((number % i) == 0) {
                System.out.print(i + ", ");
            }
        }
        System.out.println(number + ".");
    }

}

