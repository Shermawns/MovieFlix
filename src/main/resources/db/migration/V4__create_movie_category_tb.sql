CREATE TABLE tb_movie_category (
    movie_id INTEGER,
    category_id INTEGER,
    CONSTRAINT fk_tb_movie_category_movie FOREIGN KEY(movie_id) REFERENCES tb_movie(id) ON DELETE CASCADE,
    CONSTRAINT fk_tb_movie_category_category FOREIGN KEY(category_id) REFERENCES tb_category(id) ON DELETE CASCADE,
    PRIMARY KEY(movie_id, category_id)
);