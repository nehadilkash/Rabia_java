package com.example.finalproject;


import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import java.util.ArrayList;

@ManagedBean(name = "shoppingCart")
@RequestScoped
public class ShoppingCart {

    private ArrayList<CartItem> cartItems = new ArrayList<>();


    public ShoppingCart() {
        cartItems.add(new CartItem(new Book("Design Patterns", 10), 2));
        cartItems.add(new CartItem(new Book("Introduction to Algorithms", 15), 2));
        cartItems.add(new CartItem(new Book("Get Coding", 7), 1));
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public double getSubTotal() {
        return cartItems.stream().mapToDouble(o->o.getBook().getPrice()*o.getQuantity()).sum();
    }

}

