CREATE TABLE payments (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    order_id INTEGER,
    amount REAL,
    payment_method TEXT,
    FOREIGN KEY (order_id) REFERENCES orders(id)
);