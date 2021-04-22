/*
 * When creating users, we name the user and create it
 * using the DDL Create command. We also specify the user
 * password used to authenticate the login information
 */
CREATE USER customers WITH PASSWORD 'password';

/*
 * Before dropping a user, you must ensure that the user
 * does not have any permissions on your DB
 */
REVOKE ALL PRIVILEGES ON examples.employees FROM customers;
DROP USER IF EXISTS customers;

-- We can grant individual access to certain actions on our DB
GRANT INSERT ON examples.employees TO customers;

-- OR we can GRANT many AT the same time
GRANT SELECT, UPDATE, DELETE ON examples.employees TO customers;
/*
 * We can specify all tables/schemas/sequences, etc... on an entity
 * using the ALL keyword
 */
--GRANT SELECT ON ALL TABLES ON SCHEMA examples TO customers;

--CREATE SCHEMA employee;

/*
 * Remember to qualify your table reference with the schema name!
 */
--SELECT * FROM human_resources.login
--SELECT * FROM customers.login
--SELECT * FROM information_tech.login 
