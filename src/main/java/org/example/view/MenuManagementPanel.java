package org.example.view;

import javax.swing.*;
import java.awt.*;

public class MenuManagementPanel {

    public JPanel createMenuPanel() {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Menu Management Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MenuManagementPanel menuManagementPanel = new MenuManagementPanel();
            JPanel mainPanel = menuManagementPanel.createMenuPanel();
            frame.add(mainPanel);

            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setVisible(true);
        });
    }
}
