CREATE TABLE examples.state (
/*
 * Most commonly constraints on a single column are applied
 * using the keywords immediately following the column declaration
 */
	state_id SERIAL PRIMARY KEY,
	state_name varchar(100) UNIQUE NOT NULL
	
	-- we can create primary keys using the constraint keyword
--	CONSTRAINT state_pk PRIMARY KEY (state_id),
--	CONSTRAINT state_name_con NOT NULL UNIQUE (state_name)
);

CREATE TABLE examples.sports (
	sport_id SERIAL PRIMARY KEY,
	sport_name varchar(100) NOT NULL
);

CREATE TABLE examples.team (
	team_id SERIAL PRIMARY KEY,
	team_name VARCHAR(100) check(length(team_name) > 1),
	team_state integer,
	team_sport integer,
	/*
	 * We can establish a foreign key relationship using the references
	 * keyword and stating the table and column (or constraint name)
	 * that we establish as the relation to the foreign key.
	 */
	CONSTRAINT team_state_fk FOREIGN KEY (team_state) REFERENCES state(state_id) ON DELETE RESTRICT,
	CONSTRAINT team_sport_fk FOREIGN KEY (team_sport) REFERENCES sports(sport_id) ON DELETE CASCADE
);

CREATE TABLE examples.players (
	player_id SERIAL PRIMARY KEY,
	team_id integer REFERENCES team(team_id),
	player_name varchar(100),
	player_salary integer,
	draft_date date
);


INSERT INTO examples.state(state_name) VALUES('Colorado');
INSERT INTO examples.state(state_name) VALUES('California');
INSERT INTO examples.state(state_name) VALUES('Texas');

INSERT INTO examples.sports(sport_name) VALUES('football');
INSERT INTO examples.sports(sport_name) VALUES('basketball');

INSERT INTO examples.team VALUES(DEFAULT,'broncos',1,1);
INSERT INTO examples.team VALUES(DEFAULT,'49ers',2,1);
INSERT INTO examples.team VALUES(DEFAULT,'cowboys',3,1);
INSERT INTO examples.team VALUES(DEFAULT,'nuggets',1,2);
INSERT INTO examples.team VALUES(DEFAULT,'lakers',2,2);
INSERT INTO examples.team VALUES(DEFAULT,'spurs',3,2);

/*
 * You can add Dates using a variety of methods, for example:
 * 'YYYY-MM-DD' : i.e. 2000-01-10
 * 'Month Day, YYYY' : i.e. January 10, 2000 
 * 'YYYY-Mon-DD' : i.e. 2000-Jan-10
 * TO_DATE('YYYY/MM/DD','<Formatting>')
 * Or using the built-in 'CURRENT_DATE' for the current date
 * to name a few...
 */
INSERT INTO examples.players VALUES (DEFAULT,1,'Bill Smith',450000,DATE '2020-01-10');
INSERT INTO examples.players VALUES (DEFAULT,1,'Matt Jones',470000,TO_DATE('2020/01/10','YYYY/MM/DD'));
INSERT INTO examples.players VALUES (DEFAULT,1,'Joe Williams',480000,'January 10, 2010');
INSERT INTO examples.players VALUES (DEFAULT,1,'Gary Brown',447500,'2000-Jan-10');

INSERT INTO examples.players VALUES (DEFAULT,2,'Dill Smith',650000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,2,'Pat Jones',660000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,2,'Moe Williams',620000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,2,'Larry Brown',635000,CURRENT_DATE);

INSERT INTO examples.players VALUES (DEFAULT,3,'Hill Smith',700000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,3,'Cat Jones',710000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,3,'Poe Williams',690000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,3,'Perry Brown',730000,CURRENT_DATE);

INSERT INTO examples.players VALUES (DEFAULT,4,'Phil Smith',550000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,4,'Kat Jones',590000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,4,'Whoa Williams',540000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,4,'Terri Brown',620000,CURRENT_DATE);

INSERT INTO examples.players VALUES (DEFAULT,5,'Will Smith',580000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,5,'Yatt Jones',550000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,5,'Slo-Mo Williams',540000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,5,'Jerri Brown',580000,CURRENT_DATE);

INSERT INTO examples.players VALUES (DEFAULT,6,'Nill Smith',600000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,6,'Fatt Jones',580000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,6,'Romo Williams',590000,CURRENT_DATE);
INSERT INTO examples.players VALUES (DEFAULT,6,'Scary Brown',610000,CURRENT_DATE);