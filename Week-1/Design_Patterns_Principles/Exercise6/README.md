Exercise 6 - Proxy Pattern


What is the Proxy Pattern

The Proxy pattern is a structural design pattern where a proxy object acts as a substitute or placeholder for another object. The proxy controls access to the real object and can add extra behavior like lazy initialization, caching, logging, or access control before forwarding calls to the actual object.


How it Works

RealImage is the actual object that does the heavy work of loading an image from disk. This loading happens in the constructor, so creating a RealImage is expensive. ProxyImage holds a reference to a RealImage but does not create it immediately. When display() is called on the proxy for the first time, it creates the RealImage (which triggers the disk load) and then calls display() on it. On all future calls, the same RealImage is reused since it is already stored in the realImage field. This is called lazy loading with caching.


Why it is Used

If we have a gallery of 100 images, we do not want to load all of them from disk at startup. With the proxy, images are only loaded when they are actually needed for display. This improves startup time and memory usage. Caching ensures the image is not loaded multiple times unnecessarily.


Types of Proxies

Virtual Proxy - delays creation of expensive objects until needed (this exercise).
Remote Proxy - represents an object in a different address space or machine (like Java RMI).
Protection Proxy - controls access rights to an object.
Logging Proxy - logs requests before forwarding them to the real object.


Real World Use Cases

Hibernate in Java uses proxies for lazy loading of database entities. Spring AOP uses proxies to add behavior like transaction management and security without modifying the actual class. Image thumbnails in file managers use a virtual proxy - only full images are loaded when you click on them.
