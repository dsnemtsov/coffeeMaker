INSERT INTO coffee(name)
VALUES
    ('Эспрессо'),
    ('Американо'),
    ('Капучино'),
    ('Мокко')
ON CONFLICT DO NOTHING;

INSERT INTO ingredient(name, quantity)
VALUES
    ('Вода', 10),
    ('Кофе', 10),
    ('Молоко', 10),
    ('Шоколад', 10)
ON CONFLICT DO NOTHING;