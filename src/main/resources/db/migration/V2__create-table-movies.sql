CREATE TABLE movies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    synopsis TEXT,
    release_date DATE,
    duration_in_seconds INT,
    image_path VARCHAR(255),
    user_id BINARY(16) NULL,
    register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_movies_users
        FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE SET NULL
);