CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  price VARCHAR(255),
  featured BOOLEAN,
  category_name VARCHAR(255)
)