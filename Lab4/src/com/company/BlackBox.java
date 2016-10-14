package com.company;

import java.util.Random;

public class BlackBox {

    public static void main(String[] args) {
        char array[][] = arrayCreate();
        printArray(array);

       shootLaser(14, array);
    }
    public static int[] initPositionFinder(int shootLocation) {
        int[] position = new int[4];
        
        if(shootLocation < 10) {
            position[0] = shootLocation;
            position[1] = 9;
            position[2] = 3;
        } else if(shootLocation > 9 && 20 > shootLocation) {
            position[0] = 0;
            position[1] = 10 - (19 - shootLocation);
            position[2] = 0;
        } else if(shootLocation > 19 && 30 > shootLocation) {
            position[0] = shootLocation - 20;
            position[1] = 3;
            position[2] = 1;
        } else {
            position[0] = 9;
            position[1] = shootLocation - 30;
            position[2] = 2;
        }
        return position;
    }
    public static int shootLaser(int shootLocation, char[][] blackBox) {
        int endLocation = 0;
        int[] position = initPositionFinder(shootLocation);

        System.out.println(position[0]);
        System.out.println(position[1]);
        int xPosition = position[0];
        int yPosition = position[1];
        int direction = position[2];

//        blackBox[0][4] = '\\';
        while(xPosition >= 0 && xPosition <= 9 && yPosition >= 0 && yPosition <= 9) {
            System.out.println(blackBox[xPosition][yPosition]);
            //--------------- check --------------------//
            if (blackBox[xPosition][yPosition] == '\\') {
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

            }

            if (blackBox[xPosition][yPosition] == '/') {
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
            }
                //--------------- check --------------------//
                moveLaser(position);

                xPosition = position[0];
                yPosition = position[1];
        }
            System.out.println(xPosition);
            System.out.println(yPosition);
            return endLocation;
    }
    public static char[][] arrayCreate() {
        char blackBox[][] = new char[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                blackBox[i][j] = '.';
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

        if (blackBox[mirrorLocationX][mirrorLocationY] == '/' || blackBox[mirrorLocationX][mirrorLocationY] == '\\')
            generateMirror(blackBox);
        else {
            if (mirrorType == 1)
                blackBox[mirrorLocationX][mirrorLocationY] = '/';
            else
                blackBox[mirrorLocationX][mirrorLocationY] = '\\';
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
                System.out.print(blackBox[i][j] + " ");
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
        int xPosition = position[0];
        int yPosition = position[1];
        int direction = position[2]; // 0 - right, 1 -  down, 2 - left, 3 - up;

        //--------------- laser move ---------------//
        switch(direction) {
            case(0):
                xPosition++;
                break;
            case(1):
                yPosition--;
                break;
            case(2):
                xPosition--;
                break;
            case(3):
                yPosition++;
                break;
        }

        //--------------- laser move ---------------//
        position[0] = xPosition;
        position[1] = yPosition;

//        System.out.print("\n");
        return position;
    }
}
