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
INSERT INTO vehiculo (id, anio, cilindrada, created_at, kilometraje, marca, modelo, patente, updated_at)
VALUES
    (1, 2020, 1600, NOW(), 45000, 'Toyota', 'Corolla', 'ABC123', NOW()),
    (2, 2018, 2500, NOW(), 80000, 'Ford', 'Ranger', 'DEF456', NOW()),
    (3, 2021, 2000, NOW(), 20000, 'Honda', 'Civic', 'GHI789', NOW()),
    (4, 2019, 3000, NOW(), 60000, 'Volvo', 'FH', 'JKL012', NOW()),
    (5, 2022, 1800, NOW(), 10000, 'Hyundai', 'Tucson', 'MNO345', NOW());

-- Insert sample data into automovil table
INSERT INTO automovil (id, anio, cilindrada, created_at, kilometraje, marca, modelo, patente, updated_at, capacidad_maletero, capacidad_pasajeros, num_puertas, tipo_auto)
VALUES
    (6, 2020, 1600, NOW(), 45000, 'Toyota', 'Corolla', 'DFE123', NOW(), 470, 5, 4, 0),
    (7, 2021, 2000, NOW(), 20000, 'Honda', 'Civic', 'GSD789', NOW(), 420, 5, 4, 1),
    (8, 2022, 1800, NOW(), 10000, 'Hyundai', 'Tucson', 'MAS345', NOW(), 620, 5, 5, 2),
    (9, 2021, 1500, NOW(), 15000, 'Chevrolet', 'Spark', 'PQR678', NOW(), 280, 4, 5, 3),
    (10, 2020, 3500, NOW(), 30000, 'Ford', 'Mustang', 'STU901', NOW(), 382, 4, 2, 4);

-- Insert sample data into camion table
INSERT INTO camion (id, anio, cilindrada, created_at, kilometraje, marca, modelo, patente, updated_at, cantidad_ejes, capacidad_toneladas, tipo_camion)
VALUES
    (11, 2018, 2500, NOW(), 80000, 'Ford', 'Ranger', 'DEF456', NOW(), 2, 1.2, 0),
    (12, 2019, 3000, NOW(), 60000, 'Volvo', 'FH', 'JKL012', NOW(), 3, 20.5, 1),
    (13, 2020, 2800, NOW(), 50000, 'Mercedes-Benz', 'Actros', 'VWX234', NOW(), 4, 40.0, 2),
    (14, 2021, 3200, NOW(), 25000, 'Scania', 'R450', 'YZA567', NOW(), 3, 25.0, 3),
    (15, 2017, 2600, NOW(), 120000, 'Iveco', 'Daily', 'BCD890', NOW(), 2, 3.5, 4);

INSERT INTO mantenimiento (id, created_at, observaciones, tipo_mantenimiento, updated_at, vehiculo_id) VALUES
(1, '2023-01-05 08:30:00', 'Cambio de aceite y filtro', 0, '2023-01-05 10:00:00', 1),
(2, '2023-04-12 14:15:00', 'Revisión de frenos', 0, '2023-04-12 15:30:00', 1),
(3, '2023-09-20 09:45:00', 'Reparación de suspensión', 1, '2023-09-21 11:20:00', 1),
(4, '2023-02-18 11:00:00', 'Rotación de neumáticos', 0, '2023-02-18 12:15:00', 2),
(5, '2023-03-10 13:30:00', 'Diagnóstico de motor', 2, '2023-03-10 14:45:00', 3),
(6, '2023-05-22 10:20:00', 'Cambio de correa de distribución', 0, '2023-05-22 13:00:00', 3),
(7, '2023-07-15 16:00:00', 'Reparación de transmisión', 1, '2023-07-17 09:30:00', 3),
(8, '2023-11-05 08:45:00', 'Limpieza de inyectores', 3, '2023-11-05 10:15:00', 3),
(9, '2023-06-08 09:15:00', 'Balanceo de ruedas', 0, '2023-06-08 10:30:00', 5),
(10, '2023-12-12 14:50:00', 'Reparación de escape', 1, '2023-12-13 16:20:00', 5),
(11, '2023-01-20 07:45:00', 'Cambio de bujías', 0, '2023-01-20 09:00:00', 6),
(12, '2023-03-25 12:30:00', 'Revisión eléctrica', 3, '2023-03-25 14:15:00', 6),
(13, '2023-05-30 15:20:00', 'Reparación de aire acondicionado', 1, '2023-05-31 10:45:00', 6),
(14, '2023-08-10 10:00:00', 'Análisis de vibraciones', 2, '2023-08-10 11:30:00', 6),
(15, '2023-10-15 16:45:00', 'Limpieza general', 3, '2023-10-15 18:00:00', 6),
(16, '2023-04-05 08:00:00', 'Cambio de líquido de frenos', 0, '2023-04-05 09:15:00', 7),
(17, '2023-02-10 13:15:00', 'Reparación de dirección', 1, '2023-02-11 14:30:00', 8),
(18, '2023-06-25 10:45:00', 'Revisión predictiva de motor', 2, '2023-06-25 12:00:00', 8),
(19, '2023-09-30 15:10:00', 'Cambio de filtro de combustible', 0, '2023-09-30 16:25:00', 8),
(20, '2023-07-12 11:30:00', 'Reparación de sistema de inyección', 1, '2023-07-13 09:45:00', 10),
(21, '2023-11-20 14:00:00', 'Monitoreo de desgaste', 2, '2023-11-20 15:15:00', 10),
(22, '2023-08-15 09:20:00', 'Cambio de aceite diferencial', 0, '2023-08-15 10:35:00', 11),
(23, '2023-01-25 16:30:00', 'Reparación de alternador', 1, '2023-01-26 10:45:00', 12),
(24, '2023-04-18 08:15:00', 'Diagnóstico computarizado', 2, '2023-04-18 09:30:00', 12),
(25, '2023-07-22 12:45:00', 'Limpieza de sistema de admisión', 3, '2023-07-22 14:00:00', 12),
(26, '2023-10-05 15:50:00', 'Cambio de amortiguadores', 0, '2023-10-05 17:05:00', 12),
(27, '2023-05-15 10:10:00', 'Reparación de parabrisas', 3, '2023-05-15 11:25:00', 13),
(28, '2023-03-08 14:20:00', 'Cambio de aceite de transmisión', 0, '2023-03-08 15:35:00', 14),
(29, '2023-06-10 09:30:00', 'Reparación de sistema de combustible', 1, '2023-06-12 11:45:00', 14),
(30, '2023-12-05 13:40:00', 'Análisis de emisiones', 2, '2023-12-05 14:55:00', 14)
;


# noinspection SqlWithoutWhere
UPDATE vehiculo_seq SET next_val = 16;
# noinspection SqlWithoutWhere
UPDATE _user_seq SET next_val = 2;
# noinspection SqlWithoutWhere
UPDATE mantenimiento_seq SET next_val = 31;
