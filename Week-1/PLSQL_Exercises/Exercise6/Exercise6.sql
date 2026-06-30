SET SERVEROUTPUT ON;

DECLARE
    CURSOR c_monthly_statement IS
        SELECT a.AccountID,
               c.Name,
               a.AccountType,
               a.Balance,
               a.InterestRate
        FROM Accounts a
        JOIN Customers c ON a.CustomerID = c.CustomerID
        ORDER BY c.Name;

    v_account_id   Accounts.AccountID%TYPE;
    v_name         Customers.Name%TYPE;
    v_type         Accounts.AccountType%TYPE;
    v_balance      Accounts.Balance%TYPE;
    v_rate         Accounts.InterestRate%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('========== Monthly Account Statement ==========');
    OPEN c_monthly_statement;
    LOOP
        FETCH c_monthly_statement INTO v_account_id, v_name, v_type, v_balance, v_rate;
        EXIT WHEN c_monthly_statement%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Account: ' || v_account_id || ' | Customer: ' || v_name || ' | Type: ' || v_type || ' | Balance: ' || v_balance || ' | Rate: ' || v_rate || '%');
    END LOOP;
    CLOSE c_monthly_statement;
    DBMS_OUTPUT.PUT_LINE('Total accounts printed: ' || c_monthly_statement%ROWCOUNT);
END;
/

DECLARE
    CURSOR c_savings IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
        FOR UPDATE OF Balance;

    v_fee NUMBER := 50;
BEGIN
    DBMS_OUTPUT.PUT_LINE('========== Annual Maintenance Fee Deduction ==========');
    FOR r IN c_savings LOOP
        IF r.Balance >= v_fee THEN
            UPDATE Accounts SET Balance = Balance - v_fee WHERE CURRENT OF c_savings;
            DBMS_OUTPUT.PUT_LINE('Account ' || r.AccountID || ': fee of ' || v_fee || ' deducted. New balance: ' || (r.Balance - v_fee));
        ELSE
            DBMS_OUTPUT.PUT_LINE('Account ' || r.AccountID || ': insufficient balance for fee. Skipped.');
        END IF;
    END LOOP;
    COMMIT;
END;
/

DECLARE
    CURSOR c_loans IS
        SELECT LoanID, CustomerID, InterestRate
        FROM Loans
        FOR UPDATE OF InterestRate;
BEGIN
    DBMS_OUTPUT.PUT_LINE('========== Loan Interest Rate Update ==========');
    FOR r IN c_loans LOOP
        IF r.InterestRate > 10 THEN
            UPDATE Loans SET InterestRate = r.InterestRate - 0.5 WHERE CURRENT OF c_loans;
            DBMS_OUTPUT.PUT_LINE('Loan ' || r.LoanID || ': rate reduced from ' || r.InterestRate || '% to ' || (r.InterestRate - 0.5) || '%');
        ELSE
            UPDATE Loans SET InterestRate = r.InterestRate + 0.5 WHERE CURRENT OF c_loans;
            DBMS_OUTPUT.PUT_LINE('Loan ' || r.LoanID || ': rate increased from ' || r.InterestRate || '% to ' || (r.InterestRate + 0.5) || '%');
        END IF;
    END LOOP;
    COMMIT;
END;
/
