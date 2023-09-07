INSERT INTO coffee(name)
VALUES
    ('Эспрессо'),
    ('Американо'),
    ('Капучино'),
    ('Мокко')
ON CONFLICT DO NOTHING;