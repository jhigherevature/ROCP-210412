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

SELECT * FROM project.donor WHERE id_userpass=21;

SELECT p.player_name, t.team_name FROM examples.players AS p 
INNER JOIN examples.team AS t ON p.player_id = t.team_id;

SELECT * FROM project.account ORDER BY id_account DESC LIMIT 1

SELECT e.first_name, e.last_name, e.emp_title FROM project.userpass AS u INNER JOIN project.employee AS e ON u.id_userpass = e.id_userpass WHERE username= 'a' AND pw = 'a';

, pw,
select * FROM project.userpass WHERE 

SELECT * FROM players WHERE player_salary > (SELECT AVG(player_salary) FROM players);

INSERT INTO project.userpass VALUES (default, 'brenda', 'Johnson', 'donor');

SELECT * FROM project.school

INSERT INTO project.pledge VALUES (default,2020,150,10,01/01/2020,'unconfirmed',null,null);

SELECT count(id_pledge) FROM project.pledge WHERE year_pledge=2020 AND id_account = 91134;
SELECT sum(pledge_amt::NUMERIC) FROM project.pledge WHERE year_pledge=2020 AND id_account = 91134;
SELECT * FROM project.pledge where year_pledge=2021 AND id_account=91134;

INSERT INTO project.donor VALUES
(DEFAULT, null, 'mr', 'Johnson', 'Johnson', '4123 Lineway dr.', 'Atlanta', 90740, 123-456-7890, 'Johnson@johnson.com', NULL, 123-12-1234, 'asflkjaoefinna osadfoaef', TRUE, TRUE, null);
(id_donor, id_account, title,first_name,last_name, 
address, city ,zip, phone , email , soc_sec, notes, allow_school_contact, donor_status, id_userpass) 
