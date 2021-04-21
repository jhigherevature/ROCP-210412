/*
 * multiline comments
 */

--single line comment

/* 
 * DDL 
 * used to create schemas and tables (generally)
 * or other entities used to define structure for our database
 */

DROP SCHEMA IF EXISTS examples;

CREATE SCHEMA examples;

CREATE TABLE examples.employees (  --be sure TO CHECK above TO see what SCHEMA it IS being added TO
-- or can just add name of schema with dot before name of table.
	emp_id INTEGER,
	emp_name VARCHAR(200),
	emp_title VARCHAR(50),
	emp_salary NUMERIC 
);
