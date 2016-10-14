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
            position[1] = 0;
            position[2] = 1;
            position[3] = 1;
        } else if(shootLocation > 9 && 20 > shootLocation) {
            position[0] = 0;
            position[1] = shootLocation - 10;
            position[2] = 0;
            position[3] = 1;
        } else if(shootLocation > 19 && 30 > shootLocation) {
            position[0] = shootLocation - 20;
            position[1] = 9;
            position[2] = 1;
            position[3] = 0;
        } else {
            position[0] = 9;
            position[1] = shootLocation - 30;
            position[2] = 0;
            position[3] = 0;
        }
        return position;
    }
    public static int shootLaser(int shootLocation, char[][] blackBox) {
        int endLocation = 0;
        int[] position = moveLaser(initPositionFinder(shootLocation));

        int xPosition = position[0];
        int yPosition = position[1];
        int vertical = position[2];
        int right = position[3];
        int up = position[3];

        while(xPosition >= 0 && xPosition <= 9 && yPosition >= 0 && yPosition <= 9) {
        //--------------- check --------------------//
            if(blackBox[xPosition][yPosition] == '\\') {
                if(vertical == 1) {
                    if (up == 1) {
                        right = 0;
                        vertical = 0;
                    } else {
                        right = 1;
                        vertical = 0;
                    }
                } else {
                    if (right == 1) {
                        up = 0;
                        vertical = 1;
                    } else {
                        up = 1;
                        vertical = 1;
                    }
                }
            }

            if(blackBox[xPosition][yPosition] == '/') {
                if(vertical == 1) {
                    if (up == 1) {
                        right = 1;
                        vertical = 0;
                    } else {
                        right = 0;
                        vertical = 0;
                    }
                } else {
                    if (right == 1) {
                        up = 1;
                        vertical = 1;
                    } else {
                        up = 0;
                        vertical = 1;
                    }
                }
            }
            position[2] = vertical;
            position[3] = right;

        //--------------- check --------------------//
            moveLaser(position);

            xPosition = position[0];
            yPosition = position[1];
            vertical = position[2];
            right = position[3];
            up = position[3];
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
        int sign = -1;

        int xPosition = position[0];
        int yPosition = position[1];
        int vertical = position[2]; // 0 means horizontal, 1 is vertical;
        int up = position[3]; // 0 means down, 1 means up
        int right = position[3]; // 0 means left, 1 means right

        if (up != 0)
            sign = 1;

        //--------------- laser move ---------------//
        if (vertical != 0) {
            yPosition += (1 * sign);
        } else {
            xPosition += (1 * sign);
           System.out.println("xPosition - " + xPosition);
        }
        //--------------- laser move ---------------//
        position[0] = xPosition;
        position[1] = yPosition;

        System.out.print("vertical- " + vertical);
        System.out.print(" | up - " + up);
        System.out.print(" | right - " + right);
        System.out.print("\n");
        return position;
    }
}
