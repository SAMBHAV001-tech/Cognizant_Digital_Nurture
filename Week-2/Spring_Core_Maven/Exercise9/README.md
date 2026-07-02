Exercise 9 - Spring Boot Application

What is Spring Boot
Spring Boot is an extension of the Spring framework that makes it easy to create stand-alone, production-grade Spring-based applications. It removes the need for extensive XML configuration or complex setup boilerplate by using convention over configuration.

Key Features of Spring Boot
- Auto-Configuration: Automatically configures Spring beans based on the libraries added to the classpath. For example, adding spring-boot-starter-data-jpa and h2 automatically configures an in-memory database and an Entity Manager.
- Starter Dependencies: Combines multiple related dependencies into a single, easy-to-use maven dependency. For example, spring-boot-starter-web configures Spring MVC, Jackson (for JSON), and an embedded Tomcat server.
- Embedded Server: Tomcat is embedded directly inside the application, so we can run the app as a simple JAR using java -jar or mvn spring-boot:run without having to deploy it to an external web server.

REST API Endpoints Implemented
- GET /api/books: Returns the list of all books.
- GET /api/books/{id}: Returns a specific book by ID.
- POST /api/books: Creates and saves a new book.
- PUT /api/books/{id}: Updates the details of an existing book.
- DELETE /api/books/{id}: Deletes a book record from the database.
