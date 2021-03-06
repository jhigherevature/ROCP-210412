# Project 0: Banking App

### Description
Leverage Java, Maven, JDBC and SQL to create an application that simulates simple banking transactions

### Requirements

* Build the application using Java 8
* All interaction with the user should be done through the console using the Scanner class
* Customers of the bank should be able to register with a username and password, and apply to open an account.
* Customers should be able to apply for joint accounts
* Once the account is open, customers should be able to withdraw, deposit, and transfer funds between accounts
* All basic validation should be done, such as trying to input negative amounts, overdrawing from accounts etc.
* Employees of the bank should be able to view all of their customers information. This includes:
* Account information
* Account balances
* Personal information
* Employees should be able to approve/deny open applications for accounts
* Bank admins should be able to view and edit all accounts
  * This includes:
    * Approving/denying accounts
    * withdrawing, depositing, transferring from all accounts
    * canceling accounts
* 100% test coverage is expected using JUnit
* You should be using TDD
* Logging should be accomplished using Log4J
* All transactions should be logged using Log4J
* Create an SQL script that will create a user in an SQL database and a table schema for storing your bank users and account information.
* Have your bank application connect to your SQL database using JDBC and store all information that way.
* You should use the DAO design pattern for data connectivity.

# Stretch Goals
* Password Hashing
* Time Stamping
* Run from the command line
* All information should be persisted using text files and serialization
* Your database should include at least 1 stored procedure.