package org.example;

import java.util.List;

public class BadPricingEngine {

    public double calculate(
            List<Double> prices,
            List<Integer> quantities,
            String customerType,
            String discountCode
    ) {

        double subtotal = 0;

        for (int i = 0; i < prices.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }

        double discount = 0;

        if (customerType.equals("VIP")) {
            discount += subtotal * 0.10;
        }

        if (discountCode.equals("SAVE10")) {
            discount += subtotal * 0.10;
        }

        if (discountCode.equals("SAVE20")) {
            discount += subtotal * 0.20;
        }

        double tax = (subtotal - discount) * 0.19;

        return subtotal - discount + tax;
    }
}