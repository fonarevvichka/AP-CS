// Vichka Fonarev
// F Block
// Lab 12

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lhscompsci on 1/23/17.
 */
public class UnitedStates {
    public static void main(String[] Args) {
        File states = new File("states.txt");
        List<String> statesList = new ArrayList<String>();
        Scanner cin = null;
        Scanner cinTwo = new Scanner(System.in);
        boolean quit = false;
        int counter = 0, insertPosition, duplicate = 0;
        String pWord, cWord;

        try {
            cin = new Scanner(states);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found exception" + ex);
            System.exit(1);
        }

        while (cin.hasNextLine()) {
            if (counter == 0) {
                cWord = cin.nextLine();
                if (cWord.equals(null)) {
                    counter--;
                } else {
                    statesList.add(counter, cin.nextLine());
                }
            } else {
                insertPosition = counter - duplicate;

                cWord = cin.nextLine();
                pWord = statesList.get(insertPosition - 1);

                while (cWord.compareToIgnoreCase(pWord) < 0) {
                    insertPosition--;
                    if (insertPosition == 0)
                        break;
                    pWord = statesList.get(insertPosition - 1);
                }
                if (!isInList(statesList, cWord)) {
                    statesList.add(insertPosition, cWord);
                } else {
                    duplicate++;
                }
            }
            counter++;
        }
        String state = "";
        String userChoice = "";
        while(!quit) {

            System.out.println("\n" + "Choose an option:" + " \n" +
                    "D. Display list " + "\n" +
                    "I. Insert item" + "\n" +
                    "R. Remove item" + "\n" +
                    "S. Save to file" + "\n" +
                    "Q. Quit and don't write" + "\n" +
                    "Selection: ");
            userChoice = cinTwo.next();
            //display menu
            switch(userChoice) {
                case "D":
                    displayList(statesList);
                    break;
                case "I":
                    System.out.println("What would you like to insert");
                    state = cinTwo.next();
                    insertItem(statesList, state);
                    break;
                case "R":
                    System.out.println("What would you like to remove");
                    state = cinTwo.next();
                    removeItem(statesList, state);
                    break;
                case "S":
                    saveList(statesList, states);
                    break;
                case "Q":
                    quit = true;
            }
        }
//        displayList(statesList);
//        insertItem(statesList, "Hawaii");
//        System.out.println("\n");
//        displayList(statesList);
//        System.out.println("\n");
//        removeItem(statesList, "arizasdfona");
//        displayList(statesList);
    }


    public static void insertItem(List<String> statesList, String cWord) {
        int insertPosition = statesList.size();
        if (statesList.size() == 0) {
            statesList.add(0, cWord);
        } else {
            if (!isInList(statesList, cWord)) {
                String pWord = statesList.get(insertPosition - 1);
                if (cWord.compareToIgnoreCase(pWord) != 0) {
                    while (cWord.compareToIgnoreCase(pWord) < 0) {
                        insertPosition--;
                        if (insertPosition == 0)
                            break;
                        pWord = statesList.get(insertPosition - 1);
                    }
                    statesList.add(insertPosition, cWord);
                }
            }
        }
    }

    public static void saveList(List<String> stateList, File statesTxt) {
        File outputFile = statesTxt;
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(outputFile);
        } catch (IOException ex) {
            System.out.println("could not write to file");
        }

        for (String state : stateList) {
            try {
                writer.println(state);
            } catch (Exception x) {
                System.out.println("couldn't write to output file");
            }
        }
        writer.flush();
        writer.close();
    }

    public static void removeItem (List<String> stateList, String state) {
        for(int i = 0; i < stateList.size(); i++) {
            if (isInList(stateList, state)) {
                if(state.equalsIgnoreCase(stateList.get(i))) {
                    stateList.remove(i);
                    break;
                }
            }
        }
    }
    public static boolean isInList(List <String> stateList, String word) {
        for (int i = 0; i < stateList.size(); i++) {
            if(word.equalsIgnoreCase(stateList.get(i)))
                return  true;
        }
        return false;
    }
    public static void displayList(List<String> statesList) {
        for(String state : statesList) {
            System.out.println(state);
        }
    }
}
