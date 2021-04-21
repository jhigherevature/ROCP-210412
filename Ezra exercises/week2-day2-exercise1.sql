CREATE SCHEMA exercises;
DROP TABLE exercises.Writer;
DROP TABLE exercises.Books;

CREATE TABLE exercises.Writer (
	writer_id serial PRIMARY KEY,
	writer_name varchar(50)
);

INSERT INTO exercises.Writer VALUES (default, 'Agatha Christie');
INSERT INTO exercises.Writer VALUES (default, 'George Orwell');
INSERT INTO exercises.Writer VALUES (default, 'Kurt Vonnegut');
INSERT INTO exercises.Writer VALUES (default, 'Mark Twain');
INSERT INTO exercises.Writer VALUES (default, 'Stephen King');

SELECT * FROM exercises.Writer;

CREATE TABLE exercises.Books (
	book_id serial PRIMARY KEY,
	title varchar(200),
	author integer REFERENCES exercises.Writer(writer_id),
	publication_year integer,
	page_count integer
);

INSERT INTO exercises.books VALUES (DEFAULT ,'Murder on the Orient Express' ,1 ,1934, 256);
INSERT INTO exercises.books VALUES (default,'It',5,1986,1138);
INSERT INTO exercises.Books VALUES (default,'And Then There Were None',1,1939,272);
INSERT INTO exercises.Books VALUES (default,'Pet Sematary',5,1983,373);
INSERT INTO exercises.Books VALUES (default,'Slaughterhouse-Five',3,1969,215);
INSERT INTO exercises.Books VALUES (default,'Nineteen Eighty-Four',2,1949,328);
INSERT INTO exercises.Books VALUES (default,'Adventures of Huckleberry Finn',4,1884,366);
INSERT INTO exercises.Books VALUES (default,'Death on the Nile',1,1937,288);
INSERT INTO exercises.Books VALUES (default,'Animal Farm',2,1945,112);
INSERT INTO exercises.Books VALUES (default,'The Adventures of Tom Sawyer',4,1876,274);
INSERT INTO exercises.Books VALUES (default,'The Shining',5,1977,447);
INSERT INTO exercises.Books VALUES (default,e'Salem\'s Lot',5,1975,439);
INSERT INTO exercises.Books VALUES (default,'Cat''s Cradle',3,1963,304);	
