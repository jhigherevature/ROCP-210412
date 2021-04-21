CREATE SCHEMA district;

CREATE TABLE district.principals (
	"name" varchar(50) UNIQUE PRIMARY KEY NOT NULL,
	hire_date date,
	salary int CHECK (salary > 0)
);

CREATE TABLE district.schools (
	"name" varchar(50) UNIQUE PRIMARY KEY NOT NULL,
	principal varchar(50),
	FOREIGN KEY (principal) REFERENCES district.principals("name") ON DELETE RESTRICT
);

CREATE TABLE district.students (
	"name" varchar(50) UNIQUE PRIMARY KEY NOT NULL,
	grade integer CHECK (grade BETWEEN 0 AND 12),
	home_address varchar(200),
	emergency_contact integer,
	school varchar(50),
	FOREIGN KEY (school) REFERENCES district.schools("name")
);