SELECT * FROM project.userpass WHERE username= 'msomerset' AND pw = 'stuff';

SELECT e.first_name, e.last_name, e.emp_title FROM project.userpass AS u
INNER JOIN project.employee AS e 
ON u.id_userpass = e.id_userpass
WHERE username= 'msomerset' AND pw = 'stuff';

SELECT * FROM userpass WHERE username= 'msomerset' AND pw = 'stuff' AS u
INNER JOIN SELECT first_name, LAST_name, emp_title FROM employee AS e 
ON u.id_userpass = e.id_userpass;

SELECT * FROM userpass WHERE username= 'msomerset' AND pw = 'stuff' AS u
INNER JOIN FROM employee AS e 
ON u.id_userpass = e.id_userpass;


SELECT p.player_name, t.team_name FROM examples.players AS p 
INNER JOIN examples.team AS t ON p.player_id = t.team_id;


SELECT e.first_name, e.last_name, e.emp_title FROM project.userpass AS u INNER JOIN project.employee AS e ON u.id_userpass = e.id_userpass WHERE username= 'a' AND pw = 'a';

, pw,
select * FROM project.userpass WHERE 

SELECT * FROM players WHERE player_salary > (SELECT AVG(player_salary) FROM players);
