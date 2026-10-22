-- Schemat bazy danych MushroomAtlas (PostgreSQL).
-- Uruchom na pustej bazie mushroom_atlas:
--   createdb mushroom_atlas
--   psql -d mushroom_atlas -f db/schema.sql

-- Tabele słownikowe - odpowiadają enumom Edibility i Hymenophore.
-- Kolumna number = getNumber() z enuma, code = nazwa stałej.
CREATE TABLE edibility (
    number      INT PRIMARY KEY,
    code        TEXT NOT NULL UNIQUE,
    description TEXT NOT NULL
);

CREATE TABLE hymenophore (
    number      INT PRIMARY KEY,
    code        TEXT NOT NULL UNIQUE,
    description TEXT NOT NULL
);

CREATE TABLE mushroom (
    id             INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name           TEXT NOT NULL UNIQUE,
    description    TEXT NOT NULL,
    edibility_id   INT NOT NULL REFERENCES edibility (number),
    hymenophore_id INT NOT NULL REFERENCES hymenophore (number)
);

INSERT INTO edibility (number, code, description) VALUES
    (1, 'EDIBLE',    'jadalny'),
    (2, 'INEDIBLE',  'niejadalny'),
    (3, 'POISONOUS', 'trujący');

INSERT INTO hymenophore (number, code, description) VALUES
    (1, 'POROID',    'hymenophor rurkowy'),
    (2, 'GILLED',    'hymenophor blaszkowy'),
    (3, 'TOOTHED',   'hymenophor kolczasty'),
    (4, 'GASTEROID', 'brak hymenophoru');
