package com.example.chapter6assignment;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.text.NumberFormat;
import java.util.Locale;

@Named(value = "loan")
@RequestScoped
public class Loan {
    private String annualInterestRate;
    private String numberOfYears;
    private String loanAmount;

    /**
     * Default constructor
     */
    public Loan() {
    }

    /**
     * Construct a loan with specified annual interest rate,
     * no-arg constructor
     * Class Abstraction and Encapsulation 369
     * number of years, and loan amount
     */
    public Loan(String annualInterestRate, String numberOfYears,
                String loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    /**
     * Return annualInterestRate
     */

    public String getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(String annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public String getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(String numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Find monthly payment
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = Double.parseDouble(annualInterestRate) / 1200;
        double monthlyPayment = Double.parseDouble(loanAmount) * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, Integer.parseInt(numberOfYears) * 12)));
        return monthlyPayment;
    }

    /**
     * Find total payment
     */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * Integer.parseInt(numberOfYears) * 12;
        return totalPayment;
    }

    /**
     * Return loan date
     */

    @Override
    public String toString() {


        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);


        return "Loan Amount: " + currencyFormat.format(Double.parseDouble(loanAmount)) + "<br />"
                + "Annual Interest Rate: " + annualInterestRate + "<br />" +
                "Number Of Years: " + numberOfYears + "<br />" +
                "Monthly Payment: " + currencyFormat.format(getMonthlyPayment()) + "<br />" +
                "Total Payment: " + currencyFormat.format(getTotalPayment()) + "<br />";
    }

    public String processSubmit() {
        return "loanConfirm";
    }

    public void processClear() {
        this.annualInterestRate = "";
        this.loanAmount = "";
        this.numberOfYears = "1";
    }
}