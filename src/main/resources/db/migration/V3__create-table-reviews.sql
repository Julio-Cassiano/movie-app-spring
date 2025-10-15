CREATE TABLE reviews (
    id BINARY(16) PRIMARY KEY,
    comment TEXT NOT NULL,
    rating SMALLINT CHECK(rating >= 0 AND rating <= 5),
    user_id BINARY(16) NOT NULL,
    movie_id BIGINT NOT NULL,
    CONSTRAINT fk_reviews_users
        FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_reviews_movies
        FOREIGN KEY (movie_id) REFERENCES movies(id)
        ON DELETE CASCADE
);