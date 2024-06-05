package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.controller.OrderController;
import org.example.controller.PaymentController;
import org.example.model.Order;
import org.example.model.Payment;

public class BillingPanel extends JPanel {
    private OrderController orderController;
    private PaymentController paymentController;
    private JComboBox<Order> orderComboBox;
    private JTextField amountField;
    private JComboBox<String> paymentMethodComboBox;
    private JButton processPaymentButton;

    public BillingPanel() {
        orderController = new OrderController();
        paymentController = new PaymentController();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Billing and Payment Processing");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        JLabel orderLabel = new JLabel("Order:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(orderLabel, gbc);

        orderComboBox = new JComboBox<>(orderController.getOrders().toArray(new Order[0]));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(orderComboBox, gbc);

        JLabel amountLabel = new JLabel("Amount:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(amountLabel, gbc);

        amountField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(amountField, gbc);

        JLabel paymentMethodLabel = new JLabel("Payment Method:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(paymentMethodLabel, gbc);

        paymentMethodComboBox = new JComboBox<>(new String[]{"Cash", "Credit Card", "Debit Card"});
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(paymentMethodComboBox, gbc);

        processPaymentButton = new JButton("Process Payment");
        processPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Order selectedOrder = (Order) orderComboBox.getSelectedItem();
                double amount = Double.parseDouble(amountField.getText());
                String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();

                if (selectedOrder != null && amount > 0) {
                    paymentController.processPayment(selectedOrder.getId(), amount, paymentMethod);
                    JOptionPane.showMessageDialog(null, "Payment processed successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an order and enter a valid amount.");
                }
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(processPaymentButton, gbc);
    }
}
