CREATE SCHEMA bank

CREATE TABLE bank.users (
    user_id SERIAL PRIMARY KEY,
    user_first_name VARCHAR(50),
    user_last_name VARCHAR(50),
    username VARCHAR(24),
    userpassword VARCHAR(24)
)

CREATE TABLE bank.employees (
    employee_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(user_id)
)

CREATE TABLE bank.customers (
    customer_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(user_id)
)

CREATE TABLE bank.admins (
    admin_id SERIAL PRIMARY KEY,
    employee_id INTEGER REFERENCES employees(employee_id),
    user_id INTEGER REFERENCES users(user_id)
)

CREATE TABLE bank.accounts (
    account_number SERIAL PRIMARY KEY,
    application_date DATE NOT NULL DEFAULT CURRENT_DATE,
    approval_date DATE,
    approved BOOLEAN NOT NULL DEFAULT false,
    approved_by INTEGER REFERENCES employees(employee_id),
    balance MONEY
)

CREATE TABLE bank.user_accounts (
    customer_id INTEGER REFERENCES customers(customer_id),
    account_number INTEGER REFERENCES accounts(account_number)
)

CREATE TABLE bank.transactions (
    transaction_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(user_id),
    transaction_type VARCHAR(10),
    amount MONEY,
    transaction_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)

CREATE TABLE bank.canceled_accounts (
    account_id INTEGER REFERENCES accounts(account_number),
    canceled_by INTEGER REFERENCES admins(admin_id),
    canceled_date DATE DEFAULT CURRENT_DATE
)
;