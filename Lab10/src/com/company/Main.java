package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String pathname = "Cipher.txt";
        File file = new File(pathname);
        Scanner reader = null;

        //------------------ Open File ----------------------//
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException ex){
            System.out.println("could not open " + pathname);
            System.exit(1);
        }

        //------------------ Open File ----------------------//

        //------------------ Initialize Array ---------------//
        Record[] letters = new Record[26];
        for (int i = 65; i < 91; i++)
            letters[i-65] = new Record(0, (char) i);
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
         for (int i = 0; i < 26; i++) {
            System.out.println(letters[i].getLetter() + " has a frequency of " + letters[i].getFrequency());
        }
        //------------------ Print Frequencies --------------//
        Record.sort()
    }
}
