CREATE SCHEMA writers;

CREATE TABLE writers.writers (
writer_id integer,
writer_name varchar(30)
);

CREATE TABLE writers.books (
book_id integer,
title varchar(200),
author integer,
book_publication integer,
page_count integer
);