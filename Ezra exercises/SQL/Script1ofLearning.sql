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

INSERT INTO examples.employees VALUES (1000, 'Joseph', 'CEO', 100000);
INSERT INTO examples.employees VALUES (1001, 'Brian', 'CEO', 100000);
INSERT INTO examples.employees VALUES (1002, 'James', 'CEO', 100000);
INSERT INTO examples.employees VALUES (1003, 'Sally', 'Employee', 100000);
INSERT INTO examples.employees VALUES (1004, 'Jill', 'Manager', 65000);
INSERT INTO examples.employees VALUES (1005, 'Phil', 'Manager', 65000);
INSERT INTO examples.employees VALUES (1006, 'Bill', 'Employee', 55000);
INSERT INTO examples.employees VALUES (1007, 'Raplph', 'Employee', 65000);

SELECT examples.employees ALTER raplph TO Ralph;