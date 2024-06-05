package org.example.controller;

import org.example.model.MenuItem;

import java.util.List;
import java.util.ArrayList;

public class MenuController {
    private List<MenuItem> menuItems;

    public MenuController() {
        menuItems = new ArrayList<>();
        // Load menu items from database...
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(String name, String description, double price) {
        // Add menu item logic...
    }
}