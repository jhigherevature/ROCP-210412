-- create SEQUENCES 

-- need to change serial to integer then add:     DEFAULT nextval('id_scholarship')   to end of line
DROP SEQUENCE id_account_seq;
CREATE SEQUENCE id_account_seq START WITH 90001 INCREMENT BY 1;
CREATE SEQUENCE id_userpass_seq START WITH 100 INCREMENT BY 1;
--DROP SEQUENCE id_donor_seq;
CREATE SEQUENCE id_donor_seq START WITH 70001 INCREMENT BY 1;
CREATE SEQUENCE id_parent_seq START WITH 5000 INCREMENT BY 1;
CREATE SEQUENCE id_emp_seq START WITH 10 INCREMENT BY 1;
CREATE SEQUENCE id_school_contact_seq START WITH 100 INCREMENT BY 1;


CREATE SEQUENCE id_income_seq START WITH 7777 INCREMENT BY 1;

CREATE SEQUENCE id_pledge_seq START WITH 55555 INCREMENT BY 1;
CREATE SEQUENCE id_donation_seq START WITH 33333 INCREMENT BY 1;

CREATE SEQUENCE id_scholarship_seq START WITH 22222 INCREMENT BY 1;

CREATE SEQUENCE id_school_seq START WITH 10 INCREMENT BY 1;
--DROP SEQUENCE id_school_seq;


CREATE SEQUENCE id_student_seq START WITH 1111 INCREMENT BY 1;

DROP TRIGGER id_userpass_trig;
DROP FUNCTION id_account_trig;

DROP FUNCTION id_userpass_func();
DROP FUNCTION id_account_func();
DROP FUNCTION id_emp_func();
DROP FUNCTION id_donor_func();
DROP FUNCTION id_pledge_func();
-- NEW IS KEYWORD THAT IS ESSENTIALLY THE VARIABLE FOR ALL INFORMATION IN RECORD
--function must return something?
--currently don't need functions and triggers for sequences
CREATE OR REPLACE FUNCTION id_account_func() RETURNS TRIGGER 
AS $$
	BEGIN
		IF NEW.id_account IS NULL THEN 
			NEW.id_account:=NEXTVAL('id_account_seq');
			RETURN NEW;
		END IF;
	--can't use default keyword in functions because it means something different than in table creation 'default'
--		IF NEW.id_account IS DEFAULT THEN
--			NEW.id_account:=nextval('id_account_seq');
--			RETURN NEW;
--		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;
--
CREATE TRIGGER id_account_trig
BEFORE INSERT ON project.account 
FOR EACH ROW
EXECUTE PROCEDURE id_account_func();
--

CREATE OR REPLACE FUNCTION id_emp_func() RETURNS TRIGGER 
AS $$
	BEGIN
		IF NEW.id_emp IS NULL THEN 
			NEW.id_emp:=NEXTVAL('id_emp_seq');
			RETURN NEW;
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;
--
CREATE TRIGGER id_emp_trig
BEFORE INSERT ON project.employee 
FOR EACH ROW
EXECUTE PROCEDURE id_emp_func();
--
CREATE OR REPLACE FUNCTION id_userpass_func() RETURNS TRIGGER 
AS $$
	BEGIN
		IF NEW.id_userpass IS NULL THEN 
			NEW.id_userpass:=NEXTVAL('id_userpass_seq');
			RETURN NEW;
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;
--
CREATE TRIGGER id_userpass_trig
BEFORE INSERT ON project.userpass 
FOR EACH ROW
EXECUTE PROCEDURE id_userpass_func();

CREATE OR REPLACE FUNCTION id_pledge_func() RETURNS TRIGGER 
AS $$
	BEGIN
		IF NEW.id_pledge IS NULL THEN 
			NEW.id_pledge:=NEXTVAL('id_pledge_seq');
			RETURN NEW;
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;
--
CREATE TRIGGER id_pledge_trig
BEFORE INSERT ON project.pledge 
FOR EACH ROW
EXECUTE PROCEDURE id_pledge_func();
--
CREATE OR REPLACE FUNCTION id_donor_func() RETURNS TRIGGER 
AS $$
	BEGIN
		IF NEW.id_donor IS NULL THEN 
			NEW.id_donor:=NEXTVAL('id_donor_seq');
			RETURN NEW;
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;
--
CREATE TRIGGER id_donor_trig
BEFORE INSERT ON project.donor 
FOR EACH ROW
EXECUTE PROCEDURE id_donor_func();
--
CREATE OR REPLACE FUNCTION id_school_func() RETURNS TRIGGER 
AS $$
	BEGIN
		IF NEW.id_school IS NULL THEN 
			NEW.id_school:=NEXTVAL('id_school_seq');
			RETURN NEW;
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;
--
CREATE TRIGGER id_school_trig
BEFORE INSERT ON project.school 
FOR EACH ROW
EXECUTE PROCEDURE id_school_func();
--

--sample for other tables - can use find/replace on account to other table
CREATE OR REPLACE FUNCTION id_account_func() RETURNS TRIGGER 
AS $$
	BEGIN
		IF NEW.id_account IS NULL THEN 
			NEW.id_account:=NEXTVAL('id_account_seq');
			RETURN NEW;
		END IF;
		RETURN NEW;
	END;
$$ LANGUAGE PLPGSQL;
--
CREATE TRIGGER id_account_trig
BEFORE INSERT ON project.account
FOR EACH ROW
EXECUTE PROCEDURE id_account_func();
--


--CREATE OR REPLACE FUNCTION id_donor_func() RETURNS TRIGGER 
--AS $$
--	BEGIN
--		IF NEW.id_donor IS NULL THEN 
--			NEW.id_donor:=NEXTVAL('id_donor_seq');
--			RETURN NEW;
--		END IF;
----		IF NEW.id_donor IS DEFAULT THEN
----			NEW.id_donor:=nextval('id_donor_seq');
----			RETURN NEW;
----		END IF;
--	END;
--$$ LANGUAGE PLPGSQL;
--
--CREATE TRIGGER id_donor_trig
--BEFORE INSERT ON project.donor 
--FOR EACH ROW
--EXECUTE PROCEDURE id_donor_func();