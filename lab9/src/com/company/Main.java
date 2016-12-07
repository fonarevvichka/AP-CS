package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    public static void readFile(String fileName) {
        String pathname = fileName;
        File file = new File(pathname);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("*** Cannot open " + pathname
                    + " ***");
            System.exit(1);  // quit the program
        }
        findWordCount(input);
    }
    public static void inputIntoArray(Scanner input, String[] words) {
        for(int i = 0; i < words.length; i++) {
            words[i] = input.next();
        }
    }
    public static void findWordCount(Scanner input) {
        int counter = 0;
        while(input.hasNext()) {
            counter++;
        }
        String[] words = new String[counter];
        inputIntoArray(input, words);
    }
    public static void print(String[] words) {
        for(int i = 0; i < words.length; i++) {
        }
    }
}
