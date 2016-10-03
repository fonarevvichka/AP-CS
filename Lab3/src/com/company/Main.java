package com.company;

public class Main {

    public static String letters (char lastLetter) {
        String finalString = "";
        if (lastLetter == 'a') {
           return "a";
        }

        else {
//            System.out.println("final string " + finalString);
            return finalString = lastLetter + letters((char) ((int) lastLetter - 1));
        }

    }

    public int twos (int number) {
        int numberOfFactors = 0;

        return numberOfFactors;
    }

    public boolean powerOf3 (int number) {
       return true;
    }

    public static int reverse (int number) {
        String temp = Integer.toString(number);
        int lengthOfNum = temp.length();
//        System.out.println(lengthOfNum);
        int reversedNumber = 0;
        if (number < 10)
            return number;

        else {
            reversedNumber += Math.pow(10, (lengthOfNum - 1)) * (number % 10);
            System.out.println(number/10);
            reverse(number/10);
        }
       return reversedNumber;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(reverse(1234));
    }
}
