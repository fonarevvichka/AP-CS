package com.company;

public class Main {

    public static void main(String[] args) {
//        System.out.println(reverse(1234));
        printWithCommas(123456789);
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
            return ((num % 10) * power(num)) + reverse(num/10);
    }
    public static int power(int num) {
        if (num < 10)
            return 1;
        else
            return 10 * power(num/10);
    }
    public static void printWithCommas(int num) {
        if (num < 1000)
            System.out.print(num);
        else {
            System.out.print((num/1000) * (power(num)/power(num/1000)) + ",");
            printWithCommas(num/1000);
        }
    }
}
