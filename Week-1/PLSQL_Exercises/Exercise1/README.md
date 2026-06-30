Exercise 1 - Control Structures in PL/SQL


What are Control Structures

Control structures in PL/SQL are used to control the flow of execution in a program. They include conditional statements like IF-THEN-ELSE, loops like FOR LOOP, WHILE LOOP, and LOOP-EXIT, and sequential statements. They work the same way as in most programming languages but are written inside PL/SQL blocks which start with BEGIN and end with END.


Scenario 1 - Reduce Loan Interest for Senior Customers

This scenario uses a FOR loop to go through all customers who are above 60 years old. The age is calculated using the MONTHS_BETWEEN function which gives the difference in months between two dates, divided by 12 to get years. For each matching customer, the interest rate on their loan is reduced by 1 percent and a message is printed using DBMS_OUTPUT.PUT_LINE.


Scenario 2 - Mark VIP Customers

This scenario loops through all customers with a balance above 10000 and sets their IsVIP column to TRUE. The FOR loop automatically handles opening, fetching, and closing the cursor. This is called an implicit cursor loop in PL/SQL.


Scenario 3 - Loan Due Reminders

This scenario fetches loans where the EndDate falls within the next 30 days using SYSDATE + 30. For each such loan, a reminder message is printed with the customer name, loan ID, and due date formatted using TO_CHAR.


Key PL/SQL Concepts Used

FOR loop with implicit cursor - automatically iterates over query results without needing to explicitly open, fetch, and close a cursor.
MONTHS_BETWEEN - Oracle function to calculate difference between two dates in months.
TO_CHAR - converts dates to formatted strings for display.
DBMS_OUTPUT.PUT_LINE - prints output to the console in Oracle SQL Developer or SQL Plus.
COMMIT - saves all changes made during the block to the database.
