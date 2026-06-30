Exercise 11 - Dependency Injection


What is Dependency Injection

Dependency Injection (DI) is a design principle where an object receives its dependencies from outside rather than creating them itself. Instead of a class saying new CustomerRepositoryImpl() inside its own code, the repository is passed to the class from outside - usually through the constructor. This makes the class not responsible for building its own dependencies.


How it Works

CustomerService needs a CustomerRepository to function. Without DI, CustomerService would do this.repo = new CustomerRepositoryImpl() inside its constructor. This tightly couples CustomerService to CustomerRepositoryImpl. With DI, the constructor accepts a CustomerRepository parameter and stores it. Whoever creates CustomerService is responsible for providing the repository. In Main, we create the repository separately and pass it to the service: new CustomerService(repo). CustomerService does not care which specific implementation it gets as long as it implements CustomerRepository.


Types of Dependency Injection

Constructor Injection - dependencies are passed through the constructor (used in this exercise). This is the most recommended approach because it makes dependencies visible and required.

Setter Injection - dependencies are passed through setter methods after the object is created. Useful for optional dependencies.

Field Injection - dependencies are directly injected into fields, commonly done by frameworks like Spring using annotations like @Autowired. This is convenient but harder to test.


Why it is Used

Without DI, if we wanted to test CustomerService with a mock repository that returns fake data, we could not do it because the repository is created inside the service. With DI, we can pass any implementation that satisfies the CustomerRepository interface - including a mock for testing. This follows the Dependency Inversion Principle from SOLID - depend on abstractions, not concrete classes.


Real World Use Cases

Spring Framework is built entirely around DI. It manages the creation and injection of beans automatically. JUnit testing with Mockito uses DI to inject mocked dependencies into classes being tested. Almost every enterprise Java application uses DI containers for managing object creation and wiring.
