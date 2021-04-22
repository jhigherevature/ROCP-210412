DROP TABLE IF EXISTS Students;
DROP TABLE IF EXISTS Schools;
DROP TABLE IF EXISTS Principles; 


CREATE TABLE Principles (
	principle_name varchar(220),
	hire_date DATE,
	salary decimal,
	PRIMARY KEY (principle_name)
);

CREATE TABLE Schools (
	school_name varchar(220),
	principle_name varchar(220),
	PRIMARY KEY (school_name),
	FOREIGN KEY (principle_name) REFERENCES Principles(principle_name)
);


CREATE TABLE Students (
	grade int,
	home_add varchar(220),
	emer_cont varchar(220),
	school_name varchar(220),
	FOREIGN KEY (school_name) REFERENCES Schools(school_name)
);


