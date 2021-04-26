SELECT author
FROM 
(SELECT author, avg(page_count)
FROM Books
GROUP BY author
ORDER BY avg(page_count) ASC) avg_author_page
LIMIT 1;