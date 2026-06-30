Exercise 5 - Triggers in PL/SQL


What are Triggers

A trigger in PL/SQL is a block of code that automatically executes in response to a specific database event on a table, such as INSERT, UPDATE, or DELETE. Triggers do not need to be called manually. They fire automatically when the triggering event happens. They are useful for auditing changes, enforcing business rules, and maintaining data consistency.


Trigger 1 - Update LastModified Automatically

Two BEFORE UPDATE triggers are created, one on Customers and one on Accounts. A BEFORE trigger fires before the actual operation takes place. FOR EACH ROW means the trigger runs once for every row affected by the update. Inside the trigger, :NEW refers to the new values being written. The trigger sets :NEW.LastModified to SYSDATE automatically, so every time a row is updated, the timestamp is refreshed without the application needing to set it explicitly.


Trigger 2 - Log Every Transaction into AuditLog

An AFTER INSERT trigger is created on the Transactions table. This fires after each new transaction is inserted. Inside the trigger, :NEW holds the values of the newly inserted row. The trigger inserts a corresponding row into the AuditLog table using audit_seq.NEXTVAL as the unique log ID. This ensures every transaction is automatically logged for audit purposes.


Trigger 3 - Validate Deposits and Withdrawals

A BEFORE INSERT trigger on the Transactions table validates each new transaction before it is saved. If the amount is zero or negative, it raises an error. If the transaction type is Withdrawal, it fetches the current account balance and checks if it is sufficient. If not, it raises an error using RAISE_APPLICATION_ERROR. Since this is a BEFORE trigger, raising an error prevents the INSERT from completing.


Key Concepts Used

BEFORE trigger - fires before the DML operation; can modify :NEW values or cancel the operation.
AFTER trigger - fires after the DML operation; useful for logging.
FOR EACH ROW - row-level trigger that executes once per affected row.
:NEW - reference to the new row values in INSERT and UPDATE triggers.
:OLD - reference to the old row values in UPDATE and DELETE triggers (not used here).
RAISE_APPLICATION_ERROR - cancels the operation and raises a user-defined error.
audit_seq.NEXTVAL - generates the next value from the sequence for unique log IDs.
