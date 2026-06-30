Exercise 9 - Command Pattern


What is the Command Pattern

The Command pattern is a behavioral design pattern that turns a request into a standalone object. This object contains all the information about the request - what action to perform and on which receiver. The invoker does not know how the action is done; it just calls execute() on the command object.


How it Works

There are four parts in the Command pattern. The Command interface defines the execute() method. The receiver (Light) is the object that actually performs the action - it has turnOn() and turnOff() methods. The concrete commands (LightOnCommand, LightOffCommand) implement the Command interface and hold a reference to the receiver. When execute() is called on a command, it calls the appropriate method on the receiver. The invoker (RemoteControl) holds a command and calls execute() when the button is pressed. The invoker does not know anything about Light or what actions are performed.


Why it is Used

The RemoteControl does not need to know about Light or any other device. It just knows how to execute a command. If we want to add a new device like a Fan, we just create FanOnCommand and FanOffCommand classes. The RemoteControl stays unchanged. This makes the code very extensible. Commands can also be stored in a queue, executed later, or undone (by adding an undo() method to the interface).


Real World Use Cases

Text editors use commands for operations like cut, copy, paste, and undo. GUI buttons in applications attach commands to click events. Database transactions are commands that can be committed or rolled back. Job queues and task schedulers store commands to be executed later. Macro recording in applications records a sequence of commands and replays them.


Advantages

The invoker and receiver are completely decoupled. New commands can be added without modifying existing code. Commands can be serialized, stored, and replayed. Undo functionality can be added by keeping a history stack of executed commands.
