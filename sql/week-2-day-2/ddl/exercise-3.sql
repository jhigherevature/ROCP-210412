ALTER TABLE library.writer RENAME TO author;
ALTER TABLE library.author RENAME writer_name TO author_name;
ALTER TABLE library.author RENAME writer_id TO author_id;