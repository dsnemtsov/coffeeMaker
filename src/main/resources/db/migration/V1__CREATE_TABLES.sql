CREATE TABLE IF NOT EXISTS coffee
(
    coffee_id         SERIAL PRIMARY KEY,
    name VARCHAR(30)  NOT NULL
);

CREATE TABLE IF NOT EXISTS ingredient
(
    ingredient_id     SERIAL PRIMARY KEY,
    name              VARCHAR(30)  NOT NULL,
    quantity          INTEGER
);