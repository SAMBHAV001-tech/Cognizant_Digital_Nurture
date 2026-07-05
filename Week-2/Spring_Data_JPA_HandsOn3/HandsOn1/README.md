Hands-on 1 – Introduction to HQL and JPQL

What is HQL (Hibernate Query Language)
HQL is an object-oriented query language, similar to SQL, but instead of operating on database tables and columns, HQL operates on Java entity classes and their properties. HQL is specific to Hibernate ORM.

What is JPQL (Java Persistence Query Language)
JPQL is the standard object-oriented query language defined by the JPA (Java Persistence API) specification. JPQL is a subset of HQL. It is database-independent and works with any JPA provider (such as Hibernate, EclipseLink, or OpenJPA).

Comparison between HQL and JPQL

- Specification: JPQL is a standard defined by JPA specification. HQL is Hibernate's proprietary query language that extends JPQL.
- Features: HQL is more powerful and supports features not available in JPQL (for example, native SQL-like functions, dynamic joins, select clauses, delete/update statements).
- Portability: JPQL queries are fully portable across any JPA provider. HQL queries are specific to Hibernate and may not run directly on other JPA providers.
- Operation: Both languages run queries using Java class names (e.g. Employee) and field names (e.g. name) instead of database table names (e.g. employee) and column names (e.g. em_name).
