Exercise 6 - Cursors in PL/SQL


What are Cursors

In PL/SQL, a cursor is a pointer to the result set of a SELECT query. Whenever a SELECT statement returns multiple rows, a cursor is used to process them one at a time. There are two types of cursors: implicit cursors which are automatically created for every DML statement, and explicit cursors which are manually defined, opened, fetched from, and closed by the programmer. Explicit cursors give more control over how rows are processed.


Cursor 1 - Monthly Statement

An explicit cursor c_monthly_statement is declared with a SELECT JOIN query that fetches account and customer details. The cursor is opened using OPEN, and rows are fetched one at a time inside a LOOP using FETCH INTO. The loop exits when c_monthly_statement%NOTFOUND becomes TRUE, meaning all rows have been fetched. After the loop, the cursor is closed using CLOSE. %ROWCOUNT gives the total number of rows fetched. This is the full manual cursor approach.


Cursor 2 - Annual Maintenance Fee

This cursor uses the FOR loop approach which automatically handles OPEN, FETCH, and CLOSE. The cursor includes FOR UPDATE OF Balance to lock the selected rows for safe updates. Inside the loop, WHERE CURRENT OF c_savings updates exactly the current row being processed without needing to specify the primary key. A fee of 50 is deducted from savings accounts with sufficient balance.


Cursor 3 - Loan Interest Rate Update

Similar to the second cursor, this one loops through all loans and adjusts the interest rate based on the current value. Loans with rates above 10 percent get a reduction of 0.5 percent. Others get an increase of 0.5 percent. WHERE CURRENT OF is used for efficient row-level updates.


Key Concepts Used

CURSOR cursor_name IS SELECT ... - declares an explicit cursor.
OPEN cursor_name - executes the query and prepares rows for fetching.
FETCH cursor_name INTO variables - retrieves the next row into variables.
cursor_name%NOTFOUND - becomes TRUE when no more rows are available.
cursor_name%ROWCOUNT - total rows fetched so far.
CLOSE cursor_name - releases the cursor resources.
FOR UPDATE OF column - locks rows for update; required for WHERE CURRENT OF.
WHERE CURRENT OF cursor - updates the row currently pointed to by the cursor.
FOR r IN cursor LOOP - shorthand cursor loop that automatically manages open, fetch, and close.
