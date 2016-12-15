// Vichka Fonarev
//12/9/16
//F Block AP-CS


package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int length = displayFile("Cabbages.txt");
        String[] words = new String[length];
        words = readIntoArray("Cabbages.txt", words);
        print(words);

        System.out.println("What word would you like to GREP? ");
        String word = cin.next();
        grep(word);
        System.out.println("What word would you like to GREP? ");
        word = cin.next();
        grep(word);
    }
    public static int displayFile(String fileName) {
        int counter = 0;
        String  word = "", max = "";
        File file = new File(fileName);
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("*** Cannot open " + fileName
                    + " ***");
            System.exit(1);  // quit the program
        }
        while(input.hasNext()) {
            counter++;
            word = input.next();
            if(word.length() > max.length()) {
                max = word;
            }
            System.out.println(counter + ". " + word);
        }
        System.out.println("The longest word in the text is <" + max + ">");
        return counter;
    }
    public static String[] readIntoArray(String fileName, String[] words) {
        String word = "";
        File file = new File(fileName);
        Scanner input = null;

        int length = words.length;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            System.out.println("*** Cannot open " + fileName
                    + " ***");
            System.exit(1);  // quit the program
        }
        for(int i = 0; i < length; i++){
            words[i] = "";
        }
        for (int i = 0; i < length; i++) {
            word = input.next();
            word = word.replaceAll("\\W", "");
            word = word.toLowerCase();
            words[i] = word;
        }


        Arrays.sort(words);

        int OG = 0;


        for(int n = 0; n < words.length; n++){
            for(int k = n+1; k < words.length; k++){
                if (words[k].equals(words[n])){
                    words[k] = "WE BE BUGGIN";

                }
            }
        }

        for(int n = 0; n < words.length; n++){
            if(!words[n].equals("WE BE BUGGIN")){
                OG++;
            }
        }

        String[] ret = new String[OG];
        int position = 0;

        for(int k = 0; k< words.length; k++){
            if(!words[k].equals("WE BE BUGGIN")){
                ret[position] = words[k];
                position++;
            }
        }

        return ret;
    }
    public static void print(String[] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.println(i + " " + list[i]);
        }
    }
    public static void grep(String word) {
        String cabbage = "Cabbages.txt";
        File file = new File(cabbage);
        Scanner input = null;
        try{
            input = new Scanner(file);
        }
        catch(FileNotFoundException ex){
            System.out.println("*** Cannot open " + cabbage + " ***");
            System.exit(1);
        }

        char[] characters = word.toCharArray();
        System.out.println("Grepping for the word " + "<" + word + ">");
        String line = "";
        boolean found = false;
        int onLine = 0;
        int lineNumber = 0;
        while(input.hasNext()){
            line = input.nextLine();
            char[] characterLine = line.toCharArray();
            for(int i = 0; i < characterLine.length; i++){
                //System.out.println("test");
                if(characters[0] == characterLine[i] && characterLine.length > i + characters.length){
                    found = true;
                    for(int k = 0; k < characters.length; k++){
                        if(characters[k] != characterLine[i+k]){
                           found = false;
                        }
                    }
                    if(found){
                        onLine++;
                        System.out.print("Line " + lineNumber + " ");
                        for(int k = 0; k < characterLine.length; k++){
                            if(k == i){
                                System.out.print("<");
                            }
                            if(k == i + characters.length){
                                System.out.print(">");
                            }
                            System.out.print(characterLine[k]);
                        }
                        System.out.println();
                    }
                }
            }
            lineNumber++;
        }
        if(onLine == 0){
            System.out.println("The phrase/word searched for does not appear in any line");
        }
    }
}
