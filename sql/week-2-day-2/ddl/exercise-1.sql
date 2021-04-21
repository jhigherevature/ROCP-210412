CREATE SCHEMA library

CREATE TABLE library.writer (
    writer_id SERIAL PRIMARY KEY,
    writer_name VARCHAR(50)
)

CREATE TABLE library.books (
    book_id INTEGER PRIMARY KEY,
    title VARCHAR(200),
    author INTEGER,
    publication INTEGER,
    page_count INTEGER,
    CONSTRAINT fk_writer
        FOREIGN KEY(author)
            REFERENCES writer(writer_id)
)
;