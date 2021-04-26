/*
 * Aliases : Aliases are a means to name a table or reference from a select
 * 			statement to more easily write the query. It allows you to reference
 * 			longer names based on the moniker you provide it.
 * 
 * In postgresql the 'as' keyword is used to provide an alias. In most operations
 * the 'as' keyword is implicitly placed in the operation.
 */
--INNER JOINS : We join the information as it matches the criteria we provided
SELECT p.player_name, t.team_name FROM examples.players AS p 
INNER JOIN examples.team AS t ON p.player_id = t.team_id;

SELECT p.player_name, t.team_name FROM examples.players AS p 
INNER JOIN examples.team AS t ON p.team_id = t.team_id;

-- FULL OUTER JOIN:
SELECT * FROM examples.players p 
FULL OUTER JOIN examples.team t ON p.player_id = t.team_id;

SELECT * FROM examples.players p 
FULL OUTER JOIN examples.team t ON p.team_id = t.team_id;

-- SELF JOIN :
SELECT a.emp_name AS emp1, b.emp_name AS emp2, a.emp_salary 
FROM employees a INNER JOIN employees b ON a.emp_salary = b.emp_salary;

--LEFT 
SELECT p.player_salary, t.team_sport
FROM players p LEFT JOIN team t ON p.player_id = t.team_id;

-- useful version
SELECT p.player_salary, t.team_sport
FROM players p LEFT JOIN team t ON p.team_id = t.team_id;

--RIGHT 
SELECT p.player_id, p.player_salary, t.team_id, t.team_sport
FROM players p RIGHT JOIN team t ON p.player_id = t.team_id;

-- useful version
SELECT p.player_id, p.player_salary, t.team_id, t.team_sport
FROM players p RIGHT JOIN team t ON p.team_id = t.team_id;

/*
 * Set Operations will append records using the same number of 
 * columns (the records from two tables will show above/below
 * one another, instead of next to each in the result set
 * 
 * When using set operations, you must query for the same
 * number of columns from each table.
 */
-- Unions
SELECT p.player_id AS id, p.player_name AS name FROM players p
UNION SELECT t.team_id, t.team_name FROM team t;

SELECT p.player_id AS id FROM players p
UNION SELECT t.team_id FROM team t;

-- INTERSECT
SELECT p.player_id AS id FROM players p
INTERSECT SELECT t.team_id FROM team t;

-- EXCEPT
SELECT p.player_id AS id FROM players p
EXCEPT SELECT t.team_id FROM team t;


-- SUBQUERIES
SELECT AVG(player_salary) FROM players;
SELECT * FROM players WHERE player_salary > 590000;
SELECT * FROM players WHERE player_salary < 590000;

SELECT * FROM players WHERE player_salary > (SELECT AVG(player_salary) FROM players);
SELECT * FROM players WHERE player_salary < (SELECT AVG(player_salary) FROM players);

