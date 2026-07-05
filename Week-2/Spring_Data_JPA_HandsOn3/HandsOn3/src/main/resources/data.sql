INSERT INTO users (us_id, us_name) VALUES (1, 'Sambhav Das');

INSERT INTO question (qn_id, qn_text) VALUES (1, 'What is JPA?');
INSERT INTO options (op_id, op_text, op_qn_id) VALUES (1, 'ORM Specification', 1);
INSERT INTO options (op_id, op_text, op_qn_id) VALUES (2, 'Java Persistence API', 1);
INSERT INTO options (op_id, op_text, op_qn_id) VALUES (3, 'Database Driver', 1);

INSERT INTO question (qn_id, qn_text) VALUES (2, 'What is Spring Boot?');
INSERT INTO options (op_id, op_text, op_qn_id) VALUES (4, 'Framework Extension', 2);
INSERT INTO options (op_id, op_text, op_qn_id) VALUES (5, 'Java Platform', 2);
INSERT INTO options (op_id, op_text, op_qn_id) VALUES (6, 'Standard Specification', 2);

INSERT INTO attempt (at_id, at_us_id) VALUES (1, 1);

INSERT INTO attempt_question (aq_id, aq_at_id, aq_qn_id) VALUES (1, 1, 1);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id) VALUES (1, 1, 2);

INSERT INTO attempt_question (aq_id, aq_at_id, aq_qn_id) VALUES (2, 1, 2);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id) VALUES (2, 2, 4);
