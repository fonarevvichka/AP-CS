//Vichka Fonarev
//F Block

package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Customer> customers = new PriorityQueue<Customer>();
        Random arrive = new Random();
        Random process = new Random();
        int waitingTime;

        int vipBusNum = 0, vipIndNum = 0, averageJoeNum = 0, newbieNum = 0;
        int vipBusLongWait = 0, vipIndLongWait = 0, averageJoeLongWait = 0, newbieLongWait = 0;
        int vipBusTotalWait = 0, vipIndTotalWait = 0, averageJoeTotalWait = 0, newbieTotalWait = 0;
        String priority = "";
        for(int k = 0; k < 10; k++) {
            for (int i = 0; i < 480; i++) {
                for (Customer customer : customers) {
                    customer.waitInLine();
                }
                if (arrive.nextInt(9) == 1) {
                    switch (arrive.nextInt(5)) {
                        case (0):
                            priority = "Newbie";
                            newbieNum++;
                            break;
                        case (1):
                            priority = "AverageJoe";
                            averageJoeNum++;
                            break;
                        case (2):
                            priority = "VIPIndividual";
                            vipIndNum++;
                            break;
                        case (3):
                            priority = "VIPBusiness";
                            vipBusNum++;
                            break;
                    }
                    customers.add(new Customer("the dude", i, priority));
                }

                if (customers.size() != 0) {
                    if (process.nextInt(5) == 1) {
                        waitingTime = customers.peek().getWaitingTime();
                        switch (customers.peek().getPriority()) {
                            case ("Newbie"):
                                newbieTotalWait += waitingTime;
                                if (waitingTime < newbieLongWait)
                                    newbieLongWait = waitingTime;
                                break;
                            case ("AverageJoe"):
                                averageJoeTotalWait += waitingTime;
                                if (waitingTime < averageJoeLongWait)
                                    averageJoeLongWait = waitingTime;
                                break;
                            case ("VIPIndividual"):
                                vipIndTotalWait += waitingTime;
                                if (waitingTime < vipIndLongWait)
                                    vipIndLongWait = waitingTime;
                                break;
                            case ("VIPBussiness"):
                                vipBusTotalWait += waitingTime;
                                if (waitingTime < vipBusLongWait)
                                    vipBusLongWait = waitingTime;
                                break;
                        }
                        customers.remove();
                    }
                }
            }
            while (!customers.isEmpty()) {
                if (process.nextInt(5) == 1) {
                    waitingTime = customers.peek().getWaitingTime();
                    switch (customers.peek().getPriority()) {
                        case ("newbie"):
                            newbieTotalWait += waitingTime;
                            if (waitingTime < newbieLongWait)
                                newbieLongWait = waitingTime;
                            break;
                        case ("AverageJoe"):
                            averageJoeTotalWait += waitingTime;
                            if (waitingTime < averageJoeLongWait)
                                averageJoeLongWait = waitingTime;
                            break;
                        case ("VIPIndividual"):
                            vipIndTotalWait += waitingTime;
                            if (waitingTime < vipIndLongWait)
                                vipIndLongWait = waitingTime;
                            break;
                        case ("VIPBusiness"):
                            vipBusTotalWait += waitingTime;
                            if (waitingTime < vipBusLongWait)
                                vipBusLongWait = waitingTime;
                            break;
                    }
                    customers.remove();
                }
            }
        }
        System.out.println("Total VIP Business customers served: " + vipBusNum);
        System.out.println("The average wait time for VIP Business: " + (double) vipBusTotalWait / vipBusNum);
        System.out.println("The longest wait time for VIP Business : " + vipBusLongWait);

        System.out.println("");

        System.out.println("Total VIP Individual customers served: " + vipIndNum);
        System.out.println("The average wait time was: " + (double) vipIndTotalWait/ vipIndNum);
        System.out.println("The longest wait time for VIP Individual: " + vipIndLongWait);

        System.out.println("");

        System.out.println("Total Average Joe customers served: " + averageJoeNum);
        System.out.println("The average wait time was: " + (double) averageJoeTotalWait / averageJoeNum);
        System.out.println("The longest wait time for Average Joe: " + averageJoeLongWait);

        System.out.println("");

        System.out.println("Total newbie customers served: " + newbieNum);
        System.out.println("The average wait time was: " + (double) newbieTotalWait / newbieNum);
        System.out.println("The longest wait time for Newbie: " + newbieLongWait);
    }
}
