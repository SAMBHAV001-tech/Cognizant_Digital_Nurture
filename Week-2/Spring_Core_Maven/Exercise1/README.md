Exercise 1 - Basic Spring Application

What is Spring Framework
Spring is a popular framework for building Java applications. It helps developers manage objects and their dependencies easily. Instead of creating objects manually in code using new, Spring manages them in a container.

What is an IoC Container
IoC stands for Inversion of Control. It means that the control of creating and managing objects is handed over to the container (like Spring) instead of the developer writing the code. The container reads configurations (either XML or annotations) to create the objects, connect them together, and manage their lifecycle.

What is a Spring Bean
A Spring bean is simply an object that is created, managed, and configured by the Spring IoC container. In our code, BookService and BookRepository are defined as beans in applicationContext.xml.
