package com.company;

import java.util.Scanner;

public class BaseChange {

    public static void main(String[] args) {

        public class BaseChange {
            Scanner cin = new Scanner(System.in);

            public static void main(String[] args) {
                System.out.println("Please enter your desired base:");
            }


            public static int addition(int num1, int num2, int base) {
                int finalNum = 0, carryOver = 0, loopLength;
                int numberOfDigits1 = countDigits(num1);
                int numberOfDigits2 = countDigits(num2);

                if (numberOfDigits1 > numberOfDigits2)
                    loopLength = numberOfDigits1;
                else
                    loopLength = numberOfDigits2;

                for(int i = 1; i <= loopLength; i++) {

                    carryOver = 0;
                    int temp1 = findDigit(num1, i);
                    int temp2 = findDigit(num2, i);
//			finalNum += base * ((temp1 + temp2)/base);
//			finalNum += carryOver * power(base, i);
                }
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
            public static int countDigits(double num) {
                int numberLength = 1;
                int numCopy = (int) num;

                while((numCopy /= 10) != 0)
                    numberLength++;

//        System.out.println(numberLength);
                return numberLength;
            }
        }

    }
}
