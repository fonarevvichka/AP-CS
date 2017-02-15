package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static Queue<String> puppers = new LinkedList<String>();
    private static Queue<String> hoomans = new LinkedList<String>();
    private static Scanner cin = new Scanner(System.in);
    private static String userInput = "", name, humanVpuppy;
    private static Boolean quit = false;

    public static void main(String[] args) {
        System.out.println("Welcome to Pick - A - Pup Exclusive Puppy Adoption Service");

        while(!quit) {
            System.out.println("Client Name: ");
            name = cin.next();

            if(name.equals("SPCA")) {
                System.out.println("Because of the Society for the Prevention of Cruelty to Animals, we left town.");
                quit = true;
                break;
            }
            if(name.equals("BBB")) {
                System.out.println("Because of the Better Business Bureau, we left town.");
                quit = true;
                break;
            }

            if (name.equalsIgnoreCase("SPCA") || name.equalsIgnoreCase("BBB")) {
                quit = true;
                break;
            }

            System.out.println("Human or Puppy?: ");
            humanVpuppy = cin.next();


            switch(humanVpuppy) {
                case "Human":
                    hoomans.add(name);
                    break;
                case "Puppy":
                    puppers.add(name);
                    break;
            }

            if(hoomans.isEmpty() || puppers.isEmpty()) {
                System.out.println("We don't have a match for you right now, " + "\n" +
                "but one is sure to turn up soon.");
            } else {
                System.out.println("* * * * * We have a match ! " + hoomans.poll() + " can adopt " + puppers.poll() + ".");
            }

        }
    }
}
