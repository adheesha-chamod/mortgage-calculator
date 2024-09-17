package com.mortgageCalculator;

import java.text.NumberFormat;

public class MortgageReport {

    public final NumberFormat currency;
    private final MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
        this.currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        System.out.println("MORTGAGE\n--------");
        System.out.println("Mortgage: " + currency
                .format(mortgageCalculator.calculateMortgage()));
    }

    public void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for (float balance : mortgageCalculator.getRemainingBalances()) {
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
