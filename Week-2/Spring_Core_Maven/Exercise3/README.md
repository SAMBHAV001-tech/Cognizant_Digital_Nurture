Exercise 3 - Spring AOP Logging

What is Aspect-Oriented Programming (AOP)
AOP is a programming paradigm that allows developers to modularize cross-cutting concerns. These are features that span across multiple parts of an application, such as logging, security, and transaction management. Instead of duplicating logging code in every single service method, AOP lets us define the logging logic in one place (an Aspect) and apply it dynamically.

Key AOP Terminology
- Aspect: A class that implements the cross-cutting concern (e.g., LoggingAspect).
- Join Point: A point during the execution of a program, such as a method call.
- Pointcut: A predicate that matches join points (e.g., execution of any method in BookService).
- Advice: Action taken by an aspect at a particular join point (e.g., @Around advice to run before and after the method to log execution time).

How to Enable AOP in Spring
To use AOP, we add aspectjweaver dependency and enable it in applicationContext.xml using <aop:aspectj-autoproxy/>. Spring will automatically create a proxy for beans that match the aspect pointcuts.
