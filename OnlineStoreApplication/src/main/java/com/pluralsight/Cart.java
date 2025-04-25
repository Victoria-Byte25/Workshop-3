package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addToCart(Products product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getSku().equals(product.getSku())) {
                item.increaseQuantity(quantity);
                return;
            }
        }
        items.add(new CartItem (product, quantity));
    }

    public void removeFromCart(String sku) {
        items.removeIf(item -> item.getProduct().getSku().equals(sku));
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        for (CartItem item : items) {
            System.out.println(item);
        }

        System.out.printf("Total: $%.2f\n", getCartTotal());
    }

    public double getCartTotal() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}


