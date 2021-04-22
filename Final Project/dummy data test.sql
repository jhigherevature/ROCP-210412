--dummy data

INSERT INTO project.scholarship (year_scholarship, id_student, id_school, amt_approved, new_student)
VALUES (2020, 1443,45, 2500.01, false), (2020, 1422, 54, 1201, true);

INSERT INTO student (id_student) VALUES (1443), (1422);
INSERT INTO school (id_school) VALUES (45), (54);
INSERT INTO income (id_income) VALUES (default), (default), (default), (default), (default), (default);

INSERT INTO income (id_income) VALUES (nextval(id_income)),(nextval(id_income)),(nextval(id_income)),(nextval(id_income)),(nextval(id_income));
