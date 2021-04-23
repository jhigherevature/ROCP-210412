--exercise 1
--Given the following tables, provide an SQL statement that will return the total page count of all books 
--written by Stephen King.

SELECT sum (page_count) FROM exercises.books;

--# Exercise Two
--Given the following tables, provide an SQL statement that will return all books which were published between 
--1900 and 1950.

SELECT title FROM exercises.books WHERE publication_year BETWEEN 1900 AND 1950;

--Given the following tables, provide an SQL statement that will find the author whose books have the lowest average page count.
SELECT author, page_count OVER (PARTITION BY author) FROM exercises.books;
FROM exercises.books WHERE avg(page_count) GROUP BY author;



--CREATE TABLE Author (
--author_id serial PRIMARY key,
--author_name varchar(20)
--);
--
--INSERT INTO Author VALUES ((DEFAULT, Agatha Christie), (DEFAULT, George Orwell),
--(DEFAULT, 'Kurt Vonnegut'), (DEFAULT, 'Mark Twain'), (1005,'Stephen King'));
--
--Books
--|book_id|title|author|publication|page_count|
--|-|-|-|-|-|
--|3050|Murder on the Orient Express|1001|1934|256|
--|3051|It|1005|1986|1138|
--|3052|And Then There Were None|1001|1939|272|
--|3053|Pet Sematary|1005|1983|373|
--|3054|Slaughterhouse-Five|1003|1969|215|
--|3055|Nineteen Eighty-Four|1002|1949|328|
--|3056|Adventures of Huckleberry Finn|1004|1884|366|
--|3057|Death on the Nile|1001|1937|288|
--|3058|Animal Farm|1002|1945|112|
--|3059|The Adventures of Tom Sawyer|1004|1876|274|
--|3060|The Shining|1005|1977|447|
--|3061|Salem's Lot|1005|1975|439|
--|3062|Cat's Cradle|1003|1963|304|