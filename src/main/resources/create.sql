CREATE DATABASE internet_shop_repository;
DROP SCHEMA IF EXISTS shop;
CREATE SCHEMA shop;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255),
    price numeric(6, 2),
    is_deleted BOOLEAN
);
INSERT INTO products (title, price, is_deleted)
VALUES ('Компьютер', 879.90,false),
       ('Планшет', 524.90,false),
       ('Мышь', 20.00,false),
       ('Зарядное устройство', 9.99,false),
       ('Коврик для мыши', 3.90,false);


DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id   bigserial PRIMARY KEY,
    name VARCHAR(255)
);
INSERT INTO users (name)
VALUES ('Bob'),
       ('Alex'),
       ('Mike');

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders
(
    id      bigserial PRIMARY KEY,
    id_user INT REFERENCES users (id) ON DELETE CASCADE

);
INSERT INTO orders (id_user)
VALUES (1),
       (2),
       (1),
       (2),
       (3);

DROP TABLE IF EXISTS products_in_order CASCADE;
CREATE TABLE products_in_order
(
    id_order   INT REFERENCES orders (id) ON DELETE CASCADE,
    id_product INT REFERENCES products (id) ON DELETE CASCADE,
    quantity   INT,
    price      numeric(6, 2),
    PRIMARY KEY (id_order, id_product)
);

INSERT INTO products_in_order (id_order, id_product, quantity, price)
VALUES (1, 1, 1, 879.90),
       (1, 2, 1, 524.90),
       (3, 2, 1, 624.90);





