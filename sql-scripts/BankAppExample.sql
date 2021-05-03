CREATE SCHEMA bankapp;

CREATE SEQUENCE bankapp.login_id_seq START WITH 100 INCREMENT BY 1;
CREATE SEQUENCE bankapp.emp_id_seq START WITH 1001 INCREMENT BY 2;
CREATE SEQUENCE bankapp.cust_id_seq START WITH 1000 INCREMENT BY 2;

CREATE TABLE bankapp.login (
	login_id INTEGER DEFAULT nextval('bankapp.login_id_seq') PRIMARY KEY,
	user_name VARCHAR(200),
	user_pass VARCHAR(200)
);

CREATE TABLE bankapp.customer (
	cust_id INTEGER DEFAULT nextval('cust_id_seq') PRIMARY KEY,
	cust_name VARCHAR(200),
	login_id INTEGER REFERENCES bankapp.login(login_id)
);

CREATE TABLE bankapp.employee (
	emp_id INTEGER DEFAULT nextval('emp_id_seq') PRIMARY KEY,
	emp_name VARCHAR(200),
	emp_title VARCHAR(50),
	emp_salary NUMERIC,
	login_id INTEGER REFERENCES bankapp.login(login_id)
);

INSERT INTO bankapp.login VALUES 
	(DEFAULT, 'custlogin', 'custpass'), 
	(DEFAULT, 'emplogin', 'emppass');

INSERT INTO bankapp.customer VALUES (DEFAULT, 'customer name', 100);
INSERT INTO bankapp.employee VALUES (DEFAULT, 'employee name', 'teller', 50000.00, 101);

GRANT INSERT, SELECT, UPDATE, DELETE ON ALL TABLES IN SCHEMA bankapp TO customers;
GRANT USAGE ON SCHEMA bankapp TO customers;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA bankapp TO customers;
