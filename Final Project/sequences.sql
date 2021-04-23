-- create SEQUENCES 

-- need to change serial to integer then add:     DEFAULT nextval('id_scholarship')   to end of line
CREATE SEQUENCE id_account_seq START WITH 91111 INCREMENT BY 1;
--DROP SEQUENCE id_donor_seq;
CREATE SEQUENCE id_donor_seq START WITH 77777 INCREMENT BY 1;

CREATE SEQUENCE id_income_seq START WITH 7777 INCREMENT BY 1;
CREATE SEQUENCE id_parent_seq START WITH 5555 INCREMENT BY 1;

CREATE SEQUENCE id_pledge_seq START WITH 55555 INCREMENT BY 1;
CREATE SEQUENCE id_donation_seq START WITH 33333 INCREMENT BY 1;

CREATE SEQUENCE id_scholarship_seq START WITH 22222 INCREMENT BY 1;

CREATE SEQUENCE id_school_seq START WITH 10 INCREMENT BY 1;
CREATE SEQUENCE id_school_contact_seq START WITH 100 INCREMENT BY 1;
CREATE SEQUENCE id_student_seq START WITH 1111 INCREMENT BY 1;

CREATE OR REPLACE FUNCTION id_account_func() RETURNS TRIGGER 
AS $$
	BEGIN
		IF NEW.id_account IS NULL THEN 
			NEW.id_account:=NEXTVAL('id_account_seq');
			RETURN NEW;
		END IF;
--		IF NEW.id_account IS DEFAULT THEN
--			NEW.id_account:=nextval('id_account_seq');
--			RETURN NEW;
--		END IF;
	END;
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER id_account_trig
BEFORE INSERT ON project.account 
FOR EACH ROW
EXECUTE PROCEDURE id_account_func();

CREATE OR REPLACE FUNCTION id_donor_func() RETURNS TRIGGER 
AS $$
	BEGIN
		IF NEW.id_donor IS NULL THEN 
			NEW.id_donor:=NEXTVAL('id_donor_seq');
			RETURN NEW;
		END IF;
--		IF NEW.id_donor IS DEFAULT THEN
--			NEW.id_donor:=nextval('id_donor_seq');
--			RETURN NEW;
--		END IF;
	END;
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER id_donor_trig
BEFORE INSERT ON project.donor 
FOR EACH ROW
EXECUTE PROCEDURE id_donor_func();