Exercise 3 - Builder Pattern


What is the Builder Pattern

The Builder pattern is a creational design pattern used when an object has many fields, some of which are optional. Instead of having a constructor with many parameters (which is confusing and error-prone), we use a builder object that lets us set only the fields we need in a readable step-by-step way. The build() method at the end creates and returns the final object.


How it Works

The Computer class has a private constructor that only accepts a Builder object. The static nested Builder class has the same fields as Computer. Mandatory fields like CPU, RAM, and Storage are set through the Builder's constructor. Optional fields like GPU and OS have setter methods that return the Builder itself (method chaining). When all needed fields are set, build() is called which creates a new Computer using the builder's values.


Why it is Used

Without builder, if we had a constructor like Computer(cpu, ram, storage, gpu, os), we would have to pass null for fields we do not want to set. This is messy and hard to read. Builder makes the code clear - we can see exactly which fields are being set and skip the ones we do not need. It also avoids having multiple overloaded constructors.


Real World Use Cases

StringBuilder in Java uses a builder-like approach. HTTP request builders in libraries like OkHttp use this pattern. Alert dialogs in Android development use builders. Many configuration objects use this pattern when they have many optional settings.


Advantages

The object is always in a valid state when build() is called since mandatory fields are passed in the constructor. The code is very readable because each method name tells us what field is being set. We can reuse the same builder to create multiple similar objects with minor differences.
