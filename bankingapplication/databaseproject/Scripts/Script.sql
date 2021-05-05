

CREATE TABLE bank_user (
	user_id serial NOT NULL,
	user_name varchar(50) NOT NULL,
	"password" varchar(50) NOT NULL,
	CONSTRAINT bank_user_pkey PRIMARY KEY (user_id),
	CONSTRAINT bank_user_user_name_key UNIQUE (user_name)
);

CREATE TABLE customer (
	customer_id serial NOT NULL,
	customer_name varchar(255) NOT NULL,
	address varchar(255) NOT NULL,
	email varchar(50) NOT NULL,
	user_id int4 NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (customer_id),
	CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES bankingappdb.bank_user(user_id)
);

CREATE TABLE employee_role (
	role_id serial NOT NULL,
	role_name varchar(255) NOT NULL,
	CONSTRAINT employee_role_pkey PRIMARY KEY (role_id)
);

CREATE TABLE employee (
	employee_id serial NOT NULL,
	employee_name varchar(255) NOT NULL,
	role_id int4 NULL,
	user_id int4 NULL,
	CONSTRAINT employee_pkey PRIMARY KEY (employee_id),
	CONSTRAINT role_id_fk FOREIGN KEY (role_id) REFERENCES bankingappdb.employee_role(role_id),
	CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES bankingappdb.bank_user(user_id)
);


CREATE TABLE transaction_type (
	transaction_type_id serial NOT NULL,
	transaction_type_name varchar(50) NOT NULL,
	CONSTRAINT transaction_type_pkey PRIMARY KEY (transaction_type_id)
);

CREATE TABLE account_type (
	account_type_id serial NOT NULL,
	account_type_name varchar(50) NOT NULL,
	CONSTRAINT account_type_pkey PRIMARY KEY (account_type_id)
);

CREATE TABLE account (
	account_id serial NOT NULL,
	account_number varchar(50) NOT NULL,
	account_type_id int4 NULL,
	account_balance numeric NULL,
	CONSTRAINT account_account_number_key UNIQUE (account_number),
	CONSTRAINT account_pkey PRIMARY KEY (account_id),
	CONSTRAINT account_type_id_fk FOREIGN KEY (account_type_id) REFERENCES bankingappdb.account_type(account_type_id)
);



CREATE TABLE account_customer (
	accountcustomer_id serial NOT NULL,
	account_id int4 NULL,
	customer_id int4 NULL,
	CONSTRAINT account_customer_pkey PRIMARY KEY (accountcustomer_id),
	CONSTRAINT account_id_fk FOREIGN KEY (account_id) REFERENCES bankingappdb.account(account_id),
	CONSTRAINT customer_id_fk FOREIGN KEY (customer_id) REFERENCES bankingappdb.customer(customer_id)
);

CREATE TABLE account_transaction (
	transaction_id serial NOT NULL,
	amount numeric NULL,
	customer_id int4 NULL,
	transaction_type_id int4 NULL,
	source_account_id int4 NULL,
	target_account_id int4 NOT NULL,
	CONSTRAINT account_transaction_pkey PRIMARY KEY (transaction_id),
	CONSTRAINT customer_id_fk FOREIGN KEY (customer_id) REFERENCES bankingappdb.customer(customer_id),
	CONSTRAINT source_account_id_fk FOREIGN KEY (source_account_id) REFERENCES bankingappdb.account(account_id),
	CONSTRAINT target_account_id_fk FOREIGN KEY (target_account_id) REFERENCES bankingappdb.account(account_id),
	CONSTRAINT transaction_id_fk FOREIGN KEY (transaction_type_id) REFERENCES bankingappdb.transaction_type(transaction_type_id)
);