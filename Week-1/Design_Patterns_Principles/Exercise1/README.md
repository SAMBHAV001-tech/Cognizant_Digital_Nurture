Exercise 1 - Singleton Pattern


What is the Singleton Pattern

The Singleton pattern is a creational design pattern that ensures only one instance of a class is created throughout the entire application. No matter how many times you call getInstance(), you always get back the same object. This is useful when exactly one shared resource needs to be controlled, like a logger, a database connection, or a configuration manager.


How it Works

The class has a private constructor so no other class can directly create an object using new. It has a private static variable that holds the single instance. The public static method getInstance() checks if the instance is already created. If yes, it returns the existing one. If no, it creates one and stores it, then returns it.


Why it is Used

Without Singleton, every time a new Logger() is called, a separate object is created. This means different parts of the application might write logs in different places or with different settings. With Singleton, all parts of the application share the same logger object, so logging is consistent.


Real World Use Cases

Logging systems, database connection pools, configuration readers, thread pools, and cache managers are common places where Singleton is used.


Limitation

The basic Singleton shown here is not thread-safe. If two threads call getInstance() at the same time when instance is null, two objects might get created. This can be fixed using synchronized keyword or by creating the instance eagerly at class loading time using a static initializer.
