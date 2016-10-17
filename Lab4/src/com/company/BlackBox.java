// Vichka Fonarev
// F Block AP-CS
// Lab 4 BlackBox

package com.company;

import sun.awt.ConstrainableGraphics;

import java.util.Random;
import java.util.Scanner;

public class BlackBox {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char blackBox[][] = arrayCreate();
        int position[] = initPositionFinder(0);
        boolean stop = false;
        int trialNum = 0, shotNumber = 0, guessNumber = 0, mirrorsCorrect = 0;
//        printArray(blackBox);
        while(!stop) {
            System.out.println("Trial Number: " + trialNum++ + "\n" +
                               "Number of shots: " + shotNumber + "\n" +
                               "Number of guesses: " + guessNumber);
            printArray(blackBox);
            int option = menu(cin);
            switch (option) {
                case (1):
                    laserShootCaller(cin, position, blackBox);
                    shotNumber++;
                    break;
                case (2):
                    mirrorsCorrect = mirrorGuess(cin, position, blackBox, mirrorsCorrect);
                    guessNumber++;
                    if(mirrorsCorrect > 9) {
                        System.out.println("That's its, you finished, you can go outside now" );
                        stop = true;
                    }
                    break;
                case(4):
                   System.out.println("How clever: ");
                    guessNumber = 0;
                    shotNumber = 0;
                    trialNum = 0;
                    cheatDisplay(blackBox);
                    break;
                case (0):
                    stop = true;
                    System.out.println("The black box looked like this: ");
                    cheatDisplay(blackBox);
                    break;
           }
            if(option > 4){
               System.out.println("Invalid menu option, please try again");
                trialNum--;
            }
       }
    }
    public static int[] initPositionFinder(int shootLocation) {
        int[] position = new int[3];
        
        if(shootLocation < 10) {
            position[1] = shootLocation;
            position[0] = 9;
            position[2] = 3;
        } else if(shootLocation > 9 && 20 > shootLocation) {
            position[1] = 0;
            position[0] = 19 - shootLocation;
            position[2] = 0;
        } else if(shootLocation > 19 && 30 > shootLocation) {
            position[1] = shootLocation - 20;
            position[0] = 0;
            position[2] = 1;
        } else {
            position[1] = 9;
            position[0] = shootLocation - 30;
            position[2] = 2;
        }
        return position;
    }
    public static int shootLaser(char[][] blackBox, int[] position) {
        int yPosition = position[0];
        int xPosition = position[1];
        if(xPosition >= 0 && xPosition <= 9 && yPosition >= 0 && yPosition <= 9) {
            //--------------- check --------------------//
            if (blackBox[yPosition][xPosition] == '2' || blackBox[yPosition][xPosition] == '4')
                position[2] = backSlash(position[2]);
            if (blackBox[yPosition][xPosition] == '1' ||blackBox[yPosition][xPosition] == '3')
                position[2] = forwardSlash(position[2]);
            //--------------- check --------------------//
            position = moveLaser(position);
            yPosition = position[0];
            xPosition = position[1];

            return shootLaser(blackBox, position); // can i just get rid of the return part, and just call it again, is this actually recursive
        }
        return finalPosition(position);
    }
    public static char[][] arrayCreate() {
        char blackBox[][] = new char[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                blackBox[j][i] = '0';
            }
        }
        for (int i = 0; i < 10; i++)
            generateMirror(blackBox);
        return blackBox;
    }
    public static char[][] generateMirror(char[][] blackBox) {
        Random rand = new Random();
        int mirrorLocationX = rand.nextInt(10);
        int mirrorLocationY = rand.nextInt(10);
        int mirrorType = rand.nextInt(2);

        if (blackBox[mirrorLocationY][mirrorLocationX] == '1' || blackBox[mirrorLocationY][mirrorLocationX] == '2')
            generateMirror(blackBox);
        else {
            if (mirrorType == 1) {
                blackBox[mirrorLocationY][mirrorLocationX] = '1';
//                System.out.println(mirrorLocationX + " - x | y - " + mirrorLocationY);
            }
            else{
                blackBox[mirrorLocationY][mirrorLocationX] = '2';
//                System.out.println(mirrorLocationX + " - x | y - " + mirrorLocationY);
            }
        }
        return blackBox;
    }
    public static void printArray(char[][] blackBox) {

//------------ top row numbers ---------------//
        System.out.print("   ");
        for (int i = 20; i < 30; i++)
            System.out.print(i);
        System.out.print("\n");
//------------ top row numbers ---------------//

//-------------- array -----------------------//
        for (int i = 0; i < 10; i++) {
            System.out.print(19 - i + " ");
            for (int j = 0; j < 10; j++) {
//                System.out.print(blackBox[i][j] + " ");
                switch(blackBox[i][j]) {
                    case('0'):
                    case('1'):
                    case('2'):
                        System.out.print('.' + " ");
                        break;
                    case('3'):
                        System.out.print('/' + " ");
                        break;
                    case('4'):
                        System.out.print('\\' + " ");
                        break;
                }
            }
            System.out.print(30 + i + " ");
            System.out.print("\n");
        }
//-------------- array -----------------------//

//------------ bottom row numbers -------------//
        System.out.print("   ");
        for (int i = 0; i < 10; i++)
            System.out.print(i + " ");
        System.out.print("\n");

//------------ bottom row numers -------------//
    }
    public static int[] moveLaser(int[] position) {
        int yPosition = position[0];
        int xPosition = position[1];
        int direction = position[2]; // 0 - right, 1 -  down, 2 - left, 3 - up;

        //--------------- laser move ---------------//
        switch(direction) {
            case(0):
                xPosition++;
                break;
            case(1):
                yPosition++;
                break;
            case(2):
                xPosition--;
                break;
            case(3):
                yPosition--;
                break;
        }
    //--------------- laser move ---------------//
        position[0] = yPosition;
        position[1] = xPosition;

//        System.out.print("\n");
        return position;
    }
    public static int backSlash(int direction) {
        switch(direction) {
            case(0):
                direction = 1;
                break;
            case(1):
                direction = 0;
                break;
            case(2):
                direction = 3;
                break;
            case(3):
                direction = 2;
                break;
        }
        return direction;
    }
    public static int forwardSlash(int direction) {
        switch(direction) {
            case(0):
                direction = 3;
                break;
            case(1):
                direction = 2;
                break;
            case(2):
                direction = 1;
                break;
            case(3):
                direction = 0;
                break;
        }
        return direction;
    }
    public static int finalPosition(int[] position) {
        int xPosition = position[1];
        int yPosition = position[0];
        int direction = position[2];
        int finalNum = 0;

        switch(direction) {
            case(0):
                finalNum = yPosition + 30;
                break;
            case(1):
                finalNum = xPosition;
                break;
            case(2):
               finalNum = 19 - yPosition;
                break;
            case(3):
                finalNum = xPosition + 20;
                break;
        }
        return finalNum;
    }
    public static int menu(Scanner cin) {
        System.out.println("(1) Shoot a laser" + "\n" +
                          "(2) Guess at a mirror location" + "\n" +
                          "(0) Quit the game" + "\n");
        System.out.println("Enter choice: ");
        return cin.nextInt();
    }
    public static boolean locationChecker(char[][] blackBox, int[] position) {
        char toCompare = blackBox[position[0]][position[1]];
        if (toCompare == '1') {
            blackBox[position[0]][position[1]] = '3';
            return true;
        }
        else if(toCompare == '2') {
            blackBox[position[0]][position[1]] = '4';
            return true;
        }
        return false;
    }
    public static int mirrorGuess(Scanner cin, int[] position, char [][] blackBox, int mirrorsCorrect) {
        System.out.println("Please enter the x coordinate of your guess: ");
        position[1] = cin.nextInt();
        if((position[1] > -1 && position[1] < 10) || (position[1] > 19 && position[1] < 30)) {
            if (position[1] > 19)
                position[1] = position[1] - 20;
            System.out.println("Please enter the y coordinate of your guess: ");
            position[0] = cin.nextInt();
            if ((position[0] > 9 && position[0] < 20) || (position[0] > 29 && position[0] < 40)) {
                if (position[0] > 29)
                    position[0] = position[0] - 30;
                else
                    position[0] = 19 - position[0];
                //--------------- checking mirror guess ----------------//
                if (locationChecker(blackBox, position)) {
                    System.out.println("Your guess was correct." );
                    mirrorsCorrect++;
            } else
                    System.out.println("Your guess was incorrect.");
                //--------------- checking mirror guess ----------------//
            } else {
                System.out.println("Invalid Y input, please try again");
                mirrorGuess(cin, position, blackBox, mirrorsCorrect);
            } } else{
                System.out.println("Invalid X input, please try again");
                mirrorGuess(cin, position, blackBox, mirrorsCorrect);
            }
        return mirrorsCorrect;
    }
    public static void laserShootCaller(Scanner cin, int[] position, char[][] blackBox) {
        System.out.println("Please enter the number you would like to shoot from: ");
        int laserOrigin = cin.nextInt();
        if (laserOrigin > -1 && 40 > laserOrigin) {
            position = initPositionFinder(laserOrigin);
            System.out.println("The laser exited at: " + shootLaser(blackBox, position) + "\n");
        } else {
           System.out.println("Laser origin out of range, please try again.");
            laserShootCaller(cin, position, blackBox);
        }
    }
    public static void cheatDisplay(char[][] blackBox) {

//------------ top row numbers ---------------//
        System.out.print("   ");
        for (int i = 20; i < 30; i++)
            System.out.print(i);
        System.out.print("\n");
//------------ top row numbers ---------------//

//-------------- array -----------------------//
        for (int i = 0; i < 10; i++) {
            System.out.print(19 - i + " ");
            for (int j = 0; j < 10; j++) {
//                System.out.print(blackBox[i][j] + " ");
                switch(blackBox[i][j]) {
                    case('0'):
                        System.out.print('.' + " ");
                        break;
                    case('1'):
                        System.out.print('/' + " ");
                        break;
                    case('2'):
                        System.out.print('\\' + " ");
                        break;
                    case('3'):
                        System.out.print('/' + " ");
                        break;
                    case('4'):
                        System.out.print('\\' + " ");
                        break;
                }
            }
            System.out.print(30 + i + " ");
            System.out.print("\n");
        }
//-------------- array -----------------------//

//------------ bottom row numbers -------------//
        System.out.print("   ");
        for (int i = 0; i < 10; i++)
            System.out.print(i + " ");
        System.out.print("\n");
//------------ bottom row numers -------------//
    }
}
