package com.company;

public class Main {

    public static void main(String[] args) {
       System.out.println(f(f(f(f(f(f(3)))))));
    }
    public static int f(int n) {
        if(n < 5) {
            System.out.println((n*n -1));
            return (n * n) + 1;
        }
        else if (n == 5)
            return (n * n) -3;
        return f(n-2);
    }
}
