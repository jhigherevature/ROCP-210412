--dummy data
--  https://analystanswers.com/dummy-data-definition-example-how-to-generate-it/


INSERT INTO project.account (
id_account, status, tax_filing_status) VALUES
(DEFAULT, 'unconfirmed', 'married-joint'),
(DEFAULT, 'unconfirmed', 'married-sep'),
(DEFAULT, 'unconfirmed', 'single');

INSERT INTO project.account (
status, tax_filing_status) VALUES
('unconfirmed', 'married-joint'),
('unconfirmed', 'married-sep'),
('unconfirmed', 'single');

INSERT INTO project.userpass (id_userpass, username, pw, access_lvl) VALUES
(default,'msomerset', 'stuff', 'emp'), (default, 'rcraigson', 'ostuff', 'admin');
INSERT INTO project.userpass (username, pw, access_lvl) VALUES
('John', 'b', 'donor'), ('Johnson', 'Johnson','donor');
--CAN't use null but can not include at all...will fill it by default
--INSERT INTO project.userpass (id_userpass, username, pw, access_lvl) VALUES
--(NULL, 'c', 'c', 'emp');

INSERT INTO project.employee (id_emp, first_name, last_name, emp_title, id_userpass)
VALUES (default, 'Michel', 'Somerset', 'employee', 17), (default, 'Rochel', 'Craigson', 'admin', 18);
INSERT INTO project.employee (id_emp, first_name, last_name, emp_title, id_userpass)
VALUES (default, 'Sam', 'Sommer', 'employee', 19);

INSERT INTO project.donor (id_donor, id_account, title,first_name,last_name, 
address, city ,zip, phone , email , soc_sec, notes, allow_school_contact, donor_status, id_userpass) VALUES
(DEFAULT, 91134, 'mr', 'Johnson', 'Johnson', '4123 Lineway dr.', 'Atlanta', 90740, 123-456-7890, 'Johnson@johnson.com', 123-12-1234, 'asflkjaoefinna osadfoaef', TRUE, TRUE, 20),
(DEFAULT, 91134, 'mrs', 'Johnsonetta', 'Johnson', '4123 Lineway dr.', 'Atlanta', 90740, 123-456-7899, 'Johnsonetta@johnson.com', 642-12-1234, 'asflinna osadfoaef kjaoef', TRUE, TRUE, 21);

INSERT INTO project.school (id_school , name_school, address, city, state, zip, website, id_tax) VALUES
			(DEFAULT, 'George Washington HS', '6732 1st Street', 'Atlanta', 'GA', 30347, 'www.georgewashingtonhighschool.edu', NULL);

INSERT INTO project.pledge (id_pledge, id_account,  year_pledge, pledge_amt, id_school,
			date_pledged, status_pledge,  submission_date, approval_date) VALUES
			(DEFAULT, 91134, 2020, 70.9, 10, CURRENT_DATE, 'pledged', NULL, NULL), 
		(DEFAULT, 91134, 2020, 100.2, 10, default, 'pledged', NULL, NULL);

	
--			implement later
INSERT INTO project.donation (id_donation, )
	
	
			
INSERT INTO project.scholarship (year_scholarship, id_student, id_school, amt_approved, new_student)
VALUES (2020, 1443,45, 2500.01, false), (2020, 1422, 54, 1201, true);

INSERT INTO student (id_student) VALUES (1443), (1422);

INSERT INTO school (id_school) VALUES (45), (54);

INSERT INTO income (id_income) VALUES (default), (default), (default), (default), (default), (default);

INSERT INTO income (id_income) VALUES (nextval(id_income)),(nextval(id_income)),(nextval(id_income)),(nextval(id_income)),(nextval(id_income));