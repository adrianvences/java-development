package com.pluralsight.calculator;

import java.util.Scanner;

public class Calculator {

    public static int simpleCalculator (int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public static void main(String[] args) {
        // scanner to read input from System.in
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Welcome to the simple calculator. Enter the two numbers you want to add.");

        System.out.print("Enter first Number (Only digits): ");
        int firstNum = inputScanner.nextInt();

        System.out.print("Enter second Number (Only digits): ");
        int secondNum = inputScanner.nextInt();

        // calculations
        System.out.println(simpleCalculator(firstNum,secondNum));

    }
}
