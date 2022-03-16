DROP SCHEMA IF EXISTS eros CASCADE;
CREATE SCHEMA IF NOT EXISTS eros;

CREATE TABLE eros.categories (
    category_id SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    is_active   BOOLEAN      NOT NULL,
    created_at  DATE NULL,
    updated_at  DATE NULL
);

CREATE TABLE eros.products (
    product_id  SERIAL PRIMARY KEY,
    name        VARCHAR(80)    NOT NULL,
    description VARCHAR(255)   NOT NULL,
    category_id INTEGER NULL,
    size        VARCHAR(5)     NOT NULL,
    value       NUMERIC(19, 2) NOT NULL,
    is_active   BOOLEAN        NOT NULL,
    created_at  DATE NULL,
    updated_at  DATE NULL
);

CREATE TABLE eros.subcategories (
    subcategory_id SERIAL PRIMARY KEY,
    name           VARCHAR(80)  NOT NULL,
    description    VARCHAR(255) NOT NULL,
    is_active      BOOLEAN      NOT NULL,
    created_at     DATE NULL,
    updated_at     DATE NULL
);

CREATE TABLE eros.users (
    user_id    SERIAL PRIMARY KEY,
    nome       VARCHAR(150) NOT NULL,
    username   VARCHAR(30) NULL,
    passcode   VARCHAR(255) NOT NULL,
    is_admin   BOOLEAN      NOT NULL,
    email      VARCHAR(255) NOT NULL,
    cpf        VARCHAR(11)  NOT NULL,
    created_at DATE NULL,
    updated_at DATE NULL
);

COMMIT;

