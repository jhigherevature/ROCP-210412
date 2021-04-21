CREATE SCHEMA bookstore;

CREATE TABLE bookstore.Writer (
	writer_id serial unique NOT NULL PRIMARY key,
	writer_name varchar(50)
);

CREATE TABLE bookstore.Books (
	book_id serial PRIMARY KEY,
	title varchar(50),
	author integer,
	FOREIGN KEY (author) REFERENCES bookstore.writer(writer_id) ON DELETE RESTRICT,
	"publication" integer CHECK ("publication" BETWEEN 0 AND 2050),
	page_count integer CHECK (page_count > 0)
);

BEGIN;
	INSERT INTO bookstore.Writer VALUES (1001, 'Agatha Christie');
	INSERT INTO bookstore.Writer VALUES (1002, 'George Orwell');
	INSERT INTO bookstore.Writer VALUES (1003, 'Kurt Vonnegut');
	INSERT INTO bookstore.Writer VALUES (1004, 'Mark Twain');
	INSERT INTO bookstore.Writer VALUES (1005, 'Stephen King');
	INSERT INTO bookstore.Books VALUES (3050, 'Murder on the Orient Express', 1001, 1934, 256);
COMMIT;