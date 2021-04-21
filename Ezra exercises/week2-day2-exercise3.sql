/*Given the following tables, provide an SQL Statement that will change the name of the "Writer" table to "Author". 
 * Next, provide statements that will rename the writer_id and writer_name columns to 
 */author_id and author_name respectively.
 
ALTER TABLE exercises.writer RENAME TO Author; --NOTHING seems TO WORK

ALTER TABLE exercises.author RENAME COLUMN writer_id TO author_id;
ALTER TABLE exercises.author RENAME COLUMN writer_name TO author_name;

