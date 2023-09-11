CREATE TABLE IF NOT EXISTS coffee
(
    coffee_id         SERIAL PRIMARY KEY,
    name VARCHAR(30)  NOT NULL,
    available         BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS ingredient
(
    ingredient_id     SERIAL PRIMARY KEY,
    name              VARCHAR(30)  NOT NULL,
    quantity          INTEGER
);

CREATE TABLE IF NOT EXISTS consumable
(
    consumable_id     SERIAL PRIMARY KEY,
    coffee_id         INTEGER NOT NULL,
    ingredient_id     INTEGER NOT NULL,
    quantity_required INTEGER NOT NULL,
    FOREIGN KEY (coffee_id) REFERENCES coffee (coffee_id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id)
);

CREATE TABLE IF NOT EXISTS coffee_log
(
    coffee_log_id     SERIAL PRIMARY KEY,
    coffee_id         INTEGER NOT NULL,
    create_date       TIMESTAMP WITH TIME ZONE NOT NULL,
    FOREIGN KEY (coffee_id) REFERENCES coffee (coffee_id)
);