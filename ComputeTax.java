package com.example.finalproject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

@Named(value = "computeTax")
@RequestScoped
public class ComputeTax {

    private ArrayList<StateTax> stateTaxes = new ArrayList<>();

    private StateTax selectedStateTax;

    private String billDetails;

    public ComputeTax() {
        stateTaxes.add(new StateTax("", 0.00));
        stateTaxes.add(new StateTax("Alabama", 4.00));
        stateTaxes.add(new StateTax("Alaska", 0.00));
        stateTaxes.add(new StateTax("Arizona", 5.60));
        stateTaxes.add(new StateTax("Arkansas", 6.50));
        stateTaxes.add(new StateTax("California ", 7.25));
        stateTaxes.add(new StateTax("Colorado", 2.90));
        stateTaxes.add(new StateTax("Connecticut", 6.35));
        stateTaxes.add(new StateTax("D.C.", 6.00));
        stateTaxes.add(new StateTax("Delaware", 0.00));
        stateTaxes.add(new StateTax("Florida", 6.00));
    }

    public StateTax getSelectedStateTax() {
        return selectedStateTax;
    }

    public void setSelectedStateTax(StateTax selectedStateTax) {
        this.selectedStateTax = selectedStateTax;
    }

    public ArrayList<StateTax> getStateTaxes() {
        return stateTaxes;
    }

    public void setStateTaxes(ArrayList<StateTax> stateTaxes) {
        this.stateTaxes = stateTaxes;
    }

    public String getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(String billDetails) {
        this.billDetails = billDetails;
    }

    public void processSubmit() {
        System.out.printf("I am processing info with " + selectedStateTax);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        billDetails = "Subtotal: " + currencyFormat.format(Double.parseDouble("4.020")) + "<br />"
                + "Tax Amount: " + currencyFormat.format(Double.parseDouble("4.020")) + "<br />" +
                "Shipping Fees: " + currencyFormat.format(Double.parseDouble("4.020")) + "<br />" +
                "Grand Total: " + currencyFormat.format(Double.parseDouble("4.020")) + "<br />";
    }


    public StateTax getStateTax(String state) {
        if (state.isEmpty()) {
            throw new IllegalArgumentException("no state provided");
        }
        for (StateTax stateTax : stateTaxes) {
            if (state.equals(stateTax.getState())) {
                return stateTax;
            }
        }
        return null;
    }

}
