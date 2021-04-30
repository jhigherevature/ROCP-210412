CREATE SCHEMA bank_template; --WHERE I will be storing my SQL scripts

/*
 * TO DO:
 * 	create entity relationship diagram
 * 	determine primary keys
 * 	determine foreign keys
 */
CREATE TABLE bank_template.employees(
	employee_id serial PRIMARY KEY,
	employee_first_name varchar(50),
	employee_last_name varchar(50),
	employee_job varchar(50),
	employee_salary decimal
);

CREATE TABLE bank_template.bankers(
	banker_id serial PRIMARY KEY,
	banker_first_name varchar(50),
	banker_last_name varchar(50),
	banker_job varchar(50),
	banker_salary decimal
);

CREATE TABLE bank_template.customers(
	customer_id serial PRIMARY KEY,
	customer_first_name varchar(50),
	customer_last_name varchar(50)
);

CREATE TABLE bank_template.customer_login(
	login_id integer REFERENCES bank_template.customers(customer_id) ON DELETE cascade,
	login_username varchar(50),
	login_password varchar(50)
);

CREATE TABLE bank_template.employee_login(
	login_id integer REFERENCES bank_template.employees (employee_id) ON DELETE cascade,
	login_username varchar(50),
	login_password varchar(50)
);

CREATE TABLE bank_template.banker_login(
	login_id integer REFERENCES bank_template.bankers (banker_id) ON DELETE cascade,
	login_username varchar(50),
	login_password varchar(50)
);

CREATE TABLE bank_template.customer_application(
	customer_application_id serial PRIMARY KEY,
	customer_first_name varchar(50),
	customer_last_name varchar(50),
	customer_username varchar(50),
	customer_password varchar(50)
);

CREATE TABLE bank_template.savings_accounts(--this can be broken down even further
	savings_id integer REFERENCES bank_template.customers (customer_id) ON DELETE SET NULL,
	secondary_id integer REFERENCES bank_template.customers (customer_id) ON DELETE SET NULL,
	savings decimal
);

TRUNCATE bank_template.customers cascade ;

DELETE FROM bank_template.customers WHERE customer_id = 15;

SELECT * FROM bank_template.banker_login WHERE banker_login.login_username = 'username' AND banker_login.login_password = 'password';

INSERT INTO bank_template.customer_login VALUES (1, 'username', 'password'); 

INSERT INTO bank_template.employee_login VALUES (2, 'username','password');

