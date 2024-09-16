package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float principal = (float) readValue("Principal:", 1_000, 1_000_000);
        float annualInterest = (float) readValue("Annual interest:", 1, 30);
        byte period = (byte) readValue("Period (Y):", 1, 30);

        float mortgage = calculateMortgage(principal, annualInterest, period);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
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
        final byte MONTHS_IN_YEAR = 12;
        final byte PRESENT = 100;

        float monthlyInterestRate = annualInterest / (MONTHS_IN_YEAR * PRESENT);
        short months = (short) (period * MONTHS_IN_YEAR);

        return (float) ((principal * monthlyInterestRate * Math.pow(monthlyInterestRate + 1, months))
                / (Math.pow(monthlyInterestRate + 1, months) - 1));
    }
}