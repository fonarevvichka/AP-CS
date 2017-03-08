package com.company;

/**
 * Created by lhscompsci on 3/1/17.
 */
public class Customer implements Comparable <Customer>{
    private String name;
    private int waitingTime, timeOfArrival;
    private String priority;
    Customer(String name, int timeOfArriva, String priority) {
        this.name = name;
        this.waitingTime = 0;
        this.priority = priority;
        this.timeOfArrival = timeOfArrival;
    }
    public void waitInLine() {
        waitingTime++;
    }
    public int getWaitingTime() {
        return waitingTime;
    }
    public int getTimeOfArrival() {
        return timeOfArrival;
    }
    public String getPriority() {
        return priority;
    }
    public int compareTo(Customer customer) {
        int customerOnePriority, customerTwoPriority;
        String customerTwo = customer.getPriority();
        if (priority.equals("VIPBusiness")) {
            customerOnePriority = 4;
        } else if (priority.equals("VIPIndividual")) {
            customerOnePriority = 3;
        } else if (priority.equals("AverageJoe")) {
            customerOnePriority = 2;
        } else {
            customerOnePriority = 1;
        }

        if (customerTwo.equals("VIPBusiness")) {
            customerTwoPriority = 4;
        } else if (customerTwo.equals("VIPIndividual")) {
            customerTwoPriority = 3;
        } else if (customerTwo.equals("AverageJoe")) {
            customerTwoPriority = 2;
        } else {
            customerTwoPriority = 1;
        }


        if(customerOnePriority > customerTwoPriority) {
            return 1;
        } else {
            return -1;
        }
    }
}
