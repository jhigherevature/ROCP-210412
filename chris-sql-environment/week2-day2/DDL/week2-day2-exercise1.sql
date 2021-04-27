CREATE SCHEMA authorbooks;

CREATE TABLE authorbooks.writer (

writer_id integer,
writer_name varchar(60)
);

INSERT INTO authorbooks.writer VALUES (1001, 'Agatha Christie');
INSERT INTO authorbooks.writer VALUES (1002, 'George Orwell');
INSERT INTO authorbooks.writer VALUES (1003, 'Kurt Vonnegut');
INSERT INTO authorbooks.writer VALUES (1004, 'Mark Twain');
INSERT INTO authorbooks.writer VALUES (1005, 'Stephen King');

CREATE TABLE authorbooks.books (

book_id integer,
title varchar(240),
author integer,
publisher varchar(240),
page_count integer
);

ALTER TABLE authorbooks.books RENAME COLUMN book_id TO isbn_13; 