Hands-on 1 – Spring Data JPA Quick Example

What is Spring Data JPA
Spring Data JPA is part of the larger Spring Data family. It makes it extremely easy to implement JPA-based repositories. It reduces the boilerplate code required to interact with databases by automatically generating repository implementations at runtime based on interface definitions.

Key Concepts
- JpaRepository: An interface provided by Spring Data JPA that contains standard CRUD methods like save(), findById(), findAll(), deleteById(), etc.
- Entity: A Java class annotated with @Entity that is mapped to a database table. In this hands-on, the Country class is mapped to the country table.
- CommandLineRunner: A Spring Boot interface used to run a block of code immediately after the application starts. We use it to load and print the list of countries.
