package com.company;

public class Main {

    public static void main(String[] args) {
//        System.out.println(reverse(1234));
        printWithCommas(1231231423);
//      System.out.println(power(10000 /100));
//       System.out.println( power(3, 2));
    }

    public static String letters(char lastLetter) {
        if (lastLetter == 'a')
            return "a";
        else
            return lastLetter + letters((char) ((int) lastLetter - 1));
    }
    public int twos(int num) {
        if ((num % 2) != 0)
            return 0;
        else
            return 1 + twos(num/2);
    }
    public boolean powerOf3(int num) {
        if ((num % 3) != 0)
            return false;
        else if (num >1)
            return powerOf3(num/3);
        else
            return true;
    }
    public static int reverse(int num) {
        if (num < 10)
            return num;
        else
            return ((num % 10) * power(num, 1)) + reverse(num/10);
    }
    public static int power(int num, int option) {
        if(option == 1) {
            if (num < 10)
                return 1;
            else
                return 10 * power(num/10, 1);
        }
        else if (option == 2) {
            if (num < 2)
                return 10;
            else
                return 10 * power(num - 1, 2);
        } else {
            if (num < 1000)
                return 0;
            else
                return 1 + power(num/1000, 3);
        }
    }
    public static void printWithCommas(int num) {
        if (num < 1000)
            System.out.print(num);
        else {
            printWithCommas(num / 1000);
            System.out.print("," + num % 1000);
        }
    }
    public static int base5(int num) {






        return -1;
    }
}