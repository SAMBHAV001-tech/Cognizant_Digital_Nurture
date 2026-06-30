Exercise 4 - Functions in PL/SQL


What are Functions in PL/SQL

A function in PL/SQL is similar to a procedure but it must return a value. Functions are created using CREATE OR REPLACE FUNCTION and must have a RETURN clause specifying the data type of the value they return. Functions can be called in SQL queries, inside other PL/SQL blocks, or in expressions.


CalculateAge Function

This function takes a date of birth as input and calculates the age in years. MONTHS_BETWEEN returns the number of months between SYSDATE and the date of birth. Dividing by 12 converts months to years. TRUNC removes the decimal part to give a whole number age. The result is returned using the RETURN statement.


CalculateMonthlyInstallment Function

This function calculates the EMI (Equated Monthly Installment) for a loan using the standard formula: EMI = P * r * (1+r)^n / ((1+r)^n - 1), where P is the loan amount, r is the monthly interest rate (annual rate divided by 12 and 100), and n is the tenure in months. The POWER function computes (1+r)^n. A special case handles zero interest rate by simply dividing the principal by the number of months. The result is rounded to 2 decimal places using ROUND.


HasSufficientBalance Function

This function checks if an account has enough balance to cover a required amount. It fetches the balance using SELECT INTO. If the balance is greater than or equal to the required amount, it returns the string TRUE, otherwise FALSE. If the account does not exist, the NO_DATA_FOUND exception returns FALSE.


Key Concepts Used

RETURN data_type - specifies what type of value the function returns.
RETURN value - sends the value back to the caller.
MONTHS_BETWEEN - Oracle function to calculate month difference between two dates.
POWER(base, exponent) - calculates base raised to the power of exponent.
ROUND(number, decimals) - rounds a number to specified decimal places.
TRUNC - removes the fractional part of a number.
Functions vs Procedures - functions return a value and can be used in SQL expressions; procedures cannot return values directly but can use OUT parameters.
