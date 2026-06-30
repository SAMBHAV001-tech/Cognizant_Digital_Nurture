SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in account ' || p_from_account);
    END IF;

    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer of ' || p_amount || ' from account ' || p_from_account || ' to ' || p_to_account || ' successful.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Source account ' || p_from_account || ' not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;
/

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_emp_id    IN NUMBER,
    p_increment IN NUMBER
) IS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count FROM Employees WHERE EmployeeID = p_emp_id;

    IF v_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Employee with ID ' || p_emp_id || ' not found.');
    END IF;

    UPDATE Employees SET Salary = Salary + p_increment WHERE EmployeeID = p_emp_id;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated for employee ID ' || p_emp_id || ' by ' || p_increment);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_id      IN NUMBER,
    p_name    IN VARCHAR2,
    p_dob     IN DATE,
    p_balance IN NUMBER
) IS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count FROM Customers WHERE CustomerID = p_id;

    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Customer with ID ' || p_id || ' already exists.');
    END IF;

    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE, 'FALSE');

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer ' || p_name || ' added successfully.');
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Duplicate customer ID ' || p_id);
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddNewCustomer;
/

BEGIN SafeTransferFunds(101, 102, 500); END;
/
BEGIN SafeTransferFunds(101, 102, 999999); END;
/
BEGIN UpdateSalary(1, 5000); END;
/
BEGIN UpdateSalary(99, 5000); END;
/
BEGIN AddNewCustomer(10, 'Henry', DATE '1990-01-01', 3000); END;
/
BEGIN AddNewCustomer(1, 'Alice Again', DATE '1990-01-01', 3000); END;
/
