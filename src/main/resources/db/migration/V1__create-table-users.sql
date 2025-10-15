CREATE TABLE users (
    id BINARY(16) PRIMARY KEY,
    name varchar(100) NOT NULL,
    username varchar(100) NOT NULL UNIQUE,
    email varchar(200) UNIQUE,
    birth_date DATE,
    password_hash varchar(255)
);