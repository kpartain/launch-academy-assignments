CREATE TABLE quotes (
  id SERIAL PRIMARY KEY,
  quote TEXT,
  author VARCHAR(255),
  subject VARCHAR(255)
);
CREATE TABLE authors (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255)
);

