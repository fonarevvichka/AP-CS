// Vichka Fonarev
// F Block
// Lab 12

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lhscompsci on 1/23/17.
 */
public class UnitedStates {
    public static void main(String[] Args) {
        File states = new File("states.txt");
        ArrayList<String> statesList = new ArrayList<String>();
        Scanner cin = null;
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
        displayList(statesList);
        insertItem(statesList, "Hawaii");
//        System.out.println("\n");
//        displayList(statesList);
//        System.out.println("\n");
//        removeItem(statesList, "arizasdfona");
        displayList(statesList);
    }


    public static void insertItem(ArrayList<String> statesList, String cWord) {
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

    public void saveList(ArrayList<String> stateList) {
        File outputFile = new File("output.txt");
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
            writer.print("\n");
        }
        writer.flush();
    }

    public static void removeItem (ArrayList<String> stateList, String state) {
        for(int i = 0; i < stateList.size(); i++) {
            if (isInList(stateList, state)) {
                stateList.remove(i);
            }
        }
    }
    public static boolean isInList(ArrayList <String> stateList, String word) {
        for (int i = 0; i < stateList.size(); i++) {
            if(word.equalsIgnoreCase(stateList.get(i)))
                return  true;
        }
        return false;
    }
    public static void displayList(ArrayList<String> statesList) {
        for(String state : statesList) {
            System.out.println(state);
        }
    }
}
