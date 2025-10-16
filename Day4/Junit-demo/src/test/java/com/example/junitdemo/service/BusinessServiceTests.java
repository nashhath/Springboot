package com.example.junitdemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BusinessServiceTests {

    private BusinessService businessService;

    @BeforeEach
    void setUp() {
        businessService = new BusinessService();
    }

    @Test
    void testCalculateDiscount_HighAmount() {
        double discount = businessService.calculateDiscount(1500);
        assertEquals(150.0, discount);
    }

    @Test
    void testCalculateDiscount_MediumAmount() {
        double discount = businessService.calculateDiscount(700);
        assertEquals(35.0, discount);
    }

    @Test
    void testCalculateDiscount_LowAmount() {
        double discount = businessService.calculateDiscount(300);
        assertEquals(0.0, discount);
    }

    @Test
    void testCalculateFinalAmount() {
        double finalAmount = businessService.calculateFinalAmount(1000);
        assertEquals(900.0, finalAmount);
    }

    @Test
    void testCalculateDiscount_NegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> businessService.calculateDiscount(-500));
    }
}