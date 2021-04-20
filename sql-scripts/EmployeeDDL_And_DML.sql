/*
 * Multi-line comments in SQL
 */

-- This is a single line comment in SQL

/*
 * DDL - Data Definition Language
 * 		Used to create Schemas and Tables (generally)
 * 		Or other entities used to define structure for
 * 		our database
 */
DROP SCHEMA IF EXISTS examples;

CREATE SCHEMA examples;

DROP TABLE IF EXISTS examples.employees;

CREATE TABLE examples.employees (
	emp_id SERIAL,
	emp_name VARCHAR(200),
	emp_title VARCHAR(50),
	emp_salary NUMERIC
);

-- Use TRUNCATE to remove the values but retain the structure
TRUNCATE TABLE examples.EMPLOYEES;

/*
 * DML - Data Manipulation Language
 * 			used to insert, update, delete or select values/record
 * 			from our established database tables
 * 
 * 			These are often referred to as the CRUD operations
 * 			'Create', 'Read', 'Update', 'Delete'
 */
INSERT INTO examples.employees VALUES (DEFAULT, 'Joseph', 'CEO', 100000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'Brian', 'Employee', 60000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'James', 'Employee', 65000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'Maggie', 'Manager', 76000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'Sally', 'Employee', 88000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'Jill', 'Manager', 76000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'Phil', 'Manager', 76000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'Bill', 'Employee', 60000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'Ralph', 'Employee', 65000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'Quincy', 'Developer', 88000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'Margo', 'Developer', 98000.00);
INSERT INTO examples.employees VALUES (DEFAULT, 'Leslie', 'Developer', 92000.00);

--We specify the record we want to manipulate using the WHERE keyword
--UPDATE examples.employees SET emp_id=1001 WHERE emp_name='Brian';

--We specify the record we want to remove using the WHERE keyword as well
DELETE FROM examples.employees WHERE emp_id = 1004;

/*
 * SELECT is a non-transactional operation
 * 	as such, it is usually referred to as a DQL
 * (Data Query Language) command. We specify
 * the columns we want From the table resource
 */
SELECT emp_id FROM examples.employees;
SELECT * FROM examples.employees;