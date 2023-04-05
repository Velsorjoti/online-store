-- liquibase formatted sql


-- changeset V:1
create table product
(
    id                BIGSERIAL PRIMARY KEY,
    name              VARCHAR(255),
    created_date      TIMESTAMP,
    description       VARCHAR(255),
    modification_date TIMESTAMP
);


