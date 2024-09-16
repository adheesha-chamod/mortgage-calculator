package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PRESENT = 100;

    public static void main(String[] args) {
        float principal = (float) readValue("Principal:", 1_000, 1_000_000);
        float annualInterest = (float) readValue("Annual interest:", 1, 30);
        byte period = (byte) readValue("Period (Y):", 1, 30);

        printMortgage(principal, annualInterest, period);
        printPaymentSchedule(principal, annualInterest, period);
    }

    public static double readValue(String prompt, float min, float max) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true){
            System.out.print(prompt + " ");
            value = scanner.nextFloat();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }

        return value;
    }

    public static float calculateMortgage(float principal, float annualInterest, byte period) {
        float monthlyInterestRate = annualInterest / (MONTHS_IN_YEAR * PRESENT);
        short months = (short) (period * MONTHS_IN_YEAR);

        return (float) (principal
                * (monthlyInterestRate * Math.pow(monthlyInterestRate + 1, months))
                / (Math.pow(monthlyInterestRate + 1, months) - 1));
    }

    public static float calculateLoanBalance(float principal, float annualInterest, byte period, short noOfPaymentsMade) {
        float monthlyInterestRate = annualInterest / (MONTHS_IN_YEAR * PRESENT);
        short months = (short) (period * MONTHS_IN_YEAR);

        return (float) (principal
                * (Math.pow(1 + monthlyInterestRate, months) - Math.pow(1 + monthlyInterestRate, noOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, months) - 1));
    }

    private static void printMortgage(float principal, float annualInterest, byte period) {
        System.out.println("MORTGAGE\n--------");
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance()
                .format(calculateMortgage(principal, annualInterest, period)));
    }

    private static void printPaymentSchedule(float principal, float annualInterest, byte period) {
        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for (short month = 1; month <= period * MONTHS_IN_YEAR; month++) {
            System.out.println(NumberFormat.getCurrencyInstance()
                    .format(calculateLoanBalance(principal, annualInterest, period, month)));
        }
    }
}