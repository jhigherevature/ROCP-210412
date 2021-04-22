DROP FUNCTION IF EXISTS emp_id_func;
DROP TRIGGER IF EXISTS emp_id_trig ON examples.employees;

/*
 * SEQUENCES - Objects that store a counter. We establish the initial value
 * 		as well as the modification value each time the sequence is called
 */
CREATE SEQUENCE emp_id_seq START WITH 1000 INCREMENT BY 2;

CREATE OR REPLACE FUNCTION emp_id_func() RETURNS TRIGGER 
AS $$
	BEGIN
		IF NEW.emp_id IS NULL THEN 
			NEW.emp_id:=NEXTVAL('emp_id_seq');
			RETURN NEW;
		END IF;
	END;
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER emp_id_trig
BEFORE INSERT ON examples.employees
FOR EACH ROW
EXECUTE PROCEDURE emp_id_func();

INSERT INTO examples.employees VALUES (1, 'Jody', 'Employee', 67000.00);

INSERT INTO examples.employees VALUES (NULL, 'Jody', 'Developer', 97000.00);

INSERT INTO examples.EMPLOYEES (emp_name) VALUES ('Margo');

INSERT INTO examples.employees VALUES (NEXTVAL('emp_id_seq'), 'Thomas', 'Developer', 92000.00);

