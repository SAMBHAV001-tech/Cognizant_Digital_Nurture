CREATE TABLE IF NOT EXISTS users (
    us_id INT AUTO_INCREMENT PRIMARY KEY,
    us_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS attempt (
    at_id INT AUTO_INCREMENT PRIMARY KEY,
    at_us_id INT NOT NULL,
    FOREIGN KEY (at_us_id) REFERENCES users(us_id)
);

CREATE TABLE IF NOT EXISTS question (
    qn_id INT PRIMARY KEY,
    qn_text VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS options (
    op_id INT PRIMARY KEY,
    op_text VARCHAR(100) NOT NULL,
    op_qn_id INT NOT NULL,
    FOREIGN KEY (op_qn_id) REFERENCES question(qn_id)
);

CREATE TABLE IF NOT EXISTS attempt_question (
    aq_id INT AUTO_INCREMENT PRIMARY KEY,
    aq_at_id INT NOT NULL,
    aq_qn_id INT NOT NULL,
    FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
    FOREIGN KEY (aq_qn_id) REFERENCES question(qn_id)
);

CREATE TABLE IF NOT EXISTS attempt_option (
    ao_id INT AUTO_INCREMENT PRIMARY KEY,
    ao_aq_id INT NOT NULL,
    ao_op_id INT NOT NULL,
    FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id),
    FOREIGN KEY (ao_op_id) REFERENCES options(op_id)
);
