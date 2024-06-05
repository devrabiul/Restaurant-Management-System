package org.example.controller;

import org.example.model.Table;

import java.util.ArrayList;
import java.util.List;

public class TableController {
    private List<Table> tables;

    public TableController() {
        tables = new ArrayList<>();
        // Load tables from database...
    }

    public List<Table> getTables() {
        return tables;
    }

    public void reserveTable(int tableId, String customerName, String reservationTime) {
        // Add reservation logic...
    }
}