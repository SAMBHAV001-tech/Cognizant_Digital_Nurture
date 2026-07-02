Exercise 7 - Constructor and Setter Injection

What are Constructor and Setter Injection
These are two primary methods of injecting dependencies in a Spring application:

1. Constructor Injection: Dependencies are passed to the bean during its creation via its constructor.
- Configured using <constructor-arg> in XML.
- Best for mandatory dependencies because it ensures the object is always in a fully initialized, valid state immediately upon instantiation.
- Encourages immutability by allowing fields to be declared as final.

2. Setter Injection: Dependencies are passed to the bean via setter methods after it has been instantiated using a default no-argument constructor.
- Configured using <property> in XML.
- Best for optional or dynamically changeable dependencies.
- Allows resolving circular dependencies that cannot be resolved with constructor injection.
