--
CREATE TABLE writer(
writer_id int PRIMARY KEY,
writer_name varchar(50)
);

CREATE TABLE books(
book_id serial PRIMARY KEY,
title varchar(50),
book_publicaton int,
page_count int,
writer_id int,
CONSTRAINT writer_id_fk FOREIGN KEY (writer_id) REFERENCES writer(writer_id)
);
--

INSERT INTO writer (writer_id ,writer_name) VALUES('1001','Agatha Christie');
INSERT INTO writer (writer_id ,writer_name) VALUES('1002','George Orwell');
INSERT INTO writer (writer_id ,writer_name) VALUES('1003','Kurt Vonnegut');
INSERT INTO writer (writer_id ,writer_name) VALUES('1004','Mark Twain');
INSERT INTO writer (writer_id ,writer_name) VALUES('1005','Stephen King');

--
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3050','Murder on the Orient Express','1934','256','1001') ;
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3051','It','1986','1138','1005');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3052','And Then There Were None','1939','272','1001');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3053','Pet Sematary','1983','373','1005');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3054','Slaughterhouse-Five','1969','215','1003');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3055','Nineteen Eighty-Foure','1949','1949','1002');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3056','Adventures of Huckleberry Finn','1884','366','1004');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3057','Death on the Nile','1937','288','1001');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3058','Animal Farm','1945','112','1002');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3059','The Adventures of Tom Sawyer','1876','274','1004');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3060','The Shining','1977','447','1005');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3061','Salem`s Lot','1975','439','1005');
--INSERT INTO books (book_id ,title,book_publicaton ,page_count,writer_id) VALUES('3062','TCat`s Cradle','1963','304','1003');


INSERT INTO books (title,book_publicaton,page_count,writer_id) VALUES (' A Clergyman`s Daughter','1935','192','1002');

SELECT * FROM writer;
--
SELECT * FROM books;
--
--
--SELECT * FROM author;
--
DELETE FROM books;
--
DROP TABLE books 
--
--
--ALTER TABLE "books" RENAME COLUMN "book_id" TO "isbn_13";
--
--
--ALTER TABLE writer RENAME TO author;
--ALTER TABLE "author" RENAME COLUMN "writer_id" TO "author_id";
--ALTER TABLE "author" RENAME COLUMN "writer_name" TO "author_name";
--

ALTER TABLE author RENAME TO writer;
ALTER TABLE "writer" RENAME COLUMN "author_id" TO "writer_id";
ALTER TABLE "writer" RENAME COLUMN "author_name" TO "writer_name";


--
--CREATE TABLE principal(
--principal_id serial PRIMARY KEY,
--principal_name varchar(50),
--hire_date date,
--salary decimal
--);
--
--CREATE TABLE schools(
--school_id int PRIMARY KEY,
--school_name varchar(50),
--principal_id int,
--CONSTRAINT principal_id_fk FOREIGN KEY (principal_id) REFERENCES principal(principal_id)
--);
--
--CREATE TABLE students(
--student_id int PRIMARY KEY,
--student_name varchar(50),
--home_address varchar(50),
--contact_phone int,
--grade int ,
--school_id int,
--CONSTRAINT school_id_fk FOREIGN KEY (school_id) REFERENCES schools(school_id)
--);
--
--SELECT *FROM principal;
--SELECT *FROM schools;
--SELECT *FROM students;




