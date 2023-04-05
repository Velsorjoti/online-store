-- liquibase formatted sql


-- changeset V:2
create table category
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);


