
CREATE TABLE state(
state_id int PRIMARY KEY,
state_name varchar(50)
);

CREATE TABLE team (
term_id int PRIMARY KEY,
team_name varchar(50),
state_id int,
sport_id int,
CONSTRAINT state_id_fk FOREIGN KEY (state_id) REFERENCES state(state_id),
CONSTRAINT sport_id_fk FOREIGN KEY (sport_id) REFERENCES sport(sport_id)
);


CREATE TABLE Player(
player_id int PRIMARY KEY,
player_name varchar(50),
term_id int,
player_salary decimal,
CONSTRAINT term_id_fk FOREIGN KEY (term_id) REFERENCES Team(term_id)
);


CREATE TABLE sport(
sport_id int PRIMARY KEY,
sport_name varchar(50)
);


INSERT INTO state (state_id ,state_name) VALUES('10001','New York');
INSERT INTO state (state_id ,state_name) VALUES('10002','Texas');
INSERT INTO state (state_id ,state_name) VALUES('10003','Colorado');
INSERT INTO state (state_id ,state_name) VALUES('10004','Florida');
INSERT INTO state (state_id ,state_name) VALUES('10005','California');

INSERT INTO team (term_id ,team_name,state_id,sport_id) VALUES('20001','Los Angeles Clippers','10005','40002');
INSERT INTO team (term_id ,team_name,state_id,sport_id) VALUES('20002','Denver Broncos','10003','40001');
INSERT INTO team (term_id ,team_name,state_id,sport_id) VALUES('20003','New York Knicks','10001','40002');
INSERT INTO team (term_id ,team_name,state_id,sport_id) VALUES('20004','Miami Dolphins','10004','40001');
INSERT INTO team (term_id ,team_name,state_id,sport_id) VALUES('20005','Denver Nuggets','10003','40002');
INSERT INTO team (term_id ,team_name,state_id,sport_id) VALUES('20006','Dallas Mavericks','10002','40002');
INSERT INTO team (term_id ,team_name,state_id,sport_id) VALUES('20007','Dallas Cowboys','10002','40001');
INSERT INTO team (term_id ,team_name,state_id,sport_id) VALUES('20008','San Francisco 49ers','10005','40001');
INSERT INTO team (term_id ,team_name,state_id,sport_id) VALUES('20009','Miami Hea','10004','40002');
INSERT INTO team (term_id ,team_name,state_id,sport_id) VALUES('200010','Buffalo Bills','10001','40001');


-DROP TABLE team;


INSERT INTO sport (sport_id ,sport_name) VALUES('40001','Foot Ball');
INSERT INTO sport (sport_id ,sport_name) VALUES('40002','Basket Ball');


INSERT INTO player (player_id,term_id ,player_name,player_salary) VALUES('30001','20006','Terry Lennie','185000');
INSERT INTO player (player_id,term_id ,player_name,player_salary) VALUES('30002','20002','Ellis Sidney','101000');
INSERT INTO player (player_id,term_id ,player_name,player_salary) VALUES('30003','20001','Alex Meredith','236000');
INSERT INTO player (player_id,term_id ,player_name,player_salary) VALUES('30004','20003','Parker Lindsay','240000');
INSERT INTO player (player_id,term_id,player_name,player_salary) VALUES('30005','20008','Lindsey Darian','241000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('30006','20007','Kit Stacy','220000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('30007','20003','Sammie Hadley','112000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('30008','20005','Tracey Bailey','128000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('30009','20002','Addison Garnet','105000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300010','20005','Esme Stace','146000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300011','20009','Kennedy Meredith','236000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300012','20004','Cortney Harper','168000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300013','20002','Loren Addison','189000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300014','20009','Jojo Noel','233000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300015','200010','Syd Hilary','132000');
INSERT INTO player (player_id,term_id ,player_name,player_salary) VALUES('300016','20006','Jools Francis','204000');
INSERT INTO player (player_id,term_id ,player_name,player_salary) VALUES('300017','20001','Beverly Terry','210000');
INSERT INTO player (player_id,term_id ,player_name,player_salary) VALUES('300018','20007','Sidney Raven','157000');
INSERT INTO player (player_id,term_id ,player_name,player_salary) VALUES('300019','20006','Page Ricki','247000');
INSERT INTO player (player_id,term_id,player_name,player_salary) VALUES('300020','20003','Palmer Beau','104000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300021','20008','Hadley Lindsey','133000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300022','20008','Yancy Cameron','220000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300023','200010','Jo Jools','140000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300024','20001','Raleigh Ricki','170000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300025','20004','Tibby Ronnie','138000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300026','20009','Jules Evelyn','175000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300027','20007','Lesley Izzy','179000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300028','20005','Eddie Peyton','129000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300029','200010','Alpha Jocelyn','215000');
INSERT INTO player (player_id,term_id ,player_name ,player_salary) VALUES('300030','20004','Parker Emery','202000');


SELECT * FROM player;


SELECT min(player_salary) AS lowestSalary FROM player;

SELECT max(player_salary) AS highestSalary FROM player;

SELECT player_name from player where player_name LIKE 'J%' OR  player_name LIKE 'O%'order by player_name;

SELECT  player_name from player where player_name LIKE 'E%' OR  player_name LIKE 'A%'order by player_name;

SELECT * FROM player WHERE player_salary>'200000';
