-- Use the vehicle database
USE vehicle_db;

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
    (3, 2021, 2000, NOW(), 20000, 'Honda', 'Civic', 'GHI789', 'AUTOMOVIL', NOW(), 420, 5, 4, 'SEDAN'),
    (5, 2022, 1800, NOW(), 10000, 'Hyundai', 'Tucson', 'MNO345', 'AUTOMOVIL', NOW(), 620, 5, 5, 'SUV'),
    (6, 2021, 1500, NOW(), 15000, 'Chevrolet', 'Spark', 'PQR678', 'AUTOMOVIL', NOW(), 280, 4, 5, 'HATCHBACK'),
    (7, 2020, 3500, NOW(), 30000, 'Ford', 'Mustang', 'STU901', 'AUTOMOVIL', NOW(), 382, 4, 2, 'DEPORTIVO');

-- Insert sample data into camion table
INSERT INTO camion (id, anio, cilindrada, created_at, kilometraje, marca, modelo, patente, tipo, updated_at, cantidad_ejes, capacidad_toneladas, tipo_camion)
VALUES
    (2, 2018, 2500, NOW(), 80000, 'Ford', 'Ranger', 'DEF456', 'CAMION', NOW(), 2, 1.2, 1),
    (4, 2019, 3000, NOW(), 60000, 'Volvo', 'FH', 'JKL012', 'CAMION', NOW(), 3, 20.5, 3),
    (8, 2020, 2800, NOW(), 50000, 'Mercedes-Benz', 'Actros', 'VWX234', 'CAMION', NOW(), 4, 40.0, 4),
    (9, 2021, 3200, NOW(), 25000, 'Scania', 'R450', 'YZA567', 'CAMION', NOW(), 3, 25.0, 3),
    (10, 2017, 2600, NOW(), 120000, 'Iveco', 'Daily', 'BCD890', 'CAMION', NOW(), 2, 3.5, 2);

-- Update the IDs to continue the sequence
ALTER TABLE vehiculo AUTO_INCREMENT = 11;
ALTER TABLE automovil AUTO_INCREMENT = 11;
ALTER TABLE camion AUTO_INCREMENT = 11;