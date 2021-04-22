ALTER TABLE Writers 
RENAME TO Author;

ALTER TABLE Author 
RENAME COLUMN writer_id TO author_name;

ALTER TABLE Author 
RENAME COLUMN writer_name TO author_name;