package com.company;

/**
 * Created by lhscompsci on 3/1/17.
 */
public class Customer {
    private String name;
    private int waitingTime, timeOfArrival;
    Customer(String name, int timeOfArrival) {
        this.name = name;
        this.waitingTime = 0;
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
}
