-- 0 NF
CREATE TABLE orders_0NF (
	order_items varchar(100),
	order_total decimal,
	order_date DATE,
	cust_name VARCHAR(100),
	cust_address VARCHAR(200),
	cust_email VARCHAR(200),
	cust_pass VARCHAR(100)
);

-- 1 NF: Atomic Data, Idetifying column (primary key), records should be unique
CREATE TABLE orders_1NF (
	order_id INTEGER PRIMARY KEY,
	order_item varchar(100),
	item_quantity INTEGER,
	item_price DECIMAL,
	order_total decimal,
	order_date DATE,
	cust_first VARCHAR(100),
	cust_last VARCHAR(100),
	cust_address VARCHAR(200),
	cust_email VARCHAR(200),
	cust_pass VARCHAR(100)
);

--2NF : All qualities of 1NF as well as NO partial dependencies
CREATE TABLE orders_2NF (
	order_id INTEGER PRIMARY KEY,
	cust_id INTEGER REFERENCES customers_2NF(cust_id),
	order_item varchar(100),
	item_quantity INTEGER,
	item_price DECIMAL,
	order_total decimal,
	order_date DATE,
);

CREATE TABLE customers_2NF(
	cust_id INTEGER PRIMARY KEY,
	cust_first VARCHAR(100),
	cust_last VARCHAR(100),
	cust_address VARCHAR(200),
	cust_email VARCHAR(200),
	cust_pass VARCHAR(100)
);


-- 3NF : 2NF + ALL DATA OF a TABLE should relate directly TO the PK FOR that TABLE
CREATE TABLE orders_3NF (
	order_id INTEGER PRIMARY KEY,
	cust_id INTEGER REFERENCES customers_3NF(cust_id) ON DELETE CASCADE,
	order_total decimal,
	order_date DATE
);

CREATE TABLE order_items_3NF (
	order_id INTEGER REFERENCES orders_3NF(order_id) ON DELETE CASCADE,
	item_id varchar(100) REFERENCES items_3NF(item_id),
	item_quantity INTEGER
);

CREATE TABLE items_3NF (
	item_id INTEGER PRIMARY KEY,
	item_name VARCHAR(200),
	item_price DECIMAL
);

CREATE TABLE customers_3NF(
	cust_id INTEGER PRIMARY KEY,
	cust_first VARCHAR(100),
	cust_last VARCHAR(100),
	cust_address VARCHAR(200),
	cust_email VARCHAR(200),
	cust_pass VARCHAR(100)
);

CREATE TABLE inactive_customer_3NF (
	cust_id INTEGER REFERENCES customers_3NF(cust_id),
	inactive_date DATE
);
