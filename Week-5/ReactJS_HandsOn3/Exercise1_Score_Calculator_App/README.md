# Exercise 1: Student Score Calculator

This project demonstrates how to create a functional component in React, pass data to it using props, perform calculations, and style the component using a custom stylesheet.

## Key Concepts Explained

### 1. What are React Props?
Props (short for properties) are read-only inputs passed from a parent component (like `App.js`) to a child component (like `CalculateScore.js`). They allow components to be dynamic and reusable by accepting custom data. In this assignment, we pass the following props to `CalculateScore`:
- **Name**: The student's name (string).
- **School**: The school name (string).
- **Total**: The total marks scored (number).
- **Goal**: The total number of subjects or divisor used for calculation (number).

### 2. Functional Components
A functional component is a simple JavaScript function that accepts props as an argument and returns React elements (JSX). We use a functional component named `CalculateScore` to render the student details card.

### 3. Calculating the Score
Inside the `CalculateScore` component, we calculate the average score dynamically using the expression:
```javascript
const average = (Total / Goal).toFixed(2);
```
This takes the `Total` marks and divides it by the `Goal` (e.g., number of subjects) to display a precise average.

### 4. Custom Styling (CSS)
To separate style from logic, we define all layouts, gradients, borders, and margins in a dedicated stylesheet `mystyle.css` inside the `Stylesheets/` folder and import it in our component:
```javascript
import '../Stylesheets/mystyle.css';
```
