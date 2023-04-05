-- liquibase formatted sql


-- changeset V:1
create table product
(
    id                BIGSERIAL NOT NULL PRIMARY KEY,
    name              VARCHAR(255)
    creation_date     TIMESTAMP,
    description       VARCHAR(255),
    modification_date TIMESTAMP
);


