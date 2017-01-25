import com.sun.tools.hat.internal.model.StackTrace;
import com.sun.tools.javac.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lhscompsci on 1/23/17.
 */
public class UnitedStates{
    public static void main(String[] Args){
        File states = new File("states.txt");
        ArrayList<String> statesList = new ArrayList<String>();
        Scanner cin = null;
        int counter = 0, insertPosition;
        String pWord, cWord;

        try {
            cin =  new Scanner(states);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found exception" + ex);
            System.exit(1);
        }

        while (cin.hasNextLine()) {
           if (counter == 0) {
               statesList.add(counter, cin.next());
           } else {
               insertPosition = counter;

               cWord = cin.nextLine();
               if(insertPosition == 1) {
                   pWord = "a";
//                   System.out.println(pWord);
               } else {
                   pWord = statesList.get(insertPosition-1);
               }

               System.out.println(cWord.compareToIgnoreCase(pWord) > 0);
               while (cWord.compareToIgnoreCase(pWord) > 0) {
                   System.out.println(pWord);
                   System.out.println(cWord);
//                   System.out.println(insertPosition);
                   insertPosition--;

                   pWord = statesList.get(insertPosition-1);
               }
               statesList.add(insertPosition, cWord);
           }
           counter++;
        }



        for (int i = 0; i < statesList.size(); i++) {
            System.out.println(statesList.get(i) + " " + i);
        }
    }
}
