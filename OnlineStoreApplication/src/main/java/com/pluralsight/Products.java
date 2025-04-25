package com.pluralsight;

public class Products {

        private String sku;
        private String productName;
        private double price;
        private String department;

        public Products (String sku, String productName, double price, String department) {
            this.sku = sku;
            this.productName = productName;
            this.price = price;
            this.department = department;
        }

        public String getSku() {
            return sku;
        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return String.format("%-6s | %-25s | $%-6.2f | %-15s",
                    sku, productName, price, department);
        }



}

