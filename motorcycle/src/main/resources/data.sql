DROP TABLE IF EXISTS motorcycle;
CREATE TABLE motorcycle (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            type VARCHAR(50),
                            engine_capacity BIGINT,
                            start_type VARCHAR(50),
                            kilometers_driven DOUBLE,
                            is_used BOOLEAN,
                            abs BOOLEAN,
                            top_speed BIGINT,
                            price DECIMAL(10, 2)
);

INSERT INTO motorcycle (type, engine_capacity, start_type, kilometers_driven, is_used, abs, top_speed, price) VALUES
                                                                                                                  ('Cruiser', 883, 'Electric', 12000.5, true, true, 170, 45000.00),
                                                                                                                  ('Sport', 1000, 'Kick', 8000.0, false, false, 250, 60000.00),
                                                                                                                  ('Touring', 1200, 'Electric', 5000.0, false, true, 220, 85000.00),
                                                                                                                  ('Standard', 750, 'Kick', 18000.2, true, false, 200, 40000.00),
                                                                                                                  ('Adventure', 650, 'Electric', 9000.0, true, true, 180, 55000.00),
                                                                                                                  ('Dual-Sport', 500, 'Kick', 7000.8, true, false, 160, 35000.00),
                                                                                                                  ('Scooter', 150, 'Electric', 3000.0, false, false, 100, 15000.00),
                                                                                                                  ('Dirt Bike', 450, 'Kick', 500.5, false, false, 140, 28000.00),
                                                                                                                  ('Touring', 1800, 'Electric', 15000.7, true, true, 210, 110000.00),
                                                                                                                  ('Sport', 600, 'Electric', 2200.0, false, true, 240, 50000.00);