//Vichka Fonarev
//F Block

package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Queue<Customer> customers = new LinkedList<Customer>();
        Random arrive = new Random();
        Random process = new Random();
        int waitingTime, longestWait = 0, totalWaitingTime = 0;
        int numberOfCustomers = 0, totalQue = 0, counter = 0;
        int longestQue = 0;

        double superTotalWaitTimeAverage = 0;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 480; i++) {
                for (Customer customer : customers) {
                    customer.waitInLine();
                }
                if (arrive.nextInt(9) == 1) {
                    customers.add(new Customer("the dude", i));
                    numberOfCustomers++;
                }
                if (longestQue < customers.size()) {
                    longestQue = customers.size();
                }
                if (customers.size() != 0) {
                    if (process.nextInt(5) == 1) {
                        waitingTime = customers.peek().getWaitingTime();
                        totalWaitingTime += waitingTime;
                        if (waitingTime > longestWait) {
                            longestWait = waitingTime;
                        }
                        customers.remove();
                    }
                }
                totalQue += customers.size();
                System.out.println("The queue length is " + customers.size());
            }
            while (!customers.isEmpty()) {
                counter++;
                if (process.nextInt(5) == 1) {
                    waitingTime = customers.poll().getWaitingTime();
                    totalWaitingTime += waitingTime;
                    if (waitingTime > longestWait) {
                        longestWait = waitingTime;
                    }
                }
                totalQue += customers.size();
                System.out.println("The queue length is " + customers.size());
            }
        }
            System.out.println("Total customers served: " + numberOfCustomers);
            System.out.println("The average wait time was: " + (double) totalWaitingTime / numberOfCustomers);
            System.out.println("The longest waiting time was: " + longestWait);
            System.out.println("The average queue length was: " + (double) totalQue / (4800 + counter));
            System.out.println("The longest queue length was: " + longestQue);
    }
}
