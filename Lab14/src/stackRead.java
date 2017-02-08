import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lhscompsci on 2/8/17.
 */
public class stackRead implements Stack {
    private ArrayList items;

    public static void main(String[] Args) {
        Scanner cin = new Scanner(System.in);
        String input, output = "";
        boolean quit = false;
        stackRead inputStack = new stackRead();
        stackRead outputStack = new stackRead();

        int size = inputStack.items.size();

        System.out.println("Please enter your string: ");
        input = cin.next();

        while (!quit) {
            for (int i = 0; i < input.length(); i++) {
                char currLetter = input.charAt(i);
                if (currLetter == '-' && !inputStack.isEmpty()) {
                    inputStack.pop();
                } else if (currLetter == '$') {
                    while (!inputStack.isEmpty()) {
                        inputStack.pop();
                    }
                } else {
                    inputStack.push(currLetter);
                }
            }

            while(!inputStack.isEmpty()) {
                outputStack.push(inputStack.peekTop());
                inputStack.pop();
            }
            System.out.println("Here is what you entered: ");
            while(!outputStack.isEmpty()) {
                System.out.print(outputStack.peekTop());
                outputStack.pop();
            }

            System.out.println("\n" + "Would you like to continue (y/n): ");
            input = cin.next();

            if (input.equals("n")) {
                quit = true;
            } else {
                System.out.println("Please enter your string; ");
                input = cin.next();
            }
        }
    }

    public stackRead () {
        items = new ArrayList( );
    }
    public boolean isEmpty() {
        return items.isEmpty ( );
    }
    public void push (Object x) {
        items.add (x);
    }
    public Object pop() {
        return items.remove (items.size ( ) - 1);
    }
    public Object peekTop (){
        return items.get (items.size ( ) - 1);
    }
}

