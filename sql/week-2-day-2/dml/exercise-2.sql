INSERT INTO library.books 
VALUES (DEFAULT, 'Homage To Catalonia', (SELECT author_id from library.author WHERE author_name = 'George Orwell'), 1938, 368);