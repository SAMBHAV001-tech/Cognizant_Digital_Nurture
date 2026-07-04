Hands-on 5 – Country Management Service

What is Country Management Service
This hands-on extends the basic Spring Data JPA project with complete CRUD operations (Create, Read, Update, Delete) and search operations for managing countries.

Key Operations Implemented
- findCountryByCode: Uses findById() method from JpaRepository. If the country does not exist, it throws a custom CountryNotFoundException.
- addCountry: Saves a new country entity using save() method from JpaRepository.
- updateCountry: Finds the existing country, updates its name property, and saves it.
- deleteCountry: Checks if the country exists by ID. If yes, deletes it using deleteById(); otherwise, throws a CountryNotFoundException.
- findCountriesByNameContaining: Uses Spring Data JPA query creation naming convention (findByNameContaining()) to search for countries that contain a partial name (for example, searching for "In" returns "India").

Database Operations
SQL DDL script (schema.sql) and DML sample insert script (data.sql) are loaded at database initialization time to prepare the schema and populate default country records.
