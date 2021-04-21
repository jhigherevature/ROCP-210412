/*
 * Aggregate Functions - Functions that perform work on all records
 * 	of a specified column and return a single value
 */
SELECT MIN (emp_salary) FROM examples.employees;
SELECT AVG (emp_salary) FROM examples.employees;

/*
 * Window Functions - perform some operation across each row of our
 * 	table, based on a calculation/observance of all of the records
 * 	of our table
 */
SELECT emp_name, emp_title, FIRST_VALUE (emp_salary) 
OVER() FROM examples.employees; 

SELECT emp_name, emp_title, FIRST_VALUE (emp_salary) 
OVER(ORDER BY emp_title desc) FROM examples.employees;

SELECT emp_name, emp_title, FIRST_VALUE (emp_salary) 
OVER(PARTITION BY emp_title ORDER BY EMP_SALARY ASC ) FROM examples.employees;

SELECT emp_salary, AVG(emp_salary) 
OVER (PARTITION BY emp_title ORDER BY emp_title desc) FROM examples.employees; 

/*
 * Scalar Functions - functions that perform operations on a record-by-record basis
 */
SELECT UPPER(emp_name) FROM employees;

