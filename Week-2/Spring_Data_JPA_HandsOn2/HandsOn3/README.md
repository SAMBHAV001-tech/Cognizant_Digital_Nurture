Hands-on 3 – Payroll Tables and Bean Mapping

What is Bean Mapping in JPA
Bean mapping is the process of defining mapping associations between Java objects (entities) and database tables. We use annotations like:
- @Entity: Marks a class as a JPA entity.
- @Table: Maps the entity to a specific database table.
- @Id: Designates the field that acts as the primary key.
- @GeneratedValue: Tells the persistence provider to automatically generate the primary key values.
- @Column: Specifies properties of the column mapped to the field.

Entities Implemented
- Department: Represents a department with ID (dp_id) and name (dp_name).
- Employee: Represents an employee with ID (em_id), name (em_name), salary (em_salary), permanent flag (em_permanent), and date of birth (em_date_of_birth).
- Skill: Represents a professional skill with ID (sk_id) and name (sk_name).
