DROP TABLE IF EXISTS breeds;
CREATE TABLE breeds
(
    id   SERIAL PRIMARY KEY,
    breed_name VARCHAR(255) NOT NULL
);
CREATE UNIQUE index breeds_name on breeds (breed_name);
INSERT INTO breeds (breed_name)
VALUES('German Shepherd');

DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    photo_url  VARCHAR(255) NOT NULL,
    breed   INTEGER NOT NULL REFERENCES breeds (id),
    sex        VARCHAR(255) NOT NULL
);
INSERT INTO dogs (first_name, last_name, photo_url, breed, sex)
VALUES ('Mando', 'Partain', 'https://i.ibb.co/3mYDnkx/mandopuppy.jpg', 1, 'Male');
