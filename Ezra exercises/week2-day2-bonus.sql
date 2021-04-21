/*Principles have a name, hire date, and salary.
Schools have a name, and a reference to a principle
Students have a name, a Grade (7th, 8th, 9th, etc...), 
a home address, an emergency contact phone number, and a reference to a school
*/
CREATE TABLE principles(
	id serial PRIMARY KEY,
	name varchar(50) ,
	hire_date date,
	salary money
);

CREATE TABLE Schools (
name varchar(50) PRIMARY KEY,
principle integer REFERENCES principles(id)
);

CREATE TABLE Students (
id serial PRIMARY KEY,
name varchar(50),
grade integer,
address varchar(100), --blob DATATYPE would NOT work
phone varchar(14),
school varchar(50) REFERENCES Schools(name)
);