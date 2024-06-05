package org.example.model;

public class MenuItem {
    private int id;
    private String name;
    private String description;
    private double price;

    // Default constructor
    public MenuItem() {
    }

    // Parameterized constructor
    public MenuItem(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString method to represent MenuItem as a string
    @Override
    public String toString() {
        return name + " (" + description + ") - $" + price;
    }
}
