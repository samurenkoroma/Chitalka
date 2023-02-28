--liquibase formatted sql

--changeset samurenkoroma:1
CREATE TABLE IF NOT EXISTS books
(
    id      BIGSERIAL PRIMARY KEY,
    title   VARCHAR(250) NOT NULL,
    content TEXT,
    path    VARCHAR(250)
);

--rollback DROP TABLE books;
