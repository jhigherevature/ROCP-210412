
BEGIN;
	INSERT INTO examples.employees VALUES (1013, 'Yancy', 'CEO', 150000);
	SAVEPOINT my_save_1;
	INSERT INTO examples.employees VALUES (1014, 'Nancy', 'Developer', 150000);
	INSERT INTO examples.employees VALUES (1015, 'Prancy', 'Manager', 150000);
SELECT * FROM examples.employees; -- window 1
	ROLLBACK TO SAVEPOINT my_save_1;
SELECT * FROM examples.employees; --  window 2

COMMIT;
	