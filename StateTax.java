package com.example.finalproject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.text.NumberFormat;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class StateTax {

    private String state;
    private double tax;

    public StateTax(String state, double tax) {
        this.state = state;
        this.tax = tax;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }



    @Override
    public String toString() {
        return "StateTax{" +
                "state='" + state + '\'' +
                ", tax=" + tax +
                '}';
    }


}
