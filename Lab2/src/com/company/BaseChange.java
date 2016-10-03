//Vichka Fonarev
//Mr. Harris AP-CS F Block
//Lab 2 Base change 10.03.16


package com.company;

import java.util.Scanner;

public class BaseChange {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        for (int i = 1; i < 11; i++) {
            System.out.println("\n" + "Please enter your desired base:");
            String stringBase = new String(cin.next());
            int base = baseConversion(stringBase);
            if (base != -1) {
                System.out.println("Please enter your first number");
                int num1 = cin.nextInt();
                System.out.println("Please enter your second number");
                int num2 = cin.nextInt();
                System.out.println("Please enter the desired operation ('+' and '*' only)");
                String operation = cin.next();
                System.out.println("Output " + i + ":");
                if (operation.equals("*")) {
                    System.out.println(max(num1, num2));
                    System.out.println("* " + min(num1, num2));
                    for(int z = 0; z <= max(countDigits(num1), countDigits(num2)) + 2; z++)
                        System.out.print("-");
                    System.out.print("\n");
                    multiplicationV2(num1, num2, base);
                } else if (operation.equals("+")) {
                   System.out.print(max(num1, num2));
                    System.out.println("\n" + operation + " " + min(num1, num2));
                    for (int j = 0; j <= countDigits(max(num1, num2)); j++)
                        System.out.print("=");
                    System.out.println("\n" + addition(num1, num2, base));
                } else
                    System.out.println("Invalid operation, please try again");
            } else {
                System.out.println("Inavlid base, please try gain");
                i--;
            }
        }
    }
    public static int baseConversion(String base) {
        if (base.equals("human"))
            return 10;
        else if (base.equals("elf"))
            return 8;
        else if (base.equals("dwarf"))
            return 5;
        else if (base.equals("wizard"))
            return 2;
        else
            return -1;
    }
    public static int addition(int num1, int num2, int base) {
        int loopLength, finalNum = 0, carryOver = 0;
        int numberOfDigits1 = countDigits(num1);
        int numberOfDigits2 = countDigits(num2);

        if (numberOfDigits1 > numberOfDigits2)
            loopLength = numberOfDigits1;
        else
            loopLength = numberOfDigits2;

        for (int i = 1; i <= loopLength + 1; i++) {
            int temp1 = findDigit(num1, i);
            int temp2 = findDigit(num2, i);
//            System.out.println(carryOver);
            finalNum += ((temp1 + temp2 + carryOver) % base) * power(10, (i - 1));
            carryOver = (temp1 + temp2 + carryOver) / base;
        }
        return finalNum;
    }
    public static int findDigit(int number, int position) {
        for (int i = 1; i < position; i++)
            number /= 10;

        return number % 10;
    }
    public static double power(double base, int exponent) {
        double finalNum = base;
        boolean change = false;

        if (exponent < 0) {
            exponent *= -1;
            change = true;
        }

        if (exponent != 0) {
            for (int i = 1; i < exponent; i++) {
                finalNum *= base;
            }
            if (change == true)
                return (1 / finalNum);
            else
                return finalNum;
        } else
            return 1;
    }
    public static int countDigits(double num) {
        int numberLength = 1;
        int numCopy = (int) num;

        while ((numCopy /= 10) != 0)
            numberLength++;

//        System.out.println(numberLength);
        return numberLength;
    }
    public static int max(int num1, int num2) {
        if (num1 > num2)
            return num1;
        else
            return num2;
    }
    public static int min(int num1, int num2) {
        if (num1 > num2)
            return num2;
        else
            return num1;
    }
    public static void multiplicationV2(int num1, int num2, int base) {
        int outsideLoop = min(countDigits(num1), countDigits(num2)) + 1;
        int nestedLoop = max(countDigits(num1), countDigits(num2)) + 1;

        int finalNum = 0; int numToPrint = 0, carryOver = 0;

        int smaller = min(num1, num2);
        int larger = max(num1, num2);

        for(int i = 1; i <= outsideLoop; i++) {
            int smallerTemp = findDigit(smaller, i);
            numToPrint = 0;
            for(int j = 1; j <= nestedLoop; j++) {
                int largerTemp = findDigit(larger, j);
                finalNum = addition(((smallerTemp * largerTemp + carryOver) % base) * (int) power(10, ((i + j) - 2)), finalNum, base);
                numToPrint += ((smallerTemp * largerTemp + carryOver) % base) * (int) power(10, j - 1);
                carryOver = ((smallerTemp * largerTemp + carryOver) / base);
            }
            if (i < outsideLoop)
                System.out.println(numToPrint);
        }
        for (int j = -1; j <= outsideLoop; j++)
            System.out.print("=");
        System.out.print("\n");
        System.out.println(finalNum);

    }
}
