Exercise 2 - Dependency Injection

What is Dependency Injection
Dependency Injection (DI) is a technique where the dependencies of a class are provided by the framework rather than the class creating them itself. Instead of writing new BookRepository() inside BookService, the repository object is injected by Spring.

What is Setter Injection
In Setter Injection, the Spring IoC container injects the dependency by calling setter methods on the bean after invoking a no-argument constructor. In our applicationContext.xml, the property tag is used to pass the bookRepository bean reference into the BookService bean via setBookRepository().

Setter Injection vs Constructor Injection
- Setter Injection: Good for optional dependencies. The bean can be created first and dependencies can be injected later. It uses the property tag in XML.
- Constructor Injection: Good for mandatory dependencies. The bean cannot be created without passing the dependencies in the constructor. It uses the constructor-arg tag in XML.
