/* DML
 Exercise One
Given the following tables, provide an SQL Statement that would add a new record to the Author's table. 
*/
INSERT INTO exercises.author VALUES (DEFAULT, 'John Adams');  --TO WORK need TO CHANGE author TO writer

--# Exercise Two
--Given the following tables, provide an SQL Statement that would add a new book 
--written by George Orwell. You can assume that the Books table uses the Serial Datatype for the 
--Book_id column.
INSERT INTO exercises.books VALUES (DEFAULT, 'book by George Orwell', 2, 1956, 101);


--# Exercise Three
--Given the following tables, provide an SQL Statement that will remove all books written by Mark Twain.
DELETE FROM exercises.books WHERE author = 4;
SELECT * FROM exercises.books DELETE WHERE author =4; --ALSO WORK?
--# Exercise Four
--Given the following tables, provide an SQL Statement that will update the page count of Slaughterhouse-Five to 220.
UPDATE exercises.Books SET page_count = 220 WHERE title = 'Slaughterhouse-Five';

