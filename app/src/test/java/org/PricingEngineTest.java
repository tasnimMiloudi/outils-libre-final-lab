package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingEngineTest {

    @Test
    void shouldCalculateVipPrice() {

        PricingEngine engine = new PricingEngine();

        List<OrderItem> items = List.of(
                new OrderItem(100, 1)
        );

        double result = engine.calculateFinalPrice(
                items,
                CustomerType.VIP,
                "SAVE20"
        );

        assertEquals(83.3, result, 0.01);
    }
}