CREATE TABLE IF NOT EXISTS Users(
    id SERIAL PRIMARY KEY,
    email TEXT,
    password TEXT,
    full_name TEXT
);