package com.mortgageCalculator;

public class MortgageCalculator {

    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PRESENT = 100;

    private final float principal;
    private final float annualInterest;
    private final byte period;

    public MortgageCalculator(float principal, float annualInterest, byte period) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.period = period;
    }

    public float calculateMortgage() {
        float monthlyInterestRate = getMonthlyInterestRate();
        short months = getMonths();

        return (float) (principal
                * (monthlyInterestRate * Math.pow(monthlyInterestRate + 1, months))
                / (Math.pow(monthlyInterestRate + 1, months) - 1));
    }

    public float calculateLoanBalance(short noOfPaymentsMade) {
        float monthlyInterestRate = getMonthlyInterestRate();
        short months = getMonths();

        return (float) (principal
                * (Math.pow(1 + monthlyInterestRate, months) - Math.pow(1 + monthlyInterestRate, noOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, months) - 1));
    }

    public float[] getRemainingBalances() {
        float[] balances = new float[getMonths()];

        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateLoanBalance(month);
        }

        return balances;
    }

    private float getMonthlyInterestRate() {
        return annualInterest / (MONTHS_IN_YEAR * PRESENT);
    }

    private short getMonths() {
        return (short) (period * MONTHS_IN_YEAR);
    }
}
