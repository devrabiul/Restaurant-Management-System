package org.example;

import org.example.view.MenuManagementPanel;

import javax.swing.*;
import java.awt.*;

public class RestaurantManagementSystem {
    private JFrame frame;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public RestaurantManagementSystem() {
        frame = new JFrame("Restaurant Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createMenuPanel(), "Menu");
        mainPanel.add(createTableReservationPanel(), "TableReservation");
        mainPanel.add(createOrderPanel(), "Order");
        mainPanel.add(createBillingPanel(), "Billing");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Use BorderLayout for better component arrangement

        JLabel titleLabel = new JLabel("Menu Management");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 2, 10, 10)); // Example grid layout, adjust as needed

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField();
        contentPanel.add(nameLabel);
        contentPanel.add(nameTextField);

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceTextField = new JTextField();
        contentPanel.add(priceLabel);
        contentPanel.add(priceTextField);

        JLabel descriptionLabel = new JLabel("Description:");
        JTextArea descriptionTextArea = new JTextArea(4, 20);
        descriptionTextArea.setLineWrap(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
        contentPanel.add(descriptionLabel);
        contentPanel.add(descriptionScrollPane);

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        contentPanel.add(addButton);
        contentPanel.add(deleteButton);

        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createTableReservationPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Table Reservation Management"));
        // Add components for table reservation management...
        return panel;
    }

    private JPanel createOrderPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Order Management"));
        // Add components for order management...
        return panel;
    }

    private JPanel createBillingPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Billing and Payment Processing"));
        // Add components for billing and payment processing...
        return panel;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new RestaurantManagementSystem());
    }
}
