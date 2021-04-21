

--CREATE SEQUENCE emp_id_seq START WITH 1000 INCREMENT BY 2;


CREATE OR REPLACE SEQUENCE emp_id_seq START WITH 1000 INCREMENT BY 2; -- give starting value followed BY amount TO INCREMENT 

--what TO apply SEQUENCE IN the FUNCTION 
CREATE OR REPLACE FUNCTION emp_id_func() RETURNS TRIGGER 	--this IS grammar IF you want TO use a TRIGGER must ADD "returns trigger"
AS $$												-- AS keyword IN a FUNCTION IS what must come BEFORE $$ TO create
	BEGIN 
		IF NEW.emp_id IS NULL THEN 					-- NEW.emp_id essentially means that emp_id IS a property OF the NEW keyword, ALSO IF IS NOT a requirement IN function
			NEW.emp_id:=nextval('emp_id_seq'); 		-- ":=" means SET LEFT side equal TO RIGHT side
	END;
	$$ LANGUAGE plpgsql;		--must END BY defining what LANGUAGE FUNCTION IS written IN
	
	CREATE FUNCTION emp_id_func() RETURNS TRIGGER
AS $$											
	BEGIN 
		IF NEW.emp_id IS NULL THEN 					
			NEW.emp_id:=nextval('emp_id_seq'); 	
	END;
	$$ LANGUAGE plpgsql;
--	create trigger so this happens
CREATE TRIGGER emp_id_trig
BEFORE INSERT examples.employees
FOR EACH ROW 
EXECUTE PROCEDURE emp_id_func;

INSERT INTO examples.employees VALUES (null, 'Sam', 'intern', 40000.00);
