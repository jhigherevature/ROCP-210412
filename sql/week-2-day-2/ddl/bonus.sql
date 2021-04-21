CREATE SCHEMA district

    CREATE TABLE district.principals (
        principal_id SERIAL PRIMARY KEY,
        principal_name VARCHAR(50),
        hire_date DATE,
        salary MONEY
    )

    CREATE TABLE district.schools (
        school_id SERIAL PRIMARY KEY,
        school_name VARCHAR(50) NOT NULL,
        school_principal INTEGER,
        CONSTRAINT fk_principal
            FOREIGN KEY (school_principal)
                REFERENCES principals(principal_id)
    )

    CREATE TABLE district.students (
        student_id SERIAL PRIMARY KEY,
        student_name VARCHAR(50),
        grade VARCHAR(4),
        home_address VARCHAR(100),
        emergency_contact VARCHAR(12),
        student_school INTEGER,
        CONSTRAINT fk_school
            FOREIGN KEY (student_school)
                REFERENCES schools(school_id)
    )
;