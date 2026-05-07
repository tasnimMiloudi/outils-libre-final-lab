package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadPricingEngineTest {

    @Test
    void shouldCalculateRegularCustomer() {

        BadPricingEngine engine = new BadPricingEngine();

        double result = engine.calculate(
                List.of(100.0),
                List.of(2),
                "REGULAR",
                "SAVE10"
        );

        assertEquals(214.2, result, 0.01);
    }

    @Test
    void shouldCalculateVipCustomer() {

        BadPricingEngine engine = new BadPricingEngine();

        double result = engine.calculate(
                List.of(100.0),
                List.of(1),
                "VIP",
                "SAVE20"
        );

        assertEquals(83.3, result, 0.01);
    }
}