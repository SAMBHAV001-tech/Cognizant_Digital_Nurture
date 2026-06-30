SET SERVEROUTPUT ON;

CREATE OR REPLACE TRIGGER trg_customers_lastmodified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END trg_customers_lastmodified;
/

CREATE OR REPLACE TRIGGER trg_accounts_lastmodified
BEFORE UPDATE ON Accounts
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END trg_accounts_lastmodified;
/

CREATE OR REPLACE TRIGGER trg_audit_transactions
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (LogID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (audit_seq.NEXTVAL, :NEW.AccountID, :NEW.TransactionDate, :NEW.Amount, :NEW.TransactionType);
END trg_audit_transactions;
/

CREATE OR REPLACE TRIGGER trg_validate_transaction
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    IF :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20010, 'Transaction amount must be greater than zero.');
    END IF;

    IF :NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = :NEW.AccountID;
        IF v_balance < :NEW.Amount THEN
            RAISE_APPLICATION_ERROR(-20011, 'Insufficient balance for withdrawal. Available: ' || v_balance);
        END IF;
    END IF;
END trg_validate_transaction;
/

UPDATE Customers SET Balance = 16000 WHERE CustomerID = 1;

SELECT CustomerID, Name, LastModified FROM Customers WHERE CustomerID = 1;

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 101, SYSDATE, 1000, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 102, SYSDATE, 500, 'Withdrawal');

SELECT * FROM AuditLog;

BEGIN
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (3, 104, SYSDATE, 99999, 'Withdrawal');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Expected error caught: ' || SQLERRM);
END;
/

BEGIN
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (4, 101, SYSDATE, -500, 'Deposit');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Expected error caught: ' || SQLERRM);
END;
/
