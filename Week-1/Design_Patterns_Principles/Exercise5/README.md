Exercise 5 - Decorator Pattern


What is the Decorator Pattern

The Decorator pattern is a structural design pattern that lets you add extra behavior to an object at runtime without changing its class. Instead of creating a new subclass for every combination of features, you wrap the object with decorator classes that add the extra behavior. Each decorator implements the same interface as the object it wraps.


How it Works

EmailNotifier is the base implementation of the Notifier interface. It just sends an email. SMSNotifierDecorator and SlackNotifierDecorator both extend NotifierDecorator, which wraps any Notifier. When send() is called on a decorator, it first calls send() on the wrapped notifier (which could itself be another decorator), and then adds its own notification. This creates a chain effect. For example, wrapping Email with SMS and then Slack means all three channels get triggered when send() is called.


Why it is Used

Without decorators, if we wanted combinations like EmailAndSMS, EmailAndSlack, EmailAndSMSAndSlack, we would need a separate class for each combination. With decorators, we just stack them at runtime in any combination we want. Adding a new channel like WhatsApp just means creating one new decorator class without touching anything else.


Real World Use Cases

Java's I/O streams are the most classic example. BufferedReader wraps an InputStreamReader which wraps an InputStream - each layer adds functionality (buffering, character decoding, etc.) without modifying the previous one. In web development, middleware in frameworks like Express.js works similarly.


Difference from Inheritance

Inheritance adds behavior at compile time through subclasses. Decorator adds behavior at runtime by wrapping objects. Decorator is more flexible because you can mix and match behaviors dynamically without an explosion of subclass combinations.
