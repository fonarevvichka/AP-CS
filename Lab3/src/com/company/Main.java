// Vichka Fonarev
// F Block AP-CS
// Lab 3 Recursion

package com.company;
import java.util.Scanner;

public class Main {
    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
//----------------------- non recursive menu -----------------------//
//        int option;
//        do {
//            option = optionz();
//            switch (option) {
//                case 1:
//                    System.out.println("Please enter the letter you would like to work back from:");
//                    String userInput = cin.next();
//                    System.out.println(letters(userInput.charAt(0)));
//                    break;
//                case 2:
//                    System.out.println("Please enter your number:");
//                    System.out.println(twos(cin.nextInt()));
//                    break;
//                case 3:
//                    System.out.println("Please enter your number:");
//                    System.out.println(powerOf3(cin.nextInt()));
//                    break;
//                case 4:
//                    System.out.println("Please enter your number:");
//                    System.out.println(reverse(cin.nextInt()));
//                    break;
//                case 6:
//                    System.out.println("Please enter your number:");
//                    base5(cin.nextInt());
//                    System.out.println();
//                    break;
//                case 5:
//                    System.out.println("Please enter your number:");
//                    printWithCommas(cin.nextInt());
//                    System.out.print("\n");
//                    break;
//            }
//        } while (option != 0);

//---------------------- recursive menu -------------------//

//-------------------   recursive menu --------------------//
        options();
//-------------------   recursive menu --------------------//
    }

    public static String letters(char lastLetter) {
        if (lastLetter == 'a')
            return "a";
        else
            return letters((char) ((int) lastLetter - 1)) + lastLetter;
    }
    public static int twos(int num) {
        if ((num % 2) != 0)
            return 0;
        else
            return 1 + twos(num/2);
    }
    public static boolean powerOf3(int num) {
        if ((num % 3) != 0)
            return false;
        else if (num > 3)
            return powerOf3(num/3);
        else
            return true;
    }
    public static int reverse(int num) {
        boolean negative = false;
        if(num < 0) {
            num *= -1;
            negative = true;
        }
        if (num < 10)
            return num;
        else {
            if (!negative)
                return ((num % 10) * power(num)) + reverse(num / 10);
            else {
               System.out.println("negative is" + negative);
                return -1 * (((num % 10) * power(num)) + reverse(num / 10));
            }
        }
    }
    public static int power(int num) {
            if (num < 10)
                return 1;
            else
                return 10 * power(num/10);
    }
    public static void printWithCommas(int num) {
        int digits = num%1000;
        if (num < 1000)
            System.out.print(num);
        else {
            printWithCommas(num / 1000);
            System.out.print("," + (digits / 100) % 10 + "" + (digits/10) % 10 + "" + digits % 10);
//            System.out.print("," + num % 1000);
        }
    }
    public static void base5(int num) {
        if ((num / 5) < 1)
           System.out.print(num);
        else {
            base5(num/5);
            System.out.print(num % 5);
        }
    }
    public static void options() {
       System.out.println("Please select the method you would like to run");
       System.out.println("1. Lettters" + "\n" +
                          "2. Twos" + "\n" +
                          "3. Power of three" + "\n" +
                          "4. Reverse" + "\n" +
                          "5. Print with commas" + "\n" +
                          "6. Base 5" + "\n" +
                          "0. Exit");
        int option = cin.nextInt();
        if (option < 0 || option > 6) {
            System.out.println("Invalid input, please try again");
            options();
        }
        else if (option == 0) {
            System.out.println("Thanks for playing");
           System.out.println("╲╲╲┏╮┏╮╲╲╲╲╲╲╲╲╲" + "\n" +
                   "╲╲╭┛┻┛┻╮╲╲╲╲'╭━╮'"  + "\n" +
                   "▅━╯▋┈▋┈┃╲╲╲╲╲╰╮┃"  + "\n" +
                   "┣━━━━━╯╰━━━━━╮┃┃" + "\n" +
                   "╰━━━━┓┈┈┈┈┈┈┈┗╯┃" + "\n" +
                   "╲╲╲╲╲┃┏┓┏━┳┳┓┏━╯" + "\n" +
                   "╲╲╲╲╲┗┛┗┛╲┗┛┗┛╲╲");
        }
        else {
            switch(option) {
                case 1:
                    System.out.println("Please enter the letter you would like to work back from:");
                    String userInput = cin.next();
                    System.out.println(letters(userInput.charAt(0)));
                    break;
                case 2:
                    System.out.println("Please enter your number:");
                    System.out.println(twos(cin.nextInt()));
                    break;
                case 3:
                    System.out.println("Please enter your number:");
                    System.out.println(powerOf3(cin.nextInt()));
                    break;
                case 4:
                    System.out.println("Please enter your number:");
                    System.out.println(reverse(cin.nextInt()));
                    break;
                case 6:
                    System.out.println("Please enter your number:");
                    base5(cin.nextInt());
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Please enter your number:");
                    printWithCommas(cin.nextInt());
                    System.out.print("\n");
                    break;
            }
            options();
        }
    }
    public static int optionz() {
        int userOption;
        do {
            System.out.println("Please select the method you would like to run");
            System.out.println("1. Lettters" + "\n" +
                    "2. Twos" + "\n" +
                    "3. Power of three" + "\n" +
                    "4. Reverse" + "\n" +
                    "5. Print with commas" + "\n" +
                    "6. Base 5" + "\n" +
                    "0. Exit");
            if ((userOption = cin.nextInt()) < 7)
                return userOption;
            else
                System.out.println("Invalid input, please try again");
        } while (userOption > 0 && userOption < 8);
        return -1;
    }
}