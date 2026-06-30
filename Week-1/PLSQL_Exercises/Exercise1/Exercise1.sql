CREATE TABLE Customers (
    CustomerID   NUMBER PRIMARY KEY,
    Name         VARCHAR2(100),
    DOB          DATE,
    Balance      NUMBER(15,2),
    LastModified DATE,
    IsVIP        VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE Accounts (
    AccountID    NUMBER PRIMARY KEY,
    CustomerID   NUMBER REFERENCES Customers(CustomerID),
    AccountType  VARCHAR2(20),
    Balance      NUMBER(15,2),
    InterestRate NUMBER(5,2),
    LastModified DATE
);

CREATE TABLE Transactions (
    TransactionID   NUMBER PRIMARY KEY,
    AccountID       NUMBER REFERENCES Accounts(AccountID),
    TransactionDate DATE,
    Amount          NUMBER(15,2),
    TransactionType VARCHAR2(20)
);

CREATE TABLE Loans (
    LoanID       NUMBER PRIMARY KEY,
    CustomerID   NUMBER REFERENCES Customers(CustomerID),
    LoanAmount   NUMBER(15,2),
    InterestRate NUMBER(5,2),
    StartDate    DATE,
    EndDate      DATE
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name       VARCHAR2(100),
    Position   VARCHAR2(50),
    Salary     NUMBER(15,2),
    Department VARCHAR2(50)
);

CREATE TABLE AuditLog (
    LogID           NUMBER PRIMARY KEY,
    AccountID       NUMBER,
    TransactionDate DATE,
    Amount          NUMBER(15,2),
    TransactionType VARCHAR2(20)
);

CREATE SEQUENCE audit_seq START WITH 1 INCREMENT BY 1 NOCACHE;

INSERT INTO Customers VALUES (1, 'Alice',   DATE '1955-04-10', 15000, SYSDATE, 'FALSE');
INSERT INTO Customers VALUES (2, 'Bob',     DATE '1970-08-22', 8000,  SYSDATE, 'FALSE');
INSERT INTO Customers VALUES (3, 'Charlie', DATE '1948-11-05', 20000, SYSDATE, 'FALSE');
INSERT INTO Customers VALUES (4, 'Diana',   DATE '1985-03-17', 5000,  SYSDATE, 'FALSE');

INSERT INTO Accounts VALUES (101, 1, 'Savings', 15000, 5, SYSDATE);
INSERT INTO Accounts VALUES (102, 2, 'Current', 8000,  3, SYSDATE);
INSERT INTO Accounts VALUES (103, 3, 'Savings', 20000, 5, SYSDATE);
INSERT INTO Accounts VALUES (104, 4, 'Savings', 5000,  5, SYSDATE);

INSERT INTO Employees VALUES (1, 'Eve',   'Manager',   70000, 'HR');
INSERT INTO Employees VALUES (2, 'Frank', 'Developer', 50000, 'IT');
INSERT INTO Employees VALUES (3, 'Grace', 'Analyst',   45000, 'IT');

INSERT INTO Loans VALUES (1, 1, 100000, 12, DATE '2024-01-01', SYSDATE + 20);
INSERT INTO Loans VALUES (2, 3, 200000, 11, DATE '2023-06-01', SYSDATE + 5);
INSERT INTO Loans VALUES (3, 2, 50000,  9,  DATE '2024-03-01', SYSDATE + 60);

COMMIT;

SET SERVEROUTPUT ON;

BEGIN
    FOR r IN (
        SELECT l.LoanID, c.Name, l.InterestRate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60
    ) LOOP
        UPDATE Loans SET InterestRate = InterestRate - 1 WHERE LoanID = r.LoanID;
        DBMS_OUTPUT.PUT_LINE('Loan ' || r.LoanID || ' for ' || r.Name || ': rate reduced to ' || (r.InterestRate - 1) || '%');
    END LOOP;
    COMMIT;
END;
/

BEGIN
    FOR r IN (SELECT CustomerID, Name FROM Customers WHERE Balance > 10000) LOOP
        UPDATE Customers SET IsVIP = 'TRUE' WHERE CustomerID = r.CustomerID;
        DBMS_OUTPUT.PUT_LINE('Customer ' || r.Name || ' marked as VIP.');
    END LOOP;
    COMMIT;
END;
/

BEGIN
    FOR r IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || r.Name || ', your loan ID ' || r.LoanID || ' is due on ' || TO_CHAR(r.EndDate, 'DD-MON-YYYY') || '. Please arrange repayment.');
    END LOOP;
END;
/
