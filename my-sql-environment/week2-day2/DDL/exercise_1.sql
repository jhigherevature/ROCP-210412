CREATE TABLE Writer (
	writer_id int,
	writer_name varchar(220)
);

INSERT INTO Writer VALUES (1001, 'Ahatha Christie');
INSERT INTO Writer VALUES (1002, 'George Orwell');
INSERT INTO Writer VALUES (1003, 'Kurt Vonnegut');
INSERT INTO Writer VALUES (1004, 'Mark Twain');
INSERT INTO Writer VALUES (1005, 'Stephen King');


CREATE TABLE Books (
	book_id int,
	title varchar(220),
	author int,
	PUBLICATION int,
	page_count int
);

	