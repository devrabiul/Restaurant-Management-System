package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.controller.MenuController;
import org.example.controller.OrderController;
import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderPanel extends JPanel {
    private MenuController menuController;
    private OrderController orderController;
    private JComboBox<MenuItem> menuItemComboBox;
    private JTextField quantityField;
    private JButton addButton;
    private JButton placeOrderButton;
    private JTextArea orderSummaryTextArea;

    private List<OrderItem> orderItems;

    public OrderPanel() {
        menuController = new MenuController();
        orderController = new OrderController();
        orderItems = new ArrayList<>();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Order Management");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        JLabel menuItemLabel = new JLabel("Menu Item:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(menuItemLabel, gbc);

        menuItemComboBox = new JComboBox<>(menuController.getMenuItems().toArray(new MenuItem[0]));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(menuItemComboBox, gbc);

        JLabel quantityLabel = new JLabel("Quantity:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(quantityLabel, gbc);

        quantityField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(quantityField, gbc);

        addButton = new JButton("Add to Order");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuItem selectedItem = (MenuItem) menuItemComboBox.getSelectedItem();
                try {
                    int quantity = Integer.parseInt(quantityField.getText());
                    if (selectedItem != null && quantity > 0) {
                        OrderItem orderItem = new OrderItem();
                        orderItem.setMenuItemId(selectedItem.getId());
                        orderItem.setQuantity(quantity);
                        orderItems.add(orderItem);

                        orderSummaryTextArea.append(selectedItem.getName() + " - " + quantity + "\n");
                        quantityField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a menu item and enter a valid quantity.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for quantity.");
                }
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(addButton, gbc);

        orderSummaryTextArea = new JTextArea(10, 30);
        orderSummaryTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderSummaryTextArea);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(scrollPane, gbc);

        placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Assume table ID 1 for simplicity
                int tableId = 1;

                if (!orderItems.isEmpty()) {
                    orderController.createOrder(tableId, orderItems);
                    JOptionPane.showMessageDialog(null, "Order placed successfully!");
                    orderItems.clear();
                    orderSummaryTextArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No items in the order.");
                }
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(placeOrderButton, gbc);
    }
}