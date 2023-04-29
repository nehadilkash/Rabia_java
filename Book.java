package com.example.finalproject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


public class Book {
    private String bookName;
    private double price;

    public Book(String bookName, double price) {
        this.bookName = bookName;
        this.price = price;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
