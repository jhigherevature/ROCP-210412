CREATE schema DDL;



create table DDL.books(
	
	writer_id int,
	writer_name varchar(50)

);


create table DDL.writer1(
	
	book_id int,
	book_title varchar(255),
	book_author int,
	book_pubdate int,
	book_pages int

);

ALTER table DDL.writer
	RENAME  COLUMN book_id TO isbn_3;

alter table DDL.books
	rename to Author;

alter table DDL.Author 
	rename column writer_id to author_id;
alter table DDL.Author
	rename column writer_name to author_name;



insert into DDL.author
	values (1002, 'Tomas Gonzalez');

insert into DDL.writer
	values (3070, 'Im am Crazy', 2020,300);

delete from DDL.writer where book_pubdate = 1002;
	

update DDL.writer 
set book_pages = (220)
where book_title = 'Slaughter-Hous 5' ;


	
	
	
	
	
	
	
	
	values ()

