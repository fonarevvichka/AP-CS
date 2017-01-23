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
        int counter = 0, compareArea;
        try {
            cin =  new Scanner(states);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found exception" + ex);
            System.exit(1);
        }

        while(cin.hasNext()) {
           if(counter == 0) {
               statesList.add(counter, cin.next());
           } else {
               String cWord = statesList.get(counter);
               String pWord = statesList.get(counter - 1);
                if(cWord.charAt(0) == pWord.charAt(0)) { //first letter same case;

                } else if (cWord.charAt(0) > pWord.charAt(0)) { //later in alphabet
                    statesList.add(counter + 1, cWord);
                }
           }
           counter++;
        }

    }
}
