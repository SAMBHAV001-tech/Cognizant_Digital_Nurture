Exercise 7 - Packages in PL/SQL


What are Packages

A PL/SQL package is a container that groups related procedures, functions, variables, and cursors into a single named unit. Packages have two parts. The package specification (spec) is like a header file that declares what is publicly available. The package body contains the actual implementation of everything declared in the spec. Packages improve code organization, allow better encapsulation, and improve performance since the entire package is loaded into memory at once when any of its elements is first used.


Package 1 - CustomerManagement

This package handles customer-related operations. The spec declares four public subprograms: AddCustomer to insert a new customer after checking for duplicates, UpdateCustomerBalance to increase or decrease a customer balance, GetCustomerBalance as a function returning the balance, and GetCustomerDetails to print all customer information. The body implements each one. Private helper logic can be added to the body without exposing it in the spec.


Package 2 - EmployeeManagement

This package manages employee operations. HireEmployee inserts a new employee and handles duplicate ID gracefully. UpdateSalary updates an employee salary directly to a new value. ApplyDepartmentBonus increases salaries for all employees in a specified department by a percentage. GetEmployeeCount returns the number of employees in a given department. SQL%ROWCOUNT is used after updates to report how many rows were affected.


Package 3 - AccountOperations

This package covers bank account operations. OpenAccount creates a new account for a customer. Deposit adds money to an account with a positive-amount check. Withdraw subtracts money after validating the available balance, with proper error handling using ROLLBACK if needed. GetBalance returns the current balance of an account.


Key Concepts Used

CREATE OR REPLACE PACKAGE - creates the package specification (public interface).
CREATE OR REPLACE PACKAGE BODY - creates the implementation.
Package.Subprogram() - syntax to call a procedure or function from a package.
Encapsulation - only what is declared in the spec is accessible from outside the package.
Performance - packages are cached in memory after first use, reducing re-compilation overhead.
%TYPE - declares a variable with the same data type as a table column, making the code more maintainable.
