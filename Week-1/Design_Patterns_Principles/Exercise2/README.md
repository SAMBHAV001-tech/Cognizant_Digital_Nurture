Exercise 2 - Factory Method Pattern


What is the Factory Method Pattern

The Factory Method pattern is a creational design pattern that defines an interface or abstract class for creating objects, but lets the subclasses decide which class to instantiate. Instead of calling new directly in the code, we call a factory method that returns the appropriate object. This separates the code that uses an object from the code that creates it.


How it Works

There is an abstract DocumentFactory class with an abstract method createDocument(). Each concrete factory like WordDocumentFactory, PdfDocumentFactory, and ExcelDocumentFactory extends this class and overrides the createDocument() method to return the specific document type. The client code just calls createDocument() on whichever factory it has, without knowing the exact class being created.


Why it is Used

If we used new WordDocument() directly in the main code, the code becomes tightly coupled to the specific class. If we later want to add a new document type, we have to change the main code. With Factory Method, we just add a new factory class and the existing code does not need to change. This follows the Open/Closed Principle - open for extension, closed for modification.


Real World Use Cases

GUI toolkits use factory methods to create buttons, text fields, and windows for different operating systems. In Java, the Calendar.getInstance() method is an example of factory method usage. Database drivers also use factory patterns to create connections.


Difference from Simple Factory

In a simple factory, one class has a static method with if-else or switch to decide which object to create. In the Factory Method pattern, each type gets its own dedicated factory class. This makes it easier to add new types without modifying existing factory code.
