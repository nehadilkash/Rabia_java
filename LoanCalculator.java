package com.example.calculate_loan;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

@WebServlet(name = "LoanCalculator", value = "/LoanCalculator")
public class LoanCalculator extends HttpServlet {

    private String annualInterestRate;
    private String numberOfYears;
    private String loanAmount;

    /**
     * Default constructor
     */
    public LoanCalculator() {
    }

    /**
     * Construct a loan with specified annual interest rate,
     * no-arg constructor
     * Class Abstraction and Encapsulation 369
     * number of years, and loan amount
     */
    public LoanCalculator(String annualInterestRate, String numberOfYears,
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


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        this.loanAmount = request.getParameter("loanAmount");
        this.annualInterestRate= request.getParameter("annualInterestRate");
        this.numberOfYears = request.getParameter("numberOfYears");


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>" + toString() + "</p>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}
