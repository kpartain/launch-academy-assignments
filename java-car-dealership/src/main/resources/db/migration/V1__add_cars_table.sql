CREATE TABLE car_dealership (
id SERIAL PRIMARY KEY,
vin VARCHAR(20) NOT NULL,
year INT NOT NULL,
MAKE VARCHAR(255) NOT NULL,
price INT NOT NULL,
model VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX car_vin ON car_dealership(vin);