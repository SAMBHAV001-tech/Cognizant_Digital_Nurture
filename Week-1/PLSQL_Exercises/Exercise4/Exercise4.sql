SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION CalculateAge(p_dob IN DATE) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END CalculateAge;
/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount   IN NUMBER,
    p_annual_rate   IN NUMBER,
    p_tenure_months IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_emi          NUMBER;
BEGIN
    IF p_annual_rate = 0 THEN
        RETURN ROUND(p_loan_amount / p_tenure_months, 2);
    END IF;

    v_monthly_rate := p_annual_rate / (12 * 100);
    v_emi := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, p_tenure_months)
             / (POWER(1 + v_monthly_rate, p_tenure_months) - 1);
    RETURN ROUND(v_emi, 2);
END CalculateMonthlyInstallment;
/

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
) RETURN VARCHAR2 IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;

    IF v_balance >= p_amount THEN
        RETURN 'TRUE';
    ELSE
        RETURN 'FALSE';
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'FALSE';
END HasSufficientBalance;
/

DECLARE
    v_age  NUMBER;
    v_emi  NUMBER;
    v_flag VARCHAR2(10);
BEGIN
    v_age := CalculateAge(DATE '1955-04-10');
    DBMS_OUTPUT.PUT_LINE('Age of customer born on 10-APR-1955: ' || v_age || ' years');

    v_emi := CalculateMonthlyInstallment(100000, 12, 24);
    DBMS_OUTPUT.PUT_LINE('Monthly installment for loan of 100000 at 12% for 24 months: ' || v_emi);

    v_flag := HasSufficientBalance(101, 5000);
    DBMS_OUTPUT.PUT_LINE('Account 101 has sufficient balance for 5000: ' || v_flag);

    v_flag := HasSufficientBalance(104, 99999);
    DBMS_OUTPUT.PUT_LINE('Account 104 has sufficient balance for 99999: ' || v_flag);
END;
/
