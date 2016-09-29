package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BaseChange {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

//        System.out.println("Please enter your desired base:");
//        System.out.println(findDigit(10, 2));
//        System.out.println(countDigits(10000));
        System.out.println((addition(1234, 1234, 5)));
    }
    public static void multiplication(int num1, int num2, int base) {
    int loopLength, finalNum = 0, carryOver = 0;
        int numberOfDigits1 = countDigits(num1);
        int numberOfDigits2 = countDigits(num2);

        if (numberOfDigits1 > numberOfDigits2)
            loopLength = numberOfDigits1;
        else
            loopLength = numberOfDigits2;

        for(int i = 1; i <= (loopLength + 1); i++) {

        }
    //nested loop that cycles through second digit in big loop, and first digit top loop
    }
    public static int addition(int num1, int num2, int base) {
        int loopLength, finalNum = 0, carryOver = 0;
        int numberOfDigits1 = countDigits(num1);
        int numberOfDigits2 = countDigits(num2);

        if (numberOfDigits1 > numberOfDigits2)
            loopLength = numberOfDigits1;
        else
            loopLength = numberOfDigits2;

        for(int i = 1; i <= loopLength+1; i++) {
            int temp1 = findDigit(num1, i);
            int temp2 = findDigit(num2, i);
//            System.out.println(carryOver);
            finalNum += ((temp1 + temp2 + carryOver) % base) * power(10, (i-1));
            carryOver = (temp1 + temp2 +carryOver) / base;
        }
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
