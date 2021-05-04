BEGIN;

CREATE SCHEMA piggybank;

CREATE TABLE piggybank.userAccounts (
	"uid" int UNIQUE PRIMARY KEY NOT NULL,
	"email" varchar(200) UNIQUE,
	"passHash" varchar(200),
	"firstName" varchar(50),
	"lastName" varchar(200),
	"status" varchar(50) 
		CHECK (("status" = 'employee')
		OR ("status" = 'active')
		OR ("status" = 'pending')
		OR ("status" = 'closed'))
);

CREATE TABLE piggybank.bankAccounts (
	"aid" int UNIQUE PRIMARY KEY NOT NULL,
	"type" varchar(50) CHECK ("type" = 'debit' OR "type" = 'credit'),
	"balance" money CHECK (("type" = 'debit' AND "balance" >= 0.00::money) OR ("type" = 'credit'))
);

CREATE TABLE piggybank.joinAccounts (
	"user" int NOT NULL,
	"account" int NOT NULL,
	FOREIGN KEY ("user") REFERENCES piggybank.userAccounts("uid") ON DELETE CASCADE,
	FOREIGN KEY ("account") REFERENCES piggybank.bankAccounts("aid")
);

CREATE TABLE piggybank.transactions (
	"id" int UNIQUE PRIMARY KEY NOT NULL,
	"said" int NOT NULL,
	"suid" int NOT NULL,
	"transaction" money NOT NULL,
	"daid" int,
	FOREIGN KEY ("said") REFERENCES piggybank.bankAccounts("aid"),
	FOREIGN KEY ("suid") REFERENCES piggybank.userAccounts("uid"),
	FOREIGN KEY ("daid") REFERENCES piggybank.bankAccounts("aid")
);

COMMIT;