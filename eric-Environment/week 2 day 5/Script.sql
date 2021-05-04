--excercise 1 i messed up my column labels, put in author names where their id should go, hence I put in Stephen King instead of a #
select sum(page_count) from book where author = 'Stephen King';

--excercise 2
select title from book where published between 1900 and 1950;

--excercise 3
select author from book group by author having avg(page_count) < (select avg(page_count) from book);
