Exercise 4 - Adapter Pattern


What is the Adapter Pattern

The Adapter pattern is a structural design pattern that allows two incompatible interfaces to work together. It acts as a bridge between an existing class (which has its own method names) and a target interface (which our application expects). Instead of modifying the existing class, we wrap it in an adapter that implements the target interface.


How it Works

In this exercise, our application expects all payment gateways to implement the PaymentProcessor interface with a method called processPayment(). But each third-party gateway has its own method name. PayPal uses makePayment(), Stripe uses charge(), and Razorpay uses sendPayment(). Each adapter class implements PaymentProcessor and internally holds a reference to the specific gateway. When processPayment() is called, the adapter forwards the call to the gateway using its own method name.


Why it is Used

We cannot change the code of third-party libraries or legacy systems. The Adapter pattern lets us integrate them without modifying their code. Our main application only needs to know about the PaymentProcessor interface and does not care which gateway is being used underneath. This keeps the code loosely coupled.


Real World Use Cases

Java's InputStreamReader is an adapter that converts a byte stream (InputStream) into a character stream (Reader). Power adapters for travel convert different plug types to a standard shape. In Android, RecyclerView.Adapter adapts data to the list view format.


Difference from Decorator

Both Adapter and Decorator wrap another object, but they serve different purposes. The Adapter changes the interface of the wrapped object so it fits what the client expects. The Decorator keeps the same interface but adds extra behavior on top.
