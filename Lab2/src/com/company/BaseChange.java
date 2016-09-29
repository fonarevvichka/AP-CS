package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BaseChange {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

//        System.out.println("Please enter your desired base:");
//        System.out.println(findDigit(10, 2));
//        System.out.println(countDigits(10000));
        System.out.println(addition(10, 1, 2));
    }

    public static int addition(int num1, int num2, int base) {
        int finalNum = 0, carryOver = 0, loopLength;
        int numberOfDigits1 = countDigits(num1);
        int numberOfDigits2 = countDigits(num2);

            int number1[] = new int[numberOfDigits1];
            int number2[] = new int[numberOfDigits2];

        for(int j = 1; j <= 2; j++) {
            if (j == 1)
                loopLength = (numberOfDigits1);
            else
                loopLength = (numberOfDigits2);
//            System.out.println(loopLength);

            for (int i = loopLength - 1; i >= 0; i--) {
//                System.out.println(loopLength +  " - looplength | countDigit - " + countDigits(num1));
                if (j == 1) {
//                    System.out.println("loop fam");
                    number1[i] = findDigit(num1, loopLength - i);
                }
                else
                    number2[i] = findDigit(num2, loopLength - i);
            }
            System.out.println(Arrays.toString(number1));
        }

        if (numberOfDigits1 > numberOfDigits2)
            loopLength = numberOfDigits1;
        else
            loopLength = numberOfDigits2;

        return finalNum;
    }

    public static int findDigit(int number, int position) {
        for(int i = 1; i < position; i++)
            number /= 10;

        return number%10;
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
    public static int countDigits(double num) {
        int numberLength = 1;
        int numCopy = (int) num;

        while((numCopy /= 10) != 0)
            numberLength++;

//        System.out.println(numberLength);
        return numberLength;
    }
}
