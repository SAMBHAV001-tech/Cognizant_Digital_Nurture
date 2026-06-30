Exercise 3 - Stored Procedures in PL/SQL


What are Stored Procedures

A stored procedure is a named PL/SQL block that is saved in the database and can be called by name whenever needed. Unlike anonymous blocks that run once and are not stored, procedures are reusable. They can accept input parameters, perform operations, and return results through output parameters. They are created using CREATE OR REPLACE PROCEDURE.


ProcessMonthlyInterest Procedure

This procedure applies monthly interest to all savings accounts. It uses a single UPDATE statement to increase the Balance by the InterestRate percentage for all accounts where AccountType is Savings. It also updates the LastModified column to the current date. SQL%ROWCOUNT gives the number of rows affected by the last SQL statement, which is printed for confirmation.


UpdateEmployeeBonus Procedure

This procedure accepts a department name and a bonus percentage, then increases the salary of all employees in that department by the given percentage. Before updating, it checks if any employees exist in the department and prints a message if none are found. The RETURN statement exits the procedure early if there is nothing to update.


TransferFunds Procedure

This procedure transfers a specified amount from one account to another. It first fetches the balance of the source account and checks if it is sufficient. If not, it raises a custom error. If the balance is enough, it deducts the amount from the source and adds it to the destination. Error handling is included for account not found and other database errors.


Key Concepts Used

CREATE OR REPLACE PROCEDURE - creates or replaces a stored procedure in the database.
IN parameter - input parameter passed to the procedure by the caller.
SQL%ROWCOUNT - number of rows affected by the most recent SQL statement.
RETURN - exits the procedure early without executing remaining code.
FOR UPDATE - locks the selected rows to prevent concurrent modifications during a transaction.
