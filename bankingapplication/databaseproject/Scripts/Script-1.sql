SELECT * FROM bank_user

	SELECT * FROM customer;
SELECT user_id FROM bank_user WHERE user_name ='melanieduah';


INSERT INTO customer (customer_name,address,email,user_id) VALUES (?,?,?,?);

DELETE FROM bank_user;

SELECT customer_name, address, email FROM customer 
JOIN bank_user ON customer.user_id = bank_user.user_id 
WHERE bank_user.user_name = 'meldee' AND bank_user.user_password = '29.6976m';

DELETE FROM customer;


ALTER TABLE account_type ADD 
description varchar(255) NULL;


INSERT INTO bankingappdb.account_type (account_type_name) VALUES
	 ('Checking'),
	 ('Savings'),
	 ('Joint Checking'),
	 ('Joint Savings');
	 
UPDATE account_type 
SET description = 'A savings account is great for parking your cash for future use. It allows limited withdrawals per month and offer a modest interest rate. You will need a partner for this account'
WHERE account_type_id = '4';

UPDATE account_type 
SET description = ' A checking account is very liquid and allows numerous withdrawals and unlimited deposits. You will need a partner for this account'
WHERE account_type_id = '3';

UPDATE account_type
SET description = 'A savings account is great for parking your cash for future use. It allows limited withdrawals per month and offer a modest interest rate'.
WHERE account_type_id = '2';


UPDATE account_type
SET description = ' A savings account is great for parking your cash for future use. It allows limited withdrawals per month and offer a modest interest rate'.
WHERE account_type_id = '1';


DELETE descriptin FROM account_type WHERE account_type_id='3';

-- A checking account is very liquid and allows numerous withdrawals and unlimited deposits
-- A savings account is great for parking your cash for future use. It allows limited withdrawals per month and offer a modest interest rate
	
-- How much will you be depositing into your new checking account today?
SELECT * FROM account_type;

SELECT  max(account_id) FROM account



INSERT INTO account (account_id,account_number,account_balance,account_type_id) VALUES (?,?,?,?);

SELECT account_id FROM account WHERE account_number='30009281'




SELECT * FROM account;

SELECT * FROM customer;

SELECT * FROM account_customer;

SELECT account.account_id,account_number,account_balance FROM account
JOIN account_customer ON account.account_id =account_customer.account_id 
JOIN customer ON account_customer.customer_id =customer.customer_id 
WHERE customer.customer_id='5'

INSERT INTO bankingappdb.transaction_type (transaction_type_name) VALUES
	 ('Deposit'),
	 ('Transfer'),
	 ('Withdrawals');
	
SELECT * FROM transaction_type;

ALTER TABLE account_transaction ADD 
transaction_date date DEFAULT CURRENT_DATE;


ALTER TABLE account ADD 
account_status varchar(10) DEFAULT 'pending';

INSERT INTO bankingappdb.employee_role (role_name) VALUES
	 ('Teller'),
	 ('Admin');
	
SELECT * FROM bank_user;
INSERT INTO bank_user (user_name,user_password) values('mduah','28mduah');

SELECT employee_name, r.role_id, r.role_name FROM employee AS e JOIN bank_user AS u ON e.user_id = u.user_id JOIN employee_role AS r ON r.role_id = e.role_id WHERE u.user_name ='mduah' AND u.user_password ='28mduah';

INSERT INTO employee (employee_name,role_id,user_id) VALUES('Melanie Duah','2','13');
SELECT * FROM employee_role; 

SELECT a.account_number, amount, transaction_type_name, transaction_date FROM account_transaction
JOIN customer ON customer.customer_id = account_transaction.customer_id
JOIN account a ON a.account_id = account_transaction.target_account_id
JOIN transaction_type ON account_transaction.transaction_type_id = transaction_type.transaction_type_id 
WHERE customer.customer_id ='4';


SELECT c.customer_id, customer_name, address, email FROM customer AS c JOIN account_customer AS ac ON c.customer_id = ac.customer_id  JOIN account AS a ON a.account_id = ac.account_id WHERE a.account_id ='2';

SELECT a.account_id, account_number, act.account_type_name, account_balance, account_status FROM account AS a JOIN account_type AS act ON a.account_type_id = act.account_type_id;

DELETE FROM account_transaction WHERE source_account_id = '2';
DELETE FROM account_transaction WHERE target_account_id = '2';
DELETE FROM account_customer WHERE customer_id = '2';
DELETE FROM account WHERE account_id = '2';