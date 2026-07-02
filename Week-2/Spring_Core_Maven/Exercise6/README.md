Exercise 6 - Annotation-Based Configuration

What is Annotation-Based Configuration
Instead of writing extensive XML code to define beans and inject dependencies, Spring allows developers to use annotations directly in the Java classes. The Spring IoC container automatically detects these annotated classes and manages them.

Key Spring Annotations
- @Repository: Indicates that the class acts as a Data Access Object (DAO) or repository. It handles database communication and translates database exceptions.
- @Service: Indicates that the class holds business logic.
- @Autowired: Instructs Spring to automatically inject the matching dependency (by type) into the constructor, setter method, or field.
- @Component: A generic stereotype annotation. Any class annotated with @Component is detected as a Spring bean. @Repository and @Service are specializations of @Component.

How Component Scanning Works
To make Spring find these annotations, we enable component scanning in applicationContext.xml using:
<context:component-scan base-package="com.library"/>
This tells Spring to scan the com.library package and all its subpackages, locate any classes annotated with stereotype annotations, and register them as beans in the container.
