CREATE TABLE cities
(
    id   serial primary key,
    name text not null unique
);

CREATE TABLE streets
(
    id   serial primary key,
    name text not null unique
);

CREATE TABLE numbers_of_houses
(
    id     serial primary key,
    number text not null unique
);

CREATE TABLE addresses
(
    id             serial primary key,
    city_id        bigint references cities (id),
    street_id      bigint references streets (id),
    house_number_id bigint references numbers_of_houses (id)
);

CREATE TABLE users
(
    id          serial primary key,
    name        text not null,
    age         int  not null,
    date_of_birth date not null,
    address_id  bigint references addresses (id)
);