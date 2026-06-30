Exercise 10 - MVC Pattern


What is the MVC Pattern

MVC stands for Model-View-Controller. It is an architectural pattern that separates an application into three parts. The Model holds the data and business logic. The View handles the display and presentation of data to the user. The Controller sits in the middle and connects the model and view. It takes user input, updates the model, and tells the view to refresh.


How it Works

The Student class is the Model. It only stores student data like name, roll number, and grade. It does not know anything about how the data is displayed. The StudentView is responsible only for displaying the student information. It does not hold any data itself and does not modify the model. The StudentController holds references to both the model and the view. When data needs to be updated, the controller modifies the model. When the display needs to refresh, the controller calls updateView() which tells the view to display the current model state.


Why it is Used

Without MVC, one class would mix data storage, business logic, and display code all together. This makes the code hard to maintain and impossible to reuse. With MVC, each part has a clear responsibility. The view can be swapped out without touching the model. The model can be changed without rewriting the display code. The controller can coordinate different views for the same model, like showing student data in a table view or a card view.


Real World Use Cases

Most web frameworks use MVC. In Spring MVC, the Controller handles HTTP requests, the Model holds the data, and the View (JSP or Thymeleaf) renders the HTML. In Android, Activities often act as controllers. React and Angular use variations of this idea with components, state, and event handlers separating concerns.


Variations

MVP (Model-View-Presenter) is similar but the view has no direct access to the model at all, the presenter handles everything. MVVM (Model-View-ViewModel) is popular in Android and WPF where the ViewModel exposes data that the View automatically binds to.
