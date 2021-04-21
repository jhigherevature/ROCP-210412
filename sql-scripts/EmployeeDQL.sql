-- the '*' is a wildcard indicator for all columns
SELECT * FROM employees;

--WHERE
SELECT * FROM employees WHERE emp_id=1000; 
SELECT emp_name, emp_title FROM employees WHERE emp_id = 1002;

-- GROUP BY
SELECT emp_title FROM employees GROUP BY emp_title;
SELECT emp_title FROM employees;

-- HAVING
SELECT emp_title, sum(emp_salary) FROM examples.employees 
GROUP BY EMP_TITLE HAVING sum(emp_salary) > 150000;

-- ORDER BY
/*
 * We can order ascending using asc or 
 * descending using desc
 */
SELECT * FROM employees ORDER BY emp_salary ASC;

/* ALL TOGETHER */
SELECT avg(emp_salary), emp_title
FROM examples.employees
WHERE emp_salary < 100000
GROUP BY emp_title
HAVING avg(emp_salary) > 65000
ORDER BY emp_title DESC;


/*
 * LIKE - A keyword that creates a clause (used with WHERE) to
 * filter for string values based on a pattern provided
 */
SELECT * FROM employees WHERE lower(emp_name) LIKE '%a%';
SELECT * FROM employees WHERE lower(emp_name) LIKE 'j%';
SELECT * FROM employees WHERE lower(emp_title) LIKE '%r%';

/*
 * BETWEEN & AND - Keywords that are used to specify a range
 * of Values in which we select.
 */ 
SELECT * FROM employees WHERE emp_salary BETWEEN 70000 AND 85000;

/*
 * IN - Allows us to specify a collection of data in which
 * we match the values indicated with the record's value
 */
SELECT * FROM examples.employees WHERE lower(emp_title) IN ('ceo','developer');


