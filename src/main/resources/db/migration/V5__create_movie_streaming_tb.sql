CREATE TABLE tb_movie_streaming (
    movie_id INTEGER,
    streaming_id INTEGER,
    CONSTRAINT fk_tb_movie_streaming_movie FOREIGN KEY(movie_id) REFERENCES tb_movie(id) ON DELETE CASCADE,
    CONSTRAINT fk_tb_movie_streaming_streaming FOREIGN KEY(streaming_id) REFERENCES tb_streaming(id) ON DELETE CASCADE,
    PRIMARY KEY(movie_id, streaming_id)
);