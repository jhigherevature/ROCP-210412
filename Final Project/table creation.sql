--CREATE SCHEMA project;

CREATE TABLE project.account (
id_account serial PRIMARY KEY DEFAULT nextval('id_account'),
status varchar(15),		--CHECK length  6 OPTIONS:unconfirmed, incomplee, pledged, subitted, pay now
tax_filling_status varchar(30)		--6 OPTIONS?:single, married, married-joint, c-corp, businness, etc
);
--DROP TABLE project.school;
CREATE TABLE project.donor (
id_donor serial PRIMARY KEY,
id_account integer REFERENCES account(id_account) ,
title varchar(10) DEFAULT NULL,
first_name varchar(50),
last_name varchar(50),
address varchar(200),
city varchar(20),
state varchar(2) DEFAULT 'GA',
zip integer,
phone varchar(14),
email varchar(50),
email_alt varchar(50) DEFAULT NULL,
soc_sec varchar(11),		--social SECURITY need TO find a way TO protect FROM VIEW
notes varchar(1000),
allow_school_contact boolean,
donor_status boolean		--active/inactive
);

CREATE TABLE project.school (
id_school serial PRIMARY KEY,
name_school varchar(40),
address varchar(200),
city varchar(20),
state varchar(2) DEFAULT 'GA',
zip integer,
website varchar(40),
id_tax varchar(15)		--NOT sure IF included
);
--DROP TABLE project.pledge;
CREATE TABLE project.pledge (
id_pledge serial PRIMARY KEY,
id_account integer REFERENCES project.account(id_account),
year_pledge integer,				--what YEAR pledge IS for
pledge_amt money,
id_school int REFERENCES project.school(id_school),  
date_pledged date,					--CREATE TRIGGER FOR this
status_pledge varchar(20),		--OPTIONS?:pledged, submitted, approved 
submission_date date,			--date submitted TO government FOR approval
approval_date date 				--date approved BY gov't
);

CREATE TABLE project.donation (
id_donation serial PRIMARY KEY,
id_pledge integer REFERENCES pledge(id_pledge),
id_school int REFERENCES project.school(id_school),
year_donation integer, --REFERENCES project.donation(year_pledge),	--what YEAR DONATION IS FOR, can i DO this reference?
amt_approved money DEFAULT 0,								--this IS based ON amt_pledged*percentage_approved
amt_paid money DEFAULT 0,
date_paid timestamp,										--use transaction_timestamp() 
method_paid varchar(15),						--NOT sure about this one OPTIONS:credit FULL, credit PARTIAL, ACH, check
dap boolean,
ira boolean,
standard boolean 
);



CREATE TABLE project.school_contact(
id_contact serial PRIMARY KEY,
id_school int REFERENCES school(id_school),
title varchar(10) DEFAULT null,
first_name varchar(50),
last_name varchar(50),
job_title varchar(30),
phone varchar(14),
email varchar(50),
notes varchar(1000) DEFAULT null
);

CREATE TABLE project.income (
id_income serial PRIMARY KEY,
agi money,
num_dependents integer,
over_cap boolean			--want YES/NO
);

CREATE TABLE project.parent (
id_parent serial PRIMARY KEY,
id_income int REFERENCES income(id_income),
title varchar(10) DEFAULT null,
first_name varchar(50),
last_name varchar(50),
address varchar(200),
city varchar(20),
state varchar(2) DEFAULT 'GA',
zip integer,
phone varchar(14),
email varchar(50),
email_alt varchar(50) DEFAULT null
);


CREATE TABLE project.student (
id_student serial PRIMARY KEY,
id_school integer REFERENCES school(id_school),
first_name varchar(50),
last_name varchar(50),
address varchar(200),
city varchar(20),
state varchar(2) DEFAULT 'GA',
zip integer,
grade varchar(12),
id_income serial REFERENCES income(id_income),
prev_school int REFERENCES school(id_school)
);

DROP TABLE project.scholarship;
CREATE TABLE project.scholarship (
scholarship_id integer PRIMARY KEY DEFAULT nextval('id_scholarship') ,
year_scholarship int,		--YEAR scholarship IS associated WITH
id_student int REFERENCES student(id_student),
id_school int REFERENCES school(id_school),
scholarship_amt_req money,
status varchar(9), --requested approved denied
amt_approved money DEFAULT 0,
check_signed_status varchar(20),	--TO email, waiting, PARTIAL sign, FULL sign, 
amt_paid money DEFAULT 0,
date_paid timestamp,	--CREATE TRIGGER FOR amt_paid
new_student boolean, 	--student NEW TO PROGRAM?
transcript varchar(5000), 	--blob does NOT exist, big enough SIZE WITH varchar?
scholarship_note varchar(1000) DEFAULT null
);







