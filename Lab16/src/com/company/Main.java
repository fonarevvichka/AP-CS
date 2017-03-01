//Vichka Fonarev
//F Block

package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Queue<String> customers = new LinkedList<String>();
        Random arrive = new Random(9);
        Random process = new Random(5);

        for(int i = 0; i < 480; i++) {
            if(arrive.nextInt(9) == 1) {
                customers.add("customer");
            }
            if(process.nextInt(5) == 1) {
                customers.poll();
            }
        }
    }
}
