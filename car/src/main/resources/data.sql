DROP TABLE IF EXISTS Car;
CREATE TABLE Car (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     brand VARCHAR(50),
                     model VARCHAR(50),
                     car_year INT,
                     color VARCHAR(30),
                     is_used BOOLEAN,
                     mileage INT,
                     price DECIMAL(10, 2)
);

INSERT INTO Car (brand, model, car_year, color, is_used, mileage, price) VALUES
                                                                             ('Toyota', 'Corolla', 2020, 'White', false, 5000, 75000.00),
                                                                             ('Honda', 'Civic', 2019, 'Black', true, 30000, 68000.00),
                                                                             ('Ford', 'Mustang', 2022, 'Red', false, 1200, 120000.00),
                                                                             ('Chevrolet', 'Camaro', 2021, 'Blue', true, 15000, 110000.00),
                                                                             ('BMW', 'X5', 2018, 'Silver', true, 45000, 180000.00),
                                                                             ('Mercedes', 'C-Class', 2023, 'Gray', false, 500, 250000.00),
                                                                             ('Audi', 'A4', 2020, 'Black', true, 25000, 95000.00),
                                                                             ('Volkswagen', 'Golf', 2019, 'White', true, 22000, 72000.00),
                                                                             ('Hyundai', 'Tucson', 2021, 'Green', false, 8000, 85000.00),
                                                                             ('Nissan', 'Altima', 2018, 'Red', true, 50000, 60000.00);