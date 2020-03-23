CREATE DATABASE ice;

CREATE SCHEMA stockmarket;

CREATE TABLE stockmarket.cusips
(
    cusip_id varchar(8) PRIMARY KEY,
    price numeric,
    created_at timestamp NOT NULL DEFAULT now(),
    updated_at timestamp NOT NULL DEFAULT now()
);

CREATE USER java_app WITH PASSWORD 'java';

GRANT USAGE ON SCHEMA stockmarket TO java_app;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA stockmarket TO java_app;

GRANT USAGE ON ALL SEQUENCES IN SCHEMA stockmarket TO java_app;
