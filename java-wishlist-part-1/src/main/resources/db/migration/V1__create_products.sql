CREATE TABLE products (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
price DOUBLE PRECISION NOT NULL,
url VARCHAR(255),
category_id int REFERENCES categories(id)
UNIQUE(name)
);