Exercise 5 - Spring IoC Container

What is the Spring IoC Container
The Spring IoC container is the core engine of the Spring Framework. It is responsible for instantiating, configuring, and assembling beans. The container gets its instructions by reading configuration metadata (like XML files or annotations) and executes them accordingly.

BeanFactory vs ApplicationContext
Spring provides two main types of IoC container interfaces:
- BeanFactory: The simplest container that provides basic support for Dependency Injection and bean creation. It uses lazy initialization (loading beans only when requested).
- ApplicationContext: A more advanced container built on top of BeanFactory. It adds enterprise-specific functionalities such as internationalization, event publishing, and easy integration with Spring AOP. It pre-instantiates singleton beans at startup. In modern Spring applications, ApplicationContext is almost always preferred over BeanFactory.
