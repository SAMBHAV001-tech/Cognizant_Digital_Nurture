INSERT INTO department (dp_id, dp_name) VALUES (1, 'Human Resources');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'Engineering');
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES ('Alice', 60000.00, true, '1990-05-15', 1);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES ('Bob', 80000.00, true, '1992-08-20', 2);
INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'SQL');
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 2);
