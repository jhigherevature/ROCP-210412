ALTER TABLE bookstore.writer RENAME TO author;
ALTER TABLE bookstore.author RENAME writer_id TO author_id;
ALTER TABLE bookstore.author RENAME writer_name TO author_name;