--ROLE AND USER PERMISSIONS--
--https://www.postgresql.org/docs/current/sql-grant.html

--need to create role permissions: admin, school, donor, employee
--		then add user permissions 

CREATE ROLE user_admin WITH PASSWORD 'adminpassword';
-- giving permission on schema level doesnt work, neither on anything but S.U.D. permissions
-- SELECT, UPDATE, DELETE, COMMIT, ROLLBACK, 
--	SAVEPOINT ON TABLES account, donation, donor, income, parent, 
--	pledge, scholarship, school, school_contact, student TO user_admin; 
GRANT SELECT, INSERT, UPDATE, DELETE
	 ON ALL TABLES IN SCHEMA project 
    TO user_admin WITH GRANT OPTION;
   
--   sample to pull from:
-- GRANT { { SELECT | INSERT | UPDATE | REFERENCES } ( column_name [, ...] )
--    [, ...] | ALL [ PRIVILEGES ] ( column_name [, ...] ) }
--    ON [ TABLE ] table_name [, ...]
--    TO role_specification [, ...] [ WITH GRANT OPTION ]

CREATE ROLE user_school WITH PASSWORD 'schoolpassword';
GRANT SELECT, UPDATE ON income, pledge, scholarship, school, 
	school_contact, student TO user_school;
IF project.donor.allow_school_contact IS TRUE, GRANT SELECT ON donor TO user_school;
GRANT SELECT ON donation, income, parent, 
	pledge, scholarship, school, school_contact, student TO user_admin;