package org.example;

import java.util.List;

public class PricingEngine {

    private DiscountService discountService;

    public PricingEngine() {
        this.discountService = new DiscountService();
    }

    public double calculateFinalPrice(
            List<OrderItem> items,
            CustomerType customerType,
            String discountCode
    ) {

        double subtotal = calculateSubtotal(items);

        double discount = discountService.calculateDiscount(
                subtotal,
                customerType,
                discountCode
        );

        double tax = calculateTax(subtotal - discount);

        return subtotal - discount + tax;
    }

    private double calculateSubtotal(List<OrderItem> items) {

        double subtotal = 0;

        for (OrderItem item : items) {
            subtotal += item.getTotal();
        }

        return subtotal;
    }

    private double calculateTax(double amount) {
        return amount * 0.19;
    }
}