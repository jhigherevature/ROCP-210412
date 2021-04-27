ALTER TABLE authorbooks.writer RENAME TO author;
ALTER COLUMN authorbooks.writer RENAME writer_id TO author_id;
ALTER COLUMN authorbooks.writer RENAME writer_name TO author_name;