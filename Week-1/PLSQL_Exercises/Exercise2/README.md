Exercise 2 - Error Handling in PL/SQL


What is Error Handling in PL/SQL

PL/SQL provides a structured way to handle errors using the EXCEPTION block. When an error occurs inside BEGIN-END block, control transfers to the EXCEPTION section where we can handle specific errors by name or catch all errors using WHEN OTHERS. This prevents the program from crashing unexpectedly and allows us to give meaningful messages and clean up using ROLLBACK.


SafeTransferFunds Procedure

This procedure transfers money between two bank accounts. It first selects the balance of the source account using FOR UPDATE to lock the row. If the balance is less than the transfer amount, it raises a custom error using RAISE_APPLICATION_ERROR with error code -20001. If an account does not exist, the NO_DATA_FOUND exception is caught and a rollback is performed. Any other unexpected error is caught by WHEN OTHERS which uses SQLERRM to print the error message and rolls back all changes.


UpdateSalary Procedure

This procedure updates an employee salary by a given increment. Before updating, it checks if the employee exists by counting rows. If the employee is not found, a custom error is raised. The WHEN OTHERS handler catches any unexpected database errors and performs a rollback.


AddNewCustomer Procedure

This procedure inserts a new customer. Before inserting, it checks if the customer ID already exists. If it does, it raises a custom application error to prevent duplicate entry. There is also a DUP_VAL_ON_INDEX handler as a safety net in case the primary key constraint triggers before the manual check. Any other error is caught by WHEN OTHERS with a rollback.


Key Concepts Used

RAISE_APPLICATION_ERROR - raises a user-defined error with a custom message and error number between -20000 and -20999.
NO_DATA_FOUND - built-in exception triggered when a SELECT INTO query returns no rows.
DUP_VAL_ON_INDEX - triggered when inserting a duplicate primary key value.
WHEN OTHERS - catches any unhandled exception as a fallback.
SQLERRM - returns the error message of the most recent exception.
ROLLBACK - undoes all uncommitted changes when an error occurs.
COMMIT - saves all changes to the database after successful operations.
