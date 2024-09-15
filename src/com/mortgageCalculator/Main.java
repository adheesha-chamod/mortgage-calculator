package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PRESENT = 100;

        Scanner scanner = new Scanner(System.in);

        float principal;
        float annualInterest;
        byte period;

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextFloat();

            if (principal >= 1_000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a value between $1K and $1M");
        }

        while (true){
            System.out.print("Annual interest: ");
            annualInterest = scanner.nextFloat();

            if (annualInterest > 0 && annualInterest <= 30) {
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }

        while (true) {
            System.out.print("Period (Y): ");
            period = scanner.nextByte();

            if (period > 0 && period <= 30) {
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

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