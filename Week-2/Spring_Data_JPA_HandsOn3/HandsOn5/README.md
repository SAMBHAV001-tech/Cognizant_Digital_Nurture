Hands-on 5 – Native Query

What is a Native Query in JPA
A Native Query is a query written in standard database SQL dialec instead of object-oriented HQL/JPQL. This is useful when we need to run complex database-specific queries, leverage specialized features (e.g. database-specific JSON functions, full-text indexes), or run optimization scripts.

JPA Configuration
We define a Native Query using the @Query annotation by specifying nativeQuery = true.
For example:
@Query(value = "SELECT * FROM employee", nativeQuery = true)
List<Employee> getAllEmployeesNative();
This query runs directly against the underlying database tables and returns entity records.
