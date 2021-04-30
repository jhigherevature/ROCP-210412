## SQL Study Guide

You should be able to explain and apply the following topics:

### SQL
- What is SQL
	Structured Query Language
	used to communicate with databases
- What are the SQL sublanguages;
	DDL (Data Definition Language)
		Create, Alter, Drop, Truncate (automatic commit)
	DML (Data Manipulation Language)
		Insert, Update, Delete (CRUD operations, create/read/update/delete)
	DQL (Data Query Language) (sometimes placed in DML)
		Select (non-transactional, meaning it does not make changes to the database)
			modifiers (in order of operation):
				From, Where(Like, uses % and _, the latter single. Between/And, In), Group By, Having, (Select happens here), Order By
	DCL (Data Control Language)
		Grant, Revoke
	TCL (Transaction Control Language)
		Commit, Rollback, Savepoint, Release Set Transaction
- What are the Key Statements for the Sub Languages
	See sublanguages above
- What is multiplicity
	a definition of the upper and lower bounds of cardinality (boundries)
- What is cardinality
	a description of the numerical relationship between two tables (actual relationship)
		one to one [1:1]
		one to many [1:n]
		many to many [n:n]
- What is a Primary Key
	unique, not null, if more than one column then it is composite key
- What is a Foreign Key
	a column that references the primary key of another table
- What is referential integrity
	the consistency and accuracy of data across multiple tables
- What are the different constraints
	check, not null, unique
- What do you call a record with a foreign key relationship that doesn’t exist
	orphaned record
- What are the differences between WHERE vs HAVING
	where is useful for excluding data/individual querys, having for group querys/aggregate functions 
- what are the differences between GROUP BY and ORDER BY
	group by allows aggregate functions, order by is optional and allows you to order by asc or desc
- What is the difference between an aggregate function and a scalar function?
	aggregate function works on a group of data, scalar on a single value
- Name some scalar functions and their usage
	ucase() converts a field to upper case
	lcase() converts a field to lower case
	len() returns the length of a text field
	round() rounds a numeric field to the number of decimals specified
	now() returns the current system date and time
- Name some aggregate functions and their usage
	avg() returns the average value
	count() returns the number of rows
	first() returns the first value
	last() returns the last value
	sum() returns the sum
	min/max() returns the smallest/largest value
- What does LIKE do?
	used in where statements when you are unsure of the whole value or you want to match a pattern
	The ‘%’ signifies a wildcard for any number of characters.
	The ‘_’ signifies a wildcard for a single character
		there is a not like, does the inverse
- How do I use sub queries?
	you embed it within the where clause, returns data that further modifies the outer query
	Subqueries must be enclosed within parentheses.
	A subquery can have only one column in the SELECT clause, unless multiple columns are in the main query for the subquery to compare its selected columns.
	An ORDER BY command cannot be used in a subquery, although the main query can use an ORDER BY. The GROUP BY command can be used to perform the same function as the ORDER BY in a subquery.
	Subqueries that return more than one row can only be used with multiple value operators such as the IN operator.
	The SELECT list cannot include any references to values that evaluate to a BLOB, ARRAY, CLOB, or NCLOB.
	A subquery cannot be immediately enclosed in a set function.
	The BETWEEN operator cannot be used with a subquery. However, the BETWEEN operator can be used within the subquery.
- How does BETWEEN work?
	compares data between a range of values, lowest to largest
	notbetween shows data outside of parameters
	between can be modified (not in will prevent provided parameters from being shown)
- What is the order of operations in an SQL statement?
	Select (declared here)From, Where, Group By, Having, (Select happens here), Order By
- What are the different joins in SQL?
	equi joins
		inner (natural)Returns records that have matching values in both tables
		outer
	theta joins
		makes use of comparison operator other than the equal sign
- What are the different set operations in SQL?
	union
	intersect
	except
	can use all
- Difference between union and union all
	union keeps unique records, union all keeps all (duplicates included records)
- What is the difference between joins and set operations?
	join combines columns from tables, set combines rows
- How can I create an alias in SQL
	use the as keyword followed by the alias
- What does the AS keyword do in a query?
	allows you to create an alias inside a query (and only inside the query)
- What are the properties of a transaction?
	Atomicity, all operations must succeed or transaction is aborted and changes reverted
	Consistency, ensures database properly updates, referential integrity/constraints maintained
	Isolation, enables transactions to operate independant of each other
	Durability, ensures the results of a committed transaction persists, even during system failure
- What are the transaction isolation levels and what do they prevent?
	Read Uncommitted allows application to read uncommitted data (not good)
	read committed (dfefault) can only read committed data
	repeatable read prevents non-repeatable read
	serializable does not allow transactions to occur simultaniously
		these prevent transaction problems
- What are dirty reads, non repeatable reads, and phantom reads?
	dirty read is when a transaction reads data that has been added by a different non-commited transaction
	non-repeatable read is when a transaction re-reads data and finds another transaction has altered/deleted the data
	Phatom read is when a transaction returns a query to find that the number of records that satisfies a certain condition has changed
- What is normalization
	Database normalization is a design pattern which aims to reduce duplicate data and reduce redundancy.
	Also provides reference integrity
	tables are atomic, broken down into smallest meaningful data
- What are the requirements for the different normalization levels
	0NF no normalization
	1NF atomic, each record unique, tables have primary key
	2NF like 1NF, but no composite keys
	3NF like 2NF, but all dependencies are primary keys
	Denormalization adding redundancy and duplication for easier reading. Normally not a good idea
- What is pl/pgsql
	Procedural language/PostGreStructured Query Langauge
		provides a means to write code in SQL that is reminiscent of a programming type language
- What are triggers
	an object that waits for actions to occur on a specific table
	can occur before or after the trigger event
		insert, update, delete, truncate
	works with non-select CRUD operations

### MAVEN
- What is Maven?
	Yiddish for "Accumulation of knowledge"
	tool for building/managing java projects
		automates process of importing files into build path/project structure
	utilizes large repository of projects that are avilable for programers
- What are the Maven Lifecycles?
	validate check the pom.xml, parse it, locate/download dependencies
	compile source code is compiled
	testing done by suitable unit testing framework, like JUNIT
	package compiled code packaged into distributable format, like JAR or WAR
	verify Run check on results of integration tests to ensure quality is met
	deploy Copies packages into remote repository. Performed in build environment
		if any step is called, all the previous steps execute
			these are part of default lifecycle, there is also cleaning and site(documentation)
- What is the purpose of the POM.xml?
	Project Object File(POM)
	Extensible Markup File (XML)
		singleton configuration file that contains most of the information that is required 
		to build a project in just the way you want.

### Design Patterns
- What is the difference between Singleton and Factory?
	singelton
		ensures a single instance of a class is created throughout lifetime of the application
			lazy singleton is when creation only happens when needed
			eager singleton makes the class available when loaded into memory
	factory
		uses interface to provide control over creation of objects in superclass
		allows subclasses to implement spceific type of objects that will be created
		aloows creation of objects without exposing creation logic to users
		allows reference to objects by a common interface

### JDBC
- What is JDBC
	Java Database Connectivity
		API used to allow Java apps interaction with SQL databases
			located in java.sql package
- What are the interfaces and classes of JDBC
	DriverManager [class] – Provides instance of specific drivers (uses a factory design pattern)
	Driver <interface> - Interfacing entity that speak to SQL
	Connection <interface> - Connection between the application in java and the database
	Statement <interface> - Responsible for executing actions on the database
	ResultSet <interface> - Responsible for transporting query results from the database
	SQLExcception [class] – Provides information regarding mistakes accessing the database.
- What are the different types of statements
	simple - literal interpretation of SQL strings, compiled/executed database side
		risky (possible SQL injection)
	prepared - parameterized data passed into SQL (compiled java side, can prevent SQL injection)
	callable statemnt - Allow for the execution of stored procedures and functions and execution of PL/SQL
		Postgre 11+
- What is SQL Injection
	the inclusion of unintended SQL statements sent to a database through input streams
		can cause unintended consequences in the database
- What is a DAO
	design pattern uses java objects in order to access tables in SQL databases.
	interfaces/classes organize way in which information is retrieved and transactions performed