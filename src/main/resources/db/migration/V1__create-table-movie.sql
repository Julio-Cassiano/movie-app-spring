CREATE TABLE movie (
    id VARCHAR(36) PRIMARY KEY,
    name TEXT NOT NULL,
    synopsis TEXT,
    release_date DATE,
    duration_in_minutes INT,
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);