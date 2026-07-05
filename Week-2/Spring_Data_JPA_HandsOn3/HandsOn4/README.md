Hands-on 4 – Average Salary using HQL

What are Aggregate Functions in HQL
HQL supports standard SQL aggregate functions such as AVG(), SUM(), MIN(), MAX(), and COUNT(). These functions run on columns (entity properties) and return calculations directly from the database server, optimizing traffic.

Using Parameters inside Query Methods
We can pass method arguments dynamically to HQL queries using named parameters with the @Param annotation.
For example, the query:
"select avg(e.salary) from Employee e where e.department.id = :deptId"
calculates the average salary of employees belonging to the department with id matching the parameter value :deptId.
