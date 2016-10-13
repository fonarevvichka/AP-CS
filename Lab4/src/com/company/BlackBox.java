package com.company;

import java.util.Arrays;
import java.util.Random;

public class BlackBox {

    public static void main(String[] args) {
        System.out.println(Arrays.(arrayCreate());
    }
    public static char[][] arrayCreate() {
        char blackBox[][] = new char[10][10];

        for(int i = 0; i < 10; i++)
            generateMirror(blackBox);

        return blackBox;
    }
    public static char[][] generateMirror(char[][] blackBox) {
        Random rand = new Random();
        int mirrorLocationX = rand.nextInt(10);
        int mirrorLocationY = rand.nextInt(10);
        int mirrorType = rand.nextInt(2);

        if (blackBox[mirrorLocationX][mirrorLocationY] ==  '/' || blackBox[mirrorLocationX][mirrorLocationY] == '\\')
            generateMirror(blackBox);
        else {
            if (mirrorType == 1)
                blackBox[mirrorLocationX][mirrorLocationY] = '/';
            else
                blackBox[mirrorLocationX][mirrorLocationY] = '\\';
        }
        return blackBox;
    }

}
