package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.example.controller.TableController;
import org.example.model.Table;

public class TableReservationPanel extends JPanel {
    private TableController tableController;
    private JTextField customerNameField;
    private JTextField reservationTimeField;
    private JComboBox<Table> tableComboBox;

    public TableReservationPanel() {
        tableController = new TableController();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Table Reservation Management");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        JLabel customerNameLabel = new JLabel("Customer Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(customerNameLabel, gbc);

        customerNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(customerNameField, gbc);

        JLabel reservationTimeLabel = new JLabel("Reservation Time:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(reservationTimeLabel, gbc);

        reservationTimeField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(reservationTimeField, gbc);

        JLabel tableLabel = new JLabel("Table:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(tableLabel, gbc);

        tableComboBox = new JComboBox<>(tableController.getTables().toArray(new Table[0]));
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(tableComboBox, gbc);

        JButton reserveButton = getjButton();
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(reserveButton, gbc);
    }

    private JButton getjButton() {
        JButton reserveButton = new JButton("Reserve Table");
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = customerNameField.getText();
                String reservationTime = reservationTimeField.getText();
                Table selectedTable = (Table) tableComboBox.getSelectedItem();

                if (selectedTable != null && !customerName.isEmpty() && !reservationTime.isEmpty()) {
                    tableController.reserveTable(selectedTable.getId(), customerName, reservationTime);
                    JOptionPane.showMessageDialog(null, "Table reserved successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                }
            }
        });
        return reserveButton;
    }
}
