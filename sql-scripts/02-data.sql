-- Use the vehicle database
USE vehicle_db;

-- Insert sample data into user table
INSERT INTO vehicle_db._user (id, account_non_expired, account_non_locked, created_at, credentials_non_expired, email, enabled, password, username)
VALUES
    (1, true, true, '2025-03-31 22:07:56.854318', true, 'leo@mail.com', true, '$2a$10$j5Lc.MzgDTtzt5v3liSLrusA3DnX7lqtsyCYCd9UNjbjCwmhf2z9K', 'leo');

-- Insert sample data into user_role table
INSERT INTO vehicle_db.user_role (user_id, roles)
VALUES
    (1, 'ADMIN');

-- Insert sample data into vehiculo table
INSERT INTO vehiculo (id, anio, cilindrada, created_at, kilometraje, marca, modelo, patente, tipo, updated_at)
VALUES
    (1, 2020, 1600, NOW(), 45000, 'Toyota', 'Corolla', 'ABC123', 'AUTOMOVIL', NOW()),
    (2, 2018, 2500, NOW(), 80000, 'Ford', 'Ranger', 'DEF456', 'CAMION', NOW()),
    (3, 2021, 2000, NOW(), 20000, 'Honda', 'Civic', 'GHI789', 'AUTOMOVIL', NOW()),
    (4, 2019, 3000, NOW(), 60000, 'Volvo', 'FH', 'JKL012', 'CAMION', NOW()),
    (5, 2022, 1800, NOW(), 10000, 'Hyundai', 'Tucson', 'MNO345', 'AUTOMOVIL', NOW());

-- Insert sample data into automovil table
INSERT INTO automovil (id, anio, cilindrada, created_at, kilometraje, marca, modelo, patente, tipo, updated_at, capacidad_maletero, capacidad_pasajeros, num_puertas, tipo_auto)
VALUES
    (1, 2020, 1600, NOW(), 45000, 'Toyota', 'Corolla', 'ABC123', 'AUTOMOVIL', NOW(), 470, 5, 4, 'SEDAN'),
    (2, 2021, 2000, NOW(), 20000, 'Honda', 'Civic', 'GHI789', 'AUTOMOVIL', NOW(), 420, 5, 4, 'SEDAN'),
    (3, 2022, 1800, NOW(), 10000, 'Hyundai', 'Tucson', 'MNO345', 'AUTOMOVIL', NOW(), 620, 5, 5, 'SUV'),
    (4, 2021, 1500, NOW(), 15000, 'Chevrolet', 'Spark', 'PQR678', 'AUTOMOVIL', NOW(), 280, 4, 5, 'HATCHBACK'),
    (5, 2020, 3500, NOW(), 30000, 'Ford', 'Mustang', 'STU901', 'AUTOMOVIL', NOW(), 382, 4, 2, 'DEPORTIVO');

-- Insert sample data into camion table
INSERT INTO camion (id, anio, cilindrada, created_at, kilometraje, marca, modelo, patente, tipo, updated_at, cantidad_ejes, capacidad_toneladas, tipo_camion)
VALUES
    (1, 2018, 2500, NOW(), 80000, 'Ford', 'Ranger', 'DEF456', 'CAMION', NOW(), 2, 1.2, 1),
    (2, 2019, 3000, NOW(), 60000, 'Volvo', 'FH', 'JKL012', 'CAMION', NOW(), 3, 20.5, 3),
    (3, 2020, 2800, NOW(), 50000, 'Mercedes-Benz', 'Actros', 'VWX234', 'CAMION', NOW(), 4, 40.0, 4),
    (4, 2021, 3200, NOW(), 25000, 'Scania', 'R450', 'YZA567', 'CAMION', NOW(), 3, 25.0, 3),
    (5, 2017, 2600, NOW(), 120000, 'Iveco', 'Daily', 'BCD890', 'CAMION', NOW(), 2, 3.5, 2);


-- Update the IDs to continue the sequence
ALTER TABLE vehicle_db.vehiculo AUTO_INCREMENT = 6;
ALTER TABLE vehicle_db.automovil AUTO_INCREMENT = 6;
ALTER TABLE vehicle_db.camion AUTO_INCREMENT = 6;
ALTER TABLE vehicle_db._user AUTO_INCREMENT = 2;
ALTER TABLE vehicle_db.user_role AUTO_INCREMENT = 2;