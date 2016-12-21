package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String pathname = "Cipher.txt";
        String pathname2 = "Replace.txt";
        File file = new File(pathname);
        File file2 = new File(pathname2);
        Scanner reader = null;
        Scanner readerTwo = null;
        Scanner readerThree = null;

        //------------------ Open File ----------------------//
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException ex){
            System.out.println("could not open " + pathname);
            System.exit(1);
        }

        try {
            readerTwo = new Scanner(file2);
        } catch (FileNotFoundException ex){
            System.out.println("could not open " + pathname2);
            System.exit(1);
        }

        try {
            readerThree = new Scanner(file);
        } catch (FileNotFoundException ex){
            System.out.println("could not open " + pathname);
            System.exit(1);
        }

        //------------------ Open File ----------------------//

        //------------------ Initialize Array ---------------//
        Record[] letters = new Record[26];
        for (int i = 65; i < 91; i++)
            letters[i-65] = new Record(0, (char) i, (char) i);
        //------------------ Initialize Array ---------------//

        //------------------ Count Frequencies --------------//
        while(reader.hasNext()) {
            String cWord = reader.next();
            cWord.toUpperCase();
            for(int k = 0; k < cWord.length(); k++) {
                if (cWord.charAt(k) > 64 && cWord.charAt(k) < 91) {
                    letters[cWord.charAt(k) - 65].incrementFrequency();
                }
            }
        }
        //------------------ Count Frequencies --------------//

        //------------------ Print Frequencies --------------//
         for (int i = 0; i < 26; i++)
            System.out.println(letters[i].getLetter() + " has a frequency of " + letters[i].getFrequency());
        //------------------ Print Frequencies --------------//
        System.out.println("\n");
        //------------------ Sort and Print------------------//
        Arrays.sort(letters);
        for (int i = 0; i < 26; i++)
            System.out.println(letters[i].getLetter() + " has a frequency of " + letters[i].getFrequency());
        //------------------ Sort and Print------------------//


        //------------ Char array from Replace.txt ----------//
        char[] replace = new char[26];
        for(int k = 0; k < 26; k++) {
            String tempWord = readerTwo.next();
            replace[k] = tempWord.charAt(0);
        }
        //------------ Char array from Replace.txt ----------//

        //------------------ Set Associated Letter ----------//
        for (int i = 0; i < 26; i++) {
            letters[i].setAssociatedLetter(replace[i]);
        }
        //------------------ Set Associated Letter ----------//
            for (int i = 0; i < 26; i++) {
                System.out.println(letters[i].getLetter() + " has a frequency of " + letters[i].getFrequency() + " and is associted to " + letters[i].getAssociatedLetter() + " i is " + i);
            }
//        System.out.print(letters[23].getAssociatedLetter());
        //------------------ Print Decoded Message ----------//

        while(readerThree.hasNext()) {
            String cWord = readerThree.next();
            cWord.toUpperCase();
            for(int k = 0; k < cWord.length(); k++) {
                if (cWord.charAt(k) > 64 && cWord.charAt(k) < 91) {
                    for(int i = 0; i < 26; i++) {
                        if (letters[i].getLetter() == cWord.charAt(k)) {
                            System.out.print(letters[i].getAssociatedLetter());
                        }
                    }
                } else {
                    System.out.print(cWord.charAt(k));
                }
            }
        }
        //------------------ Print Decoded Message ----------//
    }
}
