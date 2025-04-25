
package com.pluralsight;

public class CartItem {
    private Products product;
    private int quantity;

    public CartItem(Products product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Products getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%-25s | Qty: %2d | Total: $%.2f",
                product.getProductName(), quantity, getTotalPrice());
    }
}
