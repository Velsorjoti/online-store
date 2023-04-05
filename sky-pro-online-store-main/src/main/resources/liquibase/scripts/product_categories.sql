-- liquibase formatted sql


-- changeset V:3
create table product_categories
(
    categories_id bigint NOT NULL REFERENCES category(id),
    product_id   bigint NOT NULL REFERENCES product(id),
    PRIMARY KEY (product_id, categories_id)
);
