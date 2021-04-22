create schema DQL;

create table DQL.Author(

	author_id int,
	author_name varchar(100)

);

create table DQL.books( 

	book_id int,
	book_title varchar(200),
	book_author int,
	book_pubdate int,
	book_pages int

);

insert into DQL.Author VALUES (1001, 'Agathe Christie');
insert into DQL.Author VALUES (1002, 'George Orwell');
insert into DQL.Author VALUES (1003, 'Kurt Vonnegut');
insert into DQL.Author VALUES (1004, 'Mark Twain');
insert into DQL.Author VALUES (1005, 'Stephen King');


insert into DQL.books values (3050, 'Murder on the orient Express', 1001, 1934, 256);
insert into DQL.books values (3051, 'It', 1005, 1986, 1354);
insert into DQL.books values (3052, 'And Then There Were None', 1001, 1939, 235);
insert into DQL.books values (3053, 'Pet Sematary', 1005, 1983, 1546);
insert into DQL.books values (3054, 'Sluaghter-House Five', 1003, 1969, 145);
insert into DQL.books values (3055, 'Nineteen Eighty-four', 1002, 1949, 78);
insert into DQL.books values (3056, 'Advendtures of Huckleberry Finn', 1004, 1884, 135);
insert into DQL.books values (3057, 'Death On The Nile', 1001, 1937, 986);
insert into DQL.books values (3058, 'Animal Farm', 1002, 1945, 563);
insert into DQL.books values (3059, 'The Adventures of Tom Soyer', 1004, 1876, 12);
insert into DQL.books values (3060, 'The Shining', 1005, 1977, 147);
insert into DQL.books values (3061, 'Salems Lot', 1005, 1975, 584);
insert into DQL.books values (3062, 'Cats Cradle', 1003, 1963, 2343);

	
select book_author, sum(book_pages) from DQL.books 
where book_author = 1005 group by book_author; 



select book_title from DQL.books
where book_pubdate between 1900 and 1950;

select book_author, avg(book_pages) from DQL.books
where book_pages < 1500 group by book_author
having avg(book_pages) = min(book_pages);
 

