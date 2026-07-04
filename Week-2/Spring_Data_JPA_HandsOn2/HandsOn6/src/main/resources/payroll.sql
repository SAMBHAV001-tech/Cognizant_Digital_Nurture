CREATE TABLE IF NOT EXISTS department (
    dp_id INT PRIMARY KEY,
    dp_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(50) NOT NULL,
    em_salary DECIMAL(10,2) NOT NULL,
    em_permanent BOOLEAN NOT NULL,
    em_date_of_birth DATE NOT NULL,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

CREATE TABLE IF NOT EXISTS skill (
    sk_id INT PRIMARY KEY,
    sk_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee_skill (
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);
