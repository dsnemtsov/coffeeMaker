INSERT INTO coffee(name, available)
VALUES
    ('Эспрессо', true),
    ('Американо', true),
    ('Капучино', true),
    ('Мокко', true)
ON CONFLICT DO NOTHING;

INSERT INTO ingredient(name, quantity)
VALUES
    ('Вода', 10),
    ('Кофе', 10),
    ('Молоко', 10),
    ('Шоколад', 10)
ON CONFLICT DO NOTHING;

INSERT INTO consumable(coffee_id, ingredient_id, quantity_required)
VALUES
    -- Эспрессо
    (1, 1, 3),
    (1, 2, 1),
    -- Американо
    (2, 1, 6),
    (2, 2, 1),
    -- Капучино
    (3, 1, 3),
    (3, 2, 1),
    (3, 3, 1),
    -- Мокко
    (4, 1, 3),
    (4, 2, 1),
    (4, 3, 1),
    (4, 4, 1);