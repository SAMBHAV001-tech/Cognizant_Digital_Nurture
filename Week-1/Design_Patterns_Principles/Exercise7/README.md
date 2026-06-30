Exercise 7 - Observer Pattern


What is the Observer Pattern

The Observer pattern is a behavioral design pattern where one object (called the subject or publisher) maintains a list of dependents (called observers or subscribers) and automatically notifies all of them whenever its state changes. This creates a one-to-many relationship between the subject and its observers.


How it Works

StockMarket is the subject. It holds a list of Observer objects. MobileApp and WebApp implement the Observer interface with an update() method. When the stock price changes via setPrice(), StockMarket calls notifyObservers() which loops through all registered observers and calls update() on each one. New observers can be added with register() and removed with remove() without any changes to StockMarket itself.


Why it is Used

Without Observer pattern, StockMarket would have to directly call MobileApp.update() and WebApp.update() in its setPrice() method. This tightly couples StockMarket to specific observers. If we add a new EmailAlert observer, we would have to modify StockMarket. With Observer pattern, StockMarket does not know or care which observers are registered. Adding or removing observers has zero impact on StockMarket code.


Real World Use Cases

Event listeners in Java (ActionListener, MouseListener) follow the observer pattern. Model-View-Controller frameworks use it - the model notifies views when data changes. Reactive programming (RxJava, Kotlin Flow) is built on this idea. Push notifications, news feed subscriptions, and real-time dashboards all use observer-like mechanisms.


Difference from Polling

In polling, the observer repeatedly asks the subject if something changed. This is inefficient. In Observer pattern, the subject pushes updates to observers as soon as a change happens. This is event-driven and much more efficient.
