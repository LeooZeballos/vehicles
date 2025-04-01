-- Create the database
CREATE DATABASE IF NOT EXISTS vehicle_db;
USE vehicle_db;

-- User table
create table if not exists _user
(
    id                      bigint       not null
        primary key,
    account_non_expired     bit          not null,
    account_non_locked      bit          not null,
    created_at              datetime(6)  not null,
    credentials_non_expired bit          not null,
    email                   varchar(255) not null,
    enabled                 bit          not null,
    password                varchar(255) not null,
    username                varchar(255) not null,
    constraint UK3xhbjqvaggiuydvv84k4h6iq8
        unique (username, email),
    constraint UKk11y3pdtsrjgy8w9b6q4bjwrx
        unique (email)
);

-- User roles table
create table if not exists user_role
(
    user_id bigint                 not null,
    roles   enum ('ADMIN', 'USER') null,
    constraint FKniaqoclrvx138sjw9hsollqav
        foreign key (user_id) references _user (id)
);

-- Vehicle base table
create table if not exists vehiculo
(
    id          int          not null
        primary key,
    anio        int          null,
    cilindrada  int          null,
    created_at  datetime(6)  null,
    kilometraje int          null,
    marca       varchar(255) null,
    modelo      varchar(255) null,
    patente     varchar(255) null,
    tipo        varchar(255) null,
    updated_at  datetime(6)  null
);

-- Automobile specific attributes
create table if not exists automovil
(
    id                  int          not null
        primary key,
    anio                int          null,
    cilindrada          int          null,
    created_at          datetime(6)  null,
    kilometraje         int          null,
    marca               varchar(255) null,
    modelo              varchar(255) null,
    patente             varchar(255) null,
    tipo                varchar(255) null,
    updated_at          datetime(6)  null,
    capacidad_maletero  int          null comment 'Capacidad del maletero en litros',
    capacidad_pasajeros int          null,
    num_puertas         int          null,
    tipo_auto           varchar(255) null
);

-- Truck specific attributes
create table if not exists camion
(
    id                  int          not null
        primary key,
    anio                int          null,
    cilindrada          int          null,
    created_at          datetime(6)  null,
    kilometraje         int          null,
    marca               varchar(255) null,
    modelo              varchar(255) null,
    patente             varchar(255) null,
    tipo                varchar(255) null,
    updated_at          datetime(6)  null,
    cantidad_ejes       int          null,
    capacidad_toneladas double       null,
    tipo_camion         tinyint      null,
    check (`tipo_camion` between 0 and 5)
);
