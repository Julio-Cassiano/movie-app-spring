CREATE TABLE movie_director (
    movie_id BIGINT NOT NULL,
    director_id VARCHAR(36) NOT NULL,

    PRIMARY KEY (movie_id, director_id),
    FOREIGN KEY (movie_id) REFERENCES movies(id),
    FOREIGN KEY (director_id) REFERENCES directors(id)
);