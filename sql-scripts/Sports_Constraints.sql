CREATE TABLE state (
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

CREATE TABLE sports (
	sport_id SERIAL PRIMARY KEY,
	sport_name varchar(100) NOT NULL
);

CREATE TABLE team (
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

CREATE TABLE players (
	player_id SERIAL PRIMARY KEY,
	team_id integer REFERENCES team(team_id),
	player_name varchar(100),
	player_salary integer,
	draft_date date
);


