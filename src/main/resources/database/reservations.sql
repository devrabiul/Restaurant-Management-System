CREATE TABLE reservations (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    table_id INTEGER,
    customer_name TEXT,
    reservation_time TEXT,
    FOREIGN KEY (table_id) REFERENCES tables(id)
);