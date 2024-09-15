package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PRESENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        float principal = scanner.nextFloat();

        System.out.print("Annual interest: ");
        float annualInterest = scanner.nextFloat();

        System.out.print("Period (Y): ");
        byte period = scanner.nextByte();

        // calculation
        float monthlyInterestRate = annualInterest / (MONTHS_IN_YEAR * PRESENT);
        int months = period * MONTHS_IN_YEAR;
        double mortgage = (principal * monthlyInterestRate * Math.pow(monthlyInterestRate + 1, months))
                / (Math.pow(monthlyInterestRate + 1, months) - 1);

        // print result
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}