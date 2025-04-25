package com.pluralsight;

import java.io.*;
import java.util.*;

public class OnlineStore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cart cart = new Cart();
        List<Products> product = loadProducts("src/main/resources/products.csv");

        while (true) {
            System.out.println("\n🛒 Welcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. View Cart");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            switch (input.nextLine()) {
                case "1" -> showProducts(product, cart, input);
                case "2" -> cart.displayCart();
                case "3" -> {
                    System.out.println("Thanks for shopping! ✨");
                    return;
                }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    // Load products from CSV file
    public static List<Products> loadProducts(String filename) {
        List<Products> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("\\|");
                list.add(new Products(p[0], p[1], Double.parseDouble(p[2]), p[3]));
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error loading products: " + e.getMessage());
        }
        return list;
    }

    // Show products and let user add to cart
    public static void showProducts(List<Products> products, Cart cart, Scanner input) {
        products.forEach(System.out::println);

        System.out.print("Enter SKU to add or press ENTER to go back: ");
        String sku = input.nextLine();

        if (!sku.isBlank()) {
            Products match = findProductBySku(products, sku);
            if (match != null) {
                System.out.print("Qty: ");
                int qty = Integer.parseInt(input.nextLine());
                cart.addToCart(match, qty);
                System.out.println("✅ Added to cart!");
            } else {
                System.out.println("❌ Not found.");
            }
        }
    }

    // Find a product by SKU (clean one-liner)
    private static Products findProductBySku(List<Products> products, String sku) {
        return products.stream()
                .filter(p -> p.getSku().equalsIgnoreCase(sku))
                .findFirst()
                .orElse(null);
    }
}
