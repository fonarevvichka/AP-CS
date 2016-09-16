//package com.company;

import java.util.Random;
import java.util.Scanner;

//Vichka Fonarev
//F Block
//Lab 1: Bridgewalk

public class Bridgewalk {
    static Scanner userInput = new Scanner(System.in);
    
    public static void main(String[] args) {
        printBridge(5, 3);

        System.out.println("Length     Average Number of Steps");
        for (int i = 5; i < 22; i+= 2) {
            System.out.println(i + "                    "  + averageSteps(i, (i/2) + 1));
        }

        int smallest;
        int greatest;
        int steps = 0;
        int z = 0;
        int bridgeLength = getInput();
        int position = (bridgeLength / 2) + 1;
        int positionCopy = position;
        //		printBridge(bridgeLength, position);



        do {
            z = options();
            switch (z) {
                case 1:
                    printBridge(bridgeLength, position);
                    //                    position = positionCopy;
                    break;
                case 2:
                    System.out.println(averageSteps(bridgeLength, position));
                    //                    position = positionCopy;
                    break;
                case 3:
                    System.out.println("Please, enter the number of trials you would like to run");
                    //        Scanner cin = new Scanner(System.in);
                    int numberOfTrials = userInput.nextInt();
                    System.out.println(userTrials(bridgeLength, position, numberOfTrials));
                    //                    position = positionCopy;
                    break;
                case 4:
                    smallest = 666666666;
                    greatest = 0;
                    for (int i = 0; i < 50; i++) {
                        while (position > 0 && position < bridgeLength + 1) {
                            position = move(position);
                            steps++;
                        }
                        greatest = greatest(steps, greatest);
                        smallest = smallest(steps, smallest);
                        position = positionCopy;
                        //                		greatest = greatest(steps, greatest);
                        //                		smallest = smallest(steps, smallest);
                        steps = 0;

                    }
                    System.out.println("greatest: " + greatest);
                    System.out.println("smallest: " + smallest);

                    break;
            }
        } while (z != 0);
    }
    public static int getInput() {
        int bridgeLength;
        
        //        Scanner userInput = new Scanner(System.in);
        
        System.out.print("Please enter and odd number greater than 3 for your bridge length: ");
        bridgeLength = userInput.nextInt();
        while (bridgeLength % 2 == 0 || bridgeLength <= 3) {
            System.out.println("Invalid bridge length, please try again");
            bridgeLength = userInput.nextInt();
        }
        //		System.out.println(bridgeLength);
        //        userInput.close();
        return bridgeLength;
    }
    
    public static int options() {
        int userOptions = 0;
        
        do {
            System.out.println("Please enter the desired option");
            System.out.println("1. graphic bridge for each step" + "\n" +
                               "2. average number of steps"  + "\n" +
                               "3. total number of steps for x trials" + "\n" +
                               "4. largest and smallest number of steps required to fall off" + "\n" +
                               "0. Enter 0 to exit");
            
            return userOptions = userInput.nextInt();
            
        } while (userOptions > 0 && userOptions < 5);
        
        
        //        if (userOptions > 0 && userOptions < 5) {
        ////        	userInput.close();
        //        	return userOptions;
        //        }
        //        else if (userOptions == 0) {
        //            System.out.println("Program Terminated");
        ////            userInput.close();
        //            return 0;
        //        }
        //        else {
        //            System.out.println("Invalid input try again");
        ////            userInput.close();
        //            options();
        //        }
        //        return -1;
    }
    
    public static void printBridge(int bridgeLength, int position) {
        //		System.out.println(bridgeLength);
        int count = 0;
        while (position > 0 && position < bridgeLength + 1) {
            count++;
            for(int j = 0; j <= bridgeLength + 1; j++) {
                //				System.out.println("looping");
                if (j == 0) {
                    if (count > 9)
                        System.out.print("Step " + count + ":    ");
                    else if (count > 99)
                        System.out.print("Step " + count + ":   ");
                    else
                        System.out.print("Step " + count + ":     ");
                    System.out.print("|");
                }
                else if (bridgeLength + 1 == j)
                    System.out.println("|");
                else if (j == position)
                    System.out.print("*");
                else
                    System.out.print("-");
            }
            position = move(position);
            
        }
        //		boolean done = false;
        //		printBridge(bridgeLength, move(bridgeLength, position));
    }
    public static int move(int position) {
        Random rand = new Random();
        int move = rand.nextInt(2);
        
        if (move == 0)
            position += (-1);
        else
            position += (1);
        
        return position;
    }
    public static double averageSteps(int bridgeLength, int position) {
        double steps = 0;
        int ogPosition = position;
        for (int i = 0; i < 50; i++) {

            while (position > 0 && position < bridgeLength + 1) { // Do i need to add and equal too?
                position = move(position);
                //                System.out.println(position + " - " + steps);
                steps++;
            }
            position = ogPosition;
        }
        return (steps / 50);
    }
    
    public static int greatest(int steps, int greatest) {
        //        System.out.println("steps - " + steps);
        if (greatest < steps) {
            return steps;
        }
        else if (steps < greatest){
            return greatest;
        }
        else{
            return steps;
        }
    }
    
    public static int smallest(int steps, int smallest) {
        if (smallest < steps) {
            return smallest;
        }
        else if (steps < smallest){
            return steps;
        }
        else{
            return steps;
        }
    }
    
    public static int userTrials(int bridgeLength, int position, int numberOfTrials) {
        int steps = 0;
        int totalSteps = 0;
        int positionCopy = position;

        for (int i = 0; i < numberOfTrials; i++) {
            while (position > 0 && position < bridgeLength + 1) {
                position = move(position);
                steps++;
                //                System.out.println(steps);
            }
            position = positionCopy;
            totalSteps += steps;
            steps = 0;
        }
        return totalSteps;
    }
}
