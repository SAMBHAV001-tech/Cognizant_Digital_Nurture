Exercise 8 - Strategy Pattern


What is the Strategy Pattern

The Strategy pattern is a behavioral design pattern that defines a family of algorithms, puts each one in a separate class, and makes them interchangeable. The context class uses a strategy through an interface, so the actual algorithm can be swapped at runtime without changing the context.


How it Works

PaymentStrategy is the interface that defines the pay() method. CreditCardPayment and PayPalPayment are two different implementations of this strategy. PaymentContext holds a reference to a PaymentStrategy and calls strategy.pay() when executePayment() is called. The strategy can be changed at any time by calling setStrategy() with a different implementation. The context does not care which specific payment method is used - it just knows it has a strategy that can pay.


Why it is Used

Without Strategy pattern, PaymentContext would have a big if-else or switch block checking the payment type and calling different code for each case. Adding a new payment method would require modifying this class. With Strategy pattern, adding a new payment method like UPI means just creating a new class that implements PaymentStrategy. No existing code needs to change. This follows the Open/Closed Principle.


Real World Use Cases

Sorting algorithms can be a strategy - you might want to sort differently based on data size. Compression algorithms (zip, tar, gzip) can be strategies in a file compressor. Navigation apps use strategy to switch between fastest route, shortest route, and avoid-tolls route. Java's Comparator interface is essentially a strategy for comparison logic.


Difference from State Pattern

Both Strategy and State patterns involve an object changing behavior. In Strategy, the context chooses a strategy based on user or business logic. In State, the object itself changes behavior when its internal state changes (like a vending machine behaving differently when out of stock).
