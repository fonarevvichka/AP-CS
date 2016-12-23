package com.company;

import java.io.*;
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
        Scanner readerFour = null;
        BufferedWriter output = null;
        Scanner cin = new Scanner(System.in);
        int[] duplicates = new int[26];
        int duplicateNumber = 0, previousNum;
        String replacementChoice = "";

        //------------------ Open File ----------------------//
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("could not open " + pathname);
            System.exit(1);
        }

        try {
            readerTwo = new Scanner(file2);
        } catch (FileNotFoundException ex) {
            System.out.println("could not open " + pathname2);
            System.exit(1);
        }

        try {
            readerThree = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("could not open " + pathname);
            System.exit(1);
        }
        try {
            readerFour = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("could not open " + pathname);
            System.exit(1);
        }
        //------------------ Open File ----------------------//

        //------------------ Initialize Array ---------------//
        Record[] letters = new Record[26];
        for (int i = 65; i < 91; i++)
            letters[i - 65] = new Record(0, (char) i, (char) i);
        //------------------ Initialize Array ---------------//

        //------------------ Count Frequencies --------------//
        while (reader.hasNext()) {
            String cWord = reader.next();
            cWord.toUpperCase();
            for (int k = 0; k < cWord.length(); k++) {
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
        for (int k = 0; k < 26; k++) {
            String tempWord = readerTwo.next();
            replace[k] = tempWord.charAt(0);
        }
        //------------ Char array from Replace.txt ----------//

        //------------------ Set Associated Letter ----------//
        for (int i = 0; i < 26; i++) {
            letters[i].setAssociatedLetter(replace[i]);
        }
        //------------------ Set Associated Letter ----------//

        //------------------ Print Decoded Message ----------//

        while (readerThree.hasNext()) {
            String cWord = readerThree.next();
            cWord.toUpperCase();
            for (int k = 0; k < cWord.length(); k++) {
                if (cWord.charAt(k) > 64 && cWord.charAt(k) < 91) {
                    for (int i = 0; i < 26; i++) {
                        if (letters[i].getLetter() == cWord.charAt(k)) {
                            System.out.print(letters[i].getAssociatedLetter());
                        }
                    }
                } else {
                    System.out.print(cWord.charAt(k));
                }
            }
            System.out.print(" ");
        }
        //------------------ Print Decoded Message ----------//

        System.out.println("\n");


        //----------------- Figure out duplicates -----------//


        for (int i = 1; i < 26; i++) {
            previousNum = letters[i - 1].getFrequency();
            if (previousNum == letters[i].getFrequency()) {
                duplicates[duplicateNumber] = i - 1;
                duplicateNumber++;
            }
        }
        //----------------- Figure out duplicates -----------//

        //------------------ Print out duplicates -----------//

        System.out.println("There are " + duplicateNumber + " duplicates");

        for (int i = 0; i < duplicateNumber; i++) {
            System.out.println("Letters " + letters[duplicates[i]].getLetter() + " and " +
                    letters[duplicates[i] + 1] + " are duplicates, your choices are: " +
                    letters[duplicates[i]].getAssociatedLetter() + " or " +
                    letters[duplicates[i] + 1].getAssociatedLetter() +
                    " respectively, would you like to switch them (y/n)? ");

            replacementChoice = cin.next();
            if (replacementChoice.charAt(0) == 'y') {
                char temp = letters[duplicates[i]].getAssociatedLetter();
                letters[duplicates[i]].setAssociatedLetter(letters[duplicates[i] + 1].getAssociatedLetter());
                letters[duplicates[i] + 1].setAssociatedLetter(temp);
            }
        }
        //------------------ Print out duplicates -----------//

        //------------------ Open a new file ----------------//
        try {
            File outputFile = new File("output.txt");
            output = new BufferedWriter(new FileWriter(outputFile));
        } catch (IOException e) {
            System.out.println("Unable to create file 'output.txt'");
        }
        //------------------ Open a new file ----------------//
        while(readerFour.hasNext()) {
            String cWord = readerFour.next();
            cWord.toUpperCase();
            for(int k = 0; k < cWord.length(); k++) {
                if (cWord.charAt(k) > 64 && cWord.charAt(k) < 91) {
                    for(int i = 0; i < 26; i++) {
                        if (letters[i].getLetter() == cWord.charAt(k)) {
                            try {
//                                System.out.print(letters[i].getAssociatedLetter());
                                output.write(letters[i].getAssociatedLetter());
                            }
                            catch (IOException x) {
                                System.out.println("couldn't write to output file");
                            }
                        }
                    }
                } else {
                    try {
                        output.write(cWord.charAt(k));
                    }
                            catch (IOException x) {
                        System.out.println("couldn't write to output file");
                    }

                }
            }
            try {
                output.write(" ");
            }
            catch (IOException x) {
                System.out.println("couldn't write to output file");
            }

        }
    }
}
