CREATE TABLE reviews (
    id VARCHAR(36) PRIMARY KEY,
    comment TEXT NOT NULL,
    user_id VARCHAR(36) NOT NULL,
    movie_id BIGINT NOT NULL,
    CONSTRAINT fk_reviews_users
        FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_reviews_movies
        FOREIGN KEY (movie_id) REFERENCES movies(id)
        ON DELETE CASCADE
);