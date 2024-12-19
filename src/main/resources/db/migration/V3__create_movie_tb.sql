CREATE TABLE tb_movie(
    id serial PRIMARY KEY,
    tittle varchar(100) NOT NULL,
    description text,
    release_date date,
    rating numeric,
    created_at timestamp,
    updated_at timestamp
);