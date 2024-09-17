package com.mortgageCalculator;

public class Main {

    public static void main(String[] args) {
        float principal = (float) Console.readValue("Principal:", 1_000, 1_000_000);
        float annualInterest = (float) Console.readValue("Annual interest:", 1, 30);
        byte period = (byte) Console.readValue("Period (Y):", 1, 30);

        MortgageCalculator mortgageCalculator = new MortgageCalculator(principal, annualInterest, period);
        MortgageReport mortgageReport = new MortgageReport(mortgageCalculator);
        mortgageReport.printMortgage();
        mortgageReport.printPaymentSchedule();
    }
}