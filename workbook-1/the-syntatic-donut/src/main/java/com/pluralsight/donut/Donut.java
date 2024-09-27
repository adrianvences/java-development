package com.pluralsight.donut;

import java.util.Scanner;

public class Donut {
    static double price = .25;

    public static double getTotalPrice (int numberOfDonuts ) {
        return price * numberOfDonuts;
    }

    public static void main (String[] args) {

        // scanner to read input from System.in
        Scanner inputScanner = new Scanner(System.in);

        // prompt user for a number
        System.out.print("Welcome! How many donuts do you want? :");

        //read the input number
        int numberOfDonuts = inputScanner.nextInt();
        inputScanner.nextLine();

        System.out.println("Your donuts cost:");

        //Calculate Price
        double totalPrice = getTotalPrice(numberOfDonuts);

        //print it out
        System.out.println( totalPrice + " dollars");

        //Make it pretty
        System.out.printf("In dollars, that would be $%8.2f\n", totalPrice);

        //print out a fun math fact

        System.out.printf("The square root of 5 is %8.15f\n", Math.sqrt(5.0));



    }
}
