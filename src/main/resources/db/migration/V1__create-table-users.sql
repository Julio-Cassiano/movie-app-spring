CREATE TABLE users (
    id VARCHAR(36) PRIMARY KEY,
    name varchar(100) NOT NULL,
    birth_date DATE,
    username varchar(100) NOT NULL UNIQUE,
    email varchar(200) UNIQUE,
    password_hash varchar(255)
);