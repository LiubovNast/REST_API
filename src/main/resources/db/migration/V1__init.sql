CREATE TABLE cities
(
    id   serial primary key,
    name text not null unique
);

CREATE TABLE streets
(
    id   serial primary key,
    name text not null
);

CREATE TABLE numbers_of_houses
(
    id     serial primary key,
    number text not null
);

CREATE TABLE addresses
(
    id             serial primary key,
    city_id        bigint references cities (id),
    street_id      bigint references streets (id),
    houseNumber_id bigint references numbers_of_houses (id)
);

CREATE TABLE users
(
    id          serial primary key,
    name        text not null,
    age         int  not null,
    dateOfBirth date not null,
    address_id  bigint references addresses (id)
);