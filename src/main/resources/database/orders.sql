CREATE TABLE orders (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    table_id INTEGER,
    total REAL,
    status TEXT,
    FOREIGN KEY (table_id) REFERENCES tables(id)
);