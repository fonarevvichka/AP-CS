package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int length = printFile("Cabbages.txt");
        String[] words = new String[length];
        length = readIntoArray("Cabbages.txt", words);
        print(words, length);
    }
    public static int printFile(String fileName) {
        int counter = -1, maxLength = 0;
        String pathname = fileName, word = "", longword = "";
        File file = new File(pathname);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("*** Cannot open " + pathname
                    + " ***");
            System.exit(1);  // quit the program
        }
        while(input.hasNext()) {
            counter++;
            word = input.next();
            if(word.length() > maxLength) {
                maxLength = word.length();
                longword = word;
            }
            System.out.println(counter + ". " + word);
        }
        System.out.println("The longest word in the text is <" + longword + ">");
        return counter;
    }
    public static int readIntoArray(String fileName, String[] words) {
        String pathname = fileName, word = "", longword = "";
        File file = new File(pathname);
        Scanner input = null;
        boolean found = false;
        int length = words.length;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("*** Cannot open " + pathname
                    + " ***");
            System.exit(1);  // quit the program
        }
        for(int i = 0; i < length; i++)
            words[i] = "";
        for (int i = 0; i < length; i++) {
            word = input.next();
            word = word.replaceAll("\\W", "");
            for (int k = 0; k < length; k++) {
                if (word.equals(words[k])) {
                    found = true;
                    length--;
                }
            }
            if(!found) {
                words[i] = word;
            }
            found = false;
        }
        Arrays.sort(words);
        return length;
    }
    public static void print(String[] words, int length) {
        for(int i = 0; i < length; i++) {
                System.out.println(i + " " + words[i]);
        }
    }
}
