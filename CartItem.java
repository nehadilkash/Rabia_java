package com.example.finalproject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


public class CartItem {
    private Book book;
    private Integer quantity;

    public CartItem(Book book, Integer quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
