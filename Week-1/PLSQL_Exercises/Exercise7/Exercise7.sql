SET SERVEROUTPUT ON;

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(
        p_id      IN NUMBER,
        p_name    IN VARCHAR2,
        p_dob     IN DATE,
        p_balance IN NUMBER
    );
    PROCEDURE UpdateCustomerBalance(p_id IN NUMBER, p_amount IN NUMBER);
    FUNCTION GetCustomerBalance(p_id IN NUMBER) RETURN NUMBER;
    PROCEDURE GetCustomerDetails(p_id IN NUMBER);
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_id      IN NUMBER,
        p_name    IN VARCHAR2,
        p_dob     IN DATE,
        p_balance IN NUMBER
    ) IS
        v_count NUMBER;
    BEGIN
        SELECT COUNT(*) INTO v_count FROM Customers WHERE CustomerID = p_id;
        IF v_count > 0 THEN
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || p_id || ' already exists.');
            RETURN;
        END IF;
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
        VALUES (p_id, p_name, p_dob, p_balance, SYSDATE, 'FALSE');
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Customer ' || p_name || ' added with ID ' || p_id);
    END AddCustomer;

    PROCEDURE UpdateCustomerBalance(p_id IN NUMBER, p_amount IN NUMBER) IS
    BEGIN
        UPDATE Customers SET Balance = Balance + p_amount WHERE CustomerID = p_id;
        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || p_id || ' not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Balance updated for customer ' || p_id);
        END IF;
    END UpdateCustomerBalance;

    FUNCTION GetCustomerBalance(p_id IN NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END GetCustomerBalance;

    PROCEDURE GetCustomerDetails(p_id IN NUMBER) IS
        v_name    Customers.Name%TYPE;
        v_dob     Customers.DOB%TYPE;
        v_balance Customers.Balance%TYPE;
        v_vip     Customers.IsVIP%TYPE;
    BEGIN
        SELECT Name, DOB, Balance, IsVIP INTO v_name, v_dob, v_balance, v_vip
        FROM Customers WHERE CustomerID = p_id;
        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ' | DOB: ' || TO_CHAR(v_dob, 'DD-MON-YYYY') || ' | Balance: ' || v_balance || ' | VIP: ' || v_vip);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Customer ID ' || p_id || ' not found.');
    END GetCustomerDetails;

END CustomerManagement;
/

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_id     IN NUMBER,
        p_name   IN VARCHAR2,
        p_pos    IN VARCHAR2,
        p_salary IN NUMBER,
        p_dept   IN VARCHAR2
    );
    PROCEDURE UpdateSalary(p_id IN NUMBER, p_new_salary IN NUMBER);
    PROCEDURE ApplyDepartmentBonus(p_dept IN VARCHAR2, p_pct IN NUMBER);
    FUNCTION GetEmployeeCount(p_dept IN VARCHAR2) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_id     IN NUMBER,
        p_name   IN VARCHAR2,
        p_pos    IN VARCHAR2,
        p_salary IN NUMBER,
        p_dept   IN VARCHAR2
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department)
        VALUES (p_id, p_name, p_pos, p_salary, p_dept);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Employee ' || p_name || ' hired in ' || p_dept || ' department.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Employee ID ' || p_id || ' already exists.');
    END HireEmployee;

    PROCEDURE UpdateSalary(p_id IN NUMBER, p_new_salary IN NUMBER) IS
    BEGIN
        UPDATE Employees SET Salary = p_new_salary WHERE EmployeeID = p_id;
        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Employee ID ' || p_id || ' not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Salary updated to ' || p_new_salary || ' for employee ' || p_id);
        END IF;
    END UpdateSalary;

    PROCEDURE ApplyDepartmentBonus(p_dept IN VARCHAR2, p_pct IN NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Salary = Salary + (Salary * p_pct / 100)
        WHERE Department = p_dept;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_pct || '% applied to ' || SQL%ROWCOUNT || ' employee(s) in ' || p_dept);
    END ApplyDepartmentBonus;

    FUNCTION GetEmployeeCount(p_dept IN VARCHAR2) RETURN NUMBER IS
        v_count NUMBER;
    BEGIN
        SELECT COUNT(*) INTO v_count FROM Employees WHERE Department = p_dept;
        RETURN v_count;
    END GetEmployeeCount;

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(
        p_acc_id  IN NUMBER,
        p_cust_id IN NUMBER,
        p_type    IN VARCHAR2,
        p_balance IN NUMBER,
        p_rate    IN NUMBER
    );
    PROCEDURE Deposit(p_acc_id IN NUMBER, p_amount IN NUMBER);
    PROCEDURE Withdraw(p_acc_id IN NUMBER, p_amount IN NUMBER);
    FUNCTION GetBalance(p_acc_id IN NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_acc_id  IN NUMBER,
        p_cust_id IN NUMBER,
        p_type    IN VARCHAR2,
        p_balance IN NUMBER,
        p_rate    IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, InterestRate, LastModified)
        VALUES (p_acc_id, p_cust_id, p_type, p_balance, p_rate, SYSDATE);
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Account ' || p_acc_id || ' opened for customer ' || p_cust_id);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Account ID ' || p_acc_id || ' already exists.');
    END OpenAccount;

    PROCEDURE Deposit(p_acc_id IN NUMBER, p_amount IN NUMBER) IS
    BEGIN
        IF p_amount <= 0 THEN
            DBMS_OUTPUT.PUT_LINE('Deposit amount must be positive.');
            RETURN;
        END IF;
        UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE WHERE AccountID = p_acc_id;
        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Account ' || p_acc_id || ' not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('Deposited ' || p_amount || ' to account ' || p_acc_id);
        END IF;
    END Deposit;

    PROCEDURE Withdraw(p_acc_id IN NUMBER, p_amount IN NUMBER) IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_acc_id;
        IF v_balance < p_amount THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance. Available: ' || v_balance);
        END IF;
        UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE WHERE AccountID = p_acc_id;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Withdrawn ' || p_amount || ' from account ' || p_acc_id || '. Remaining: ' || (v_balance - p_amount));
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Account ' || p_acc_id || ' not found.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Withdrawal error: ' || SQLERRM);
    END Withdraw;

    FUNCTION GetBalance(p_acc_id IN NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_acc_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END GetBalance;

END AccountOperations;
/

BEGIN
    CustomerManagement.AddCustomer(20, 'Sam', DATE '1995-06-15', 7500);
    CustomerManagement.GetCustomerDetails(20);
    CustomerManagement.UpdateCustomerBalance(20, 2500);
    DBMS_OUTPUT.PUT_LINE('Balance: ' || CustomerManagement.GetCustomerBalance(20));
END;
/

BEGIN
    EmployeeManagement.HireEmployee(10, 'Tom', 'Tester', 40000, 'QA');
    DBMS_OUTPUT.PUT_LINE('QA count: ' || EmployeeManagement.GetEmployeeCount('QA'));
    EmployeeManagement.UpdateSalary(10, 45000);
    EmployeeManagement.ApplyDepartmentBonus('IT', 15);
END;
/

BEGIN
    AccountOperations.OpenAccount(201, 1, 'Savings', 10000, 5);
    AccountOperations.Deposit(201, 5000);
    AccountOperations.Withdraw(201, 3000);
    DBMS_OUTPUT.PUT_LINE('Balance in 201: ' || AccountOperations.GetBalance(201));
    AccountOperations.Withdraw(201, 99999);
END;
/
