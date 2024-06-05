package org.example.controller;

import org.example.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentController {
    private List<Payment> payments;

    public PaymentController() {
        payments = new ArrayList<>();
        // Load payments from database...
    }

    public void processPayment(int orderId, double amount, String method) {
        // Process payment logic...
    }
}