CREATE SCHEMA IF NOT EXISTS bankapp;

--Login Table
DROP TABLE IF EXISTS bankapp.login;
CREATE TABLE bankapp.login (
login_id integer PRIMARY KEY,
user_name varchar(200),
pass_word varchar(200)
);

--Customers Table
DROP TABLE IF EXISTS bankapp.customers;
CREATE TABLE bankapp.customers (
cust_id integer PRIMARY KEY,
cust_name varchar(200),
login_id integer
);

--Employees Table
DROP TABLE IF EXISTS bankapp.employees;
CREATE TABLE bankapp.employees (
emp_id integer PRIMARY KEY,
emp_name varchar(200),
login_id integer
);

--Accounts Table
DROP TABLE IF EXISTS bankapp.accounts;
CREATE TABLE bankapp.accounts (
account_id integer PRIMARY KEY,
account_balance NUMERIC,
cust_id1 integer,
cust_id2 integer
);

SELECT * FROM bankapp.accounts;
SELECT * FROM bankapp.customers;
SELECT * FROM bankapp.login;