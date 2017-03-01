package com.company;

/**
 * Created by lhscompsci on 3/1/17.
 */
public class Customer {
    private String name;
    private int waitingTime;
    Customer(String name) {
        this.name = name;
        this.waitingTime = 0;
    }
    public void waitInLine() {
        waitingTime++;
    }
}
