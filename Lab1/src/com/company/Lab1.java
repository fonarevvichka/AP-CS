// Vichka Fonarev
// F Block
// AP CS
// Due September

package com.company;

import java.util.Scanner;

public class Lab1 {
    static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) {
//        displayFactors(4);
//        System.out.println(GCD(7, 28));
//        System.out.println( prime(7));
//        System.out.println(power(25, 3));
//        System.out.println(findDigit(123472, 9));
//        downDigits(12345);
//        System.out.println(countDigits(123.74));
        int z = 0;

        do {
            z = options();
            switch(z) {
                case 1:
                    System.out.println("Please enter your first number (greater than 0): ");
                    int userNum1 = cin.nextInt();
                    System.out.println("Please enter your second number (greater than 0): ");
                    int userNum2 = cin.nextInt();
                    if(userNum1 < 0 || userNum2 < 0) {
                        System.out.println("Invalid input, try again.");
                        break;
                    }
                    else
                        System.out.println("The greatest common divisor is: " + GCD(userNum1, userNum2));
                    break;
                case 2:
                    System.out.println("Please enter the base (integer values only): ");
                    int base = cin.nextInt();
                    System.out.println("Please enter the power (integer values only): ");
                    int power = cin.nextInt();
                    if (base == 0 && power < 0)
                        System.out.println("Invalid combination, please try again.");
                    else
                        System.out.println("The result of the calculation is: " + power(base, power));
                    break;
                case 3:
                    System.out.println("Please enter your number: ");
                    int userNum = cin.nextInt();
                    if(userNum > 0) {
                        if (prime(userNum))
                            System.out.println(userNum + " is prime.");
                        else
                            System.out.println(userNum + " is not prime.");
                    }
                    else
                        System.out.println("Invalid input. Non zero, positive integers only. Please try again.");
                    break;
                case 4:
                    System.out.println("Please enter the number you would like to factor: ");
                    userNum = cin.nextInt();
                    if(userNum > 0)
                        displayFactors(userNum);
                    else
                        System.out.println("Invalid input. Non zero, positive integers only. Please don't try again.");
                    break;
                case 5:
                    System.out.println("Please enter the number you would like to break down: ");
                    userNum = cin.nextInt();
                    downDigits(userNum);
                    break;
                case 6:
                    System.out.println("Please enter the number you would like to process: ");
                    userNum = cin.nextInt();
                    System.out.println("The number of digits is: " + countDigits(userNum));
                    break;
                case 7:
                    System.out.println("Please enter the number you would like to parse: ");
                    userNum1 = cin.nextInt();
                    System.out.println("Please enter the place you are looking for (count from the right)");
                    userNum2 = cin.nextInt();
                    if(userNum1 > 0 && userNum2 > 0 && countDigits(userNum1) >= userNum2) {
                        System.out.println("The digit at position " +
                                userNum2 +
                                " in the number " +
                                userNum1 + " is " +
                                findDigit(userNum1, userNum2));
                    }
                    else
                        System.out.println("Invalid input. Non zero, positive integers only (Length of the number must be greater than the position). Please try again.");
                    break;
            }
        } while (z != 0);
    }
    public static int options() {
        int userOptions = 0;

        do {
            System.out.println("\n" + "Please enter what method you want to run: ");
            System.out.println("1. Greatest Common Divisor" + "\n" +
                    "2. Power" + "\n" +
                    "3. Prime Checker" + "\n" +
                    "4. Display Factors" + "\n" +
                    "5. Down digits" + "\n" +
                    "6. Count Digits" +"\n" +
                    "7. Find digit" + "\n" +
                    "0. Enter 0 to exit");

            if((userOptions = cin.nextInt()) < 8)
                return userOptions;
            else
                System.out.println("Invalid method call, please try again");
        } while (userOptions > 0 && userOptions < 8);
        return -1;
    }

    public static int findDigit(int number, int position) {
        int place = 1;

        for(int i = 1; i <= position; i++)
            place *= 10;

        return ((number %= place) / (place/10));
    }
    public static double power(double base, int exponent) {
        double finalNum = base;
        boolean change = false;

        if(exponent < 0) {
            exponent *= -1;
            change = true;
        }

        if(exponent != 0) {
            for (int i = 1; i < exponent; i++) {
                finalNum *= base;
            }
            if(change == true)
                return (1/finalNum);
            else
                return finalNum;
        }

        else
            return 1;
    }
    public static boolean prime(int num) {
        int halfNum = num / 2;
        for (int i = 2; i < halfNum; i++) {
            if((num % i) == 0)
                return false;
        }
        return true;
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

//                   System.out.println(i);
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
    public static void downDigits(int num) {
        System.out.println("The digits of " + num + " are:");
        int numberLength = countDigits((double) num);
        for(int i = numberLength; i > 0; i--) {
            System.out.println(findDigit(num, i));
        }
    }
    public static int countDigits(double num) {
        int numberLength = 1;
        int numCopy = (int) num;

        while((numCopy /= 10) != 0)
            numberLength++;

//        System.out.println(numberLength);
        return numberLength;
    }
}
