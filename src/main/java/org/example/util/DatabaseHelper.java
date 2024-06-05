package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:database/restaurant.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createTables() {
        String[] tableCreationStatements = {
                "CREATE TABLE IF NOT EXISTS tables (id INTEGER PRIMARY KEY AUTOINCREMENT, table_number INTEGER NOT NULL, capacity INTEGER NOT NULL, status TEXT NOT NULL);",
                "CREATE TABLE IF NOT EXISTS menu_items (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, description TEXT, price REAL NOT NULL);",
                "CREATE TABLE IF NOT EXISTS orders (id INTEGER PRIMARY KEY AUTOINCREMENT, table_id INTEGER, total REAL, status TEXT, FOREIGN KEY (table_id) REFERENCES tables(id));",
                "CREATE TABLE IF NOT EXISTS order_items (id INTEGER PRIMARY KEY AUTOINCREMENT, order_id INTEGER, menu_item_id INTEGER, quantity INTEGER, FOREIGN KEY (order_id) REFERENCES orders(id), FOREIGN KEY (menu_item_id) REFERENCES menu_items(id));",
                "CREATE TABLE IF NOT EXISTS reservations (id INTEGER PRIMARY KEY AUTOINCREMENT, table_id INTEGER, customer_name TEXT, reservation_time TEXT, FOREIGN KEY (table_id) REFERENCES tables(id));",
                "CREATE TABLE IF NOT EXISTS payments (id INTEGER PRIMARY KEY AUTOINCREMENT, order_id INTEGER, amount REAL, payment_method TEXT, FOREIGN KEY (order_id) REFERENCES orders(id));"
        };

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            for (String sql : tableCreationStatements) {
                stmt.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
