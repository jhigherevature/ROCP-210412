BEGIN;

CREATE SCHEMA piggybank;

CREATE TABLE piggybank.users (
	id serial UNIQUE PRIMARY KEY,
	email varchar(200) UNIQUE,
	pass_hash varchar(200),
	pass_salt varchar (200),
	first_name varchar(50),
	last_name varchar(200),
	status varchar(50) 
		CHECK (("status" = 'employee')
		OR ("status" = 'active')
		OR ("status" = 'pending')
		OR ("status" = 'closed'))
);

CREATE TABLE piggybank.accounts (
	id serial UNIQUE PRIMARY KEY,
	account_type varchar(50) CHECK (account_type = 'debit' OR account_type = 'credit'),
	balance money CHECK ((account_type = 'debit' AND balance >= 0.00::money) OR (account_type = 'credit'))
);

CREATE TABLE piggybank.user_accounts (
	id serial UNIQUE PRIMARY KEY,
	user_id int NOT NULL,
	account_id int NOT NULL,
	FOREIGN KEY (user_id) REFERENCES piggybank.users(id) ON DELETE CASCADE,
	FOREIGN KEY (account_id) REFERENCES piggybank.accounts(id)
);

CREATE TABLE piggybank.transactions (
	id serial UNIQUE PRIMARY KEY,
	source_account_id int NOT NULL,
	source_user_id int NOT NULL,
	transfer_amount money NOT NULL,
	destination_account_id int,
	transaction_time timestamptz DEFAULT current_timestamp,
	FOREIGN KEY ("source_account_id") REFERENCES piggybank.accounts("id"),
	FOREIGN KEY ("source_user_id") REFERENCES piggybank.users("id"),
	FOREIGN KEY ("destination_account_id") REFERENCES piggybank.accounts("id")
);

COMMIT;