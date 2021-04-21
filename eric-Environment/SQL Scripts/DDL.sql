CREATE TABLE Writer(
	writer_id integer PRIMARY key,
	writer_name varchar(100) CHECK (length(writer_name) > 1);
);

INSERT INTO examples.Writer (1001, Agatha Christie)
INSERT INTO examples.Writer (1002, George Orwell)
INSERT INTO examples.Writer (1003, Kurt Vonnegut)
INSERT INTO examples.Writer (1004, Mark Twain)
INSERT INTO examples.Writer (1005, Stephen King)

CREATE TABLE Books (
		book_id integer PRIMARY key,
		title varchar(100),
		writer integer,
		publisher varchar(100),
		page_count integer
		CONSTRAINT Books_fk FOREIGN KEY author REFERENCES Writer(writer_id) ON DELETE RESTRICT
);

INSERT INTO examples.Books (3050, 'Murder on the Orient Express', 1001, 1934 256);
INSERT INTO examples.Books (3051, 'It', 1005, 1986, 1138);
INSERT INTO examples.Books (3052, 'And Then There Were None', 1001, 1939, 272)
INSERT INTO examples.Books (3053, 'Pet Sematary', 1005, 1983, 373)
INSERT INTO examples.Books (3054, 'Slaughterhouse-Five', 1003, 1969, 215)
INSERT INTO examples.Books (3055, 'Nineteen Eighty-Four', 1002, 1949, 328)
INSERT INTO examples.Books (3056, 'Adventures of Huckleberry Finn', 1004, 1884, 366)
INSERT INTO examples.Books (3057, 'Death on the Nile', 1001, 1937, 288)
INSERT INTO examples.Books (3059, 'The Adventures of Tom Sawyer', 1004, 1876, 274)
INSERT INTO examples.Books (3060, 'The Shining', 1005, 1977, 447);
INSERT INTO examples.Books (3061, 'Salems Lot', 1005, 1975, 439);
INSERT INTO examples.Books (3062, 'Cats Cradle', 1003, 1963, 304);--getting apostraphies was unclear ON google

/*
 * exercise 2
 */

ALTER TABLE examples.Books RENAME column book_id TO isbn_13;

/*
 * exercise 3
 */

ALTER TABLE examples.Writer RENAME TO Author;

ALTER TABLE examples.Writer RENAME COLUMN writer_id TO author_id;
ALTER TABLE examples.Books RENAME COLUMN writer TO author;
