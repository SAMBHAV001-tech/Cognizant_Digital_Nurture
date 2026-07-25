# Exercise 1: Student Management Portal

This project demonstrates the fundamentals of component creation and nesting in ReactJS.

## Key Concepts Explained

### 1. What is a React Component?
A React component is a reusable, independent block of UI. Components let you split the user interface into independent, reusable pieces, and think about each piece in isolation. In this assignment, we created three functional components:
- **Home**: Renders the welcome message for the Home page.
- **About**: Renders the welcome message for the About page.
- **Contact**: Renders the welcome message for the Contact page.

### 2. What is Component Nesting?
Component nesting is the process of rendering one React component inside another. In our application, we nested the `Home`, `About`, and `Contact` components inside the main `App` component. This allows the application to display all three sections on the main page.

### 3. Folder Structure
- **src/Components/**: Stores our custom page components (`Home.js`, `About.js`, and `Contact.js`).
- **src/App.js**: The main root component where other components are imported and nested.
- **src/index.js**: The entry point that mounts our `App` component to the HTML DOM.
