package com.pluralsight.financialCalculators;

import java.sql.SQLOutput;
import java.util.Scanner;

public class FinancialCalculators {

    /*used to calculate a monthly payments for loan
     * params principal ,interest rate, loan length (years)
     * displays monthly payment and total interest paid
     * uses a compound interest formula
     */
    public static double[] mortgageCalculator(double principal, double annualRate, int loanLength) {
        //convert interest rate to monthly
        double monthlyRate = (annualRate / 100) / 12;
        // Turn loan length from years to months
        int numberOfMonthlyPayments = loanLength * 12;

        //monthly payment formula
        double monthlyPayment = principal * (monthlyRate * Math.pow(1 + monthlyRate, numberOfMonthlyPayments)) /
                (Math.pow(1 + monthlyRate, numberOfMonthlyPayments) - 1);
        double totalInterestPaid = (monthlyPayment * numberOfMonthlyPayments) - principal;

        //returns an array with values
        return new double[]{monthlyPayment, totalInterestPaid};

    }
    /*
     *calculates future value of deposit
     * displays future value and interest earned
     * takes a deposit ,interest rate and years as args
     * the numbers should take into account daily compounding
     * I ran the numbers on https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator, and they match with my calculator***
     *\
     */
    public static double[] futureValueCalculator(double deposit, double annualRate, int loanLength){
        // converts annual rate into decimal
        double r = annualRate / 100.0;
        // compound periods = daily = 365
        int n = 365;


        // FV future value formula
        double futureValue = deposit * Math.pow((1 + (r/n)), n * loanLength );

        // Calc interest
        double totalInterest = futureValue - deposit;
        return new double[]{futureValue,totalInterest};
    }

    public static double[] presentValueCalculator(double deposit, double annualRate, int loanLength){
        return new double[]{2,2,2};
    }


    public static void main(String[] args) {
        // scanner to detect users input
        Scanner calcChoiceInput = new Scanner(System.in);


        // used a while loop to loop over menu until user ends
        while (true) {
            System.out.print("Enter \n 'a' for mortgage Calculator\n 'b' for Future Value Calculator\n 'c' for Present Value Calculator\n 'd' to exit\n ");
            String input = calcChoiceInput.nextLine();

            // used switch statement to go through menu options
            switch (input.toLowerCase()) {

                // Mortgage Calculator
                case "a":
                    Scanner userInput = new Scanner(System.in);

                    //read the input number
                    System.out.print("Enter the principal amount: ");
                    double principal = userInput.nextDouble();

                    System.out.print("Enter the annual interest rate (in %): ");
                    double annualRate = userInput.nextDouble();

                    System.out.print("Enter the loan length (in years): ");
                    int loanLength = userInput.nextInt();

                    //calculations
                    double[] usersMonthlyPaymentAndInterest = mortgageCalculator(principal, annualRate, loanLength);

                    System.out.println("Your Monthly Payment and total interest paid would be: ");

                    System.out.printf("Monthly Payment: $%.2f%n", usersMonthlyPaymentAndInterest[0]);
                    System.out.printf("Total Interest Paid: %.2f%n", usersMonthlyPaymentAndInterest[1]);
                    break;

                // Future Value Calculator
                case "b":
                    Scanner userFVLInput = new Scanner(System.in);

                    //read the input number
                    System.out.print("Enter the deposit amount: ");
                    double deposit = userFVLInput.nextDouble();

                    System.out.print("Enter the annual interest rate (in %): ");
                    double annualRateFVL = userFVLInput.nextDouble();

                    System.out.print("Enter the loan length (in years): ");
                    int loanLengthFVL = userFVLInput.nextInt();

                    //calculations
                    double[] usersFutureValue = futureValueCalculator(deposit,annualRateFVL,loanLengthFVL);
                    System.out.println("The future value and total interest earned would be: ");
                    System.out.printf("Future Value: $%.2f%n", usersFutureValue[0]);
                    System.out.printf("Future Value: $%.2f%n", usersFutureValue[1]);

                    break;

                // Present Value Calculator
                case "c":
                    System.out.println("third calculator");
                    break;

                case "d":
                    System.out.println("Good Bye!");
                    calcChoiceInput.close();
                    return;
                default:
                    System.out.println("Invalid input");


            }

            System.out.print("Do you want to continue? (yes/no):");
            String continueInput = calcChoiceInput.nextLine();
            if (continueInput.equalsIgnoreCase("no")){
                System.out.println("Goodbye!");
                break;
            }
        }
        // Close the scanner
        calcChoiceInput.close();

    }
}