--dummy data

INSERT INTO project.scholarship (year_scholarship, id_student, id_school, amt_approved, new_student)
VALUES (2020, 1443,45, 2500.01, false), (2020, 1422, 54, 1201, true);

INSERT INTO student (id_student) VALUES (1443), (1422);
INSERT INTO school (id_school) VALUES (45), (54);
INSERT INTO income (id_income) VALUES (default), (default), (default), (default), (default), (default);

INSERT INTO income (id_income) VALUES (nextval(id_income)),(nextval(id_income)),(nextval(id_income)),(nextval(id_income)),(nextval(id_income));

INSERT INTO project.donor (id_donor, id_account ,
title,first_name,last_name, 
address, city ,zip ,
phone , email , soc_sec, notes, allow_school_contact, donor_status) VALUES
(null, DEFAULT, 'mr', 'Johnson', 'Johnson', '4123 Lineway dr.', 'Atlanta', 90740, 123-456-7890, 'Johnson@johnson.com', 123-12-1234, 'asflkjaoefinna osadfoaef', TRUE, true),
(null, DEFAULT, 'mrs', 'Johnsonetta', 'Johnson', '4123 Lineway dr.', 'Atlanta', 90740, 123-456-7899, 'Johnsonetta@johnson.com', 122-12-1234, 'asflinna osadfoaef kjaoef', TRUE, true);