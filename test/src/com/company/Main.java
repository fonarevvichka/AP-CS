package com.company;

public class Main {

    public static void main(String[] args) {
       System.out.println( show(3));
    }
    public static double show (int n) {
        if(n == 2)
            return .5;
        else
            return 1 + show(n-1);
    }
}
