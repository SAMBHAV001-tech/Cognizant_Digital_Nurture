# Exercise 1: React Component Styling

This project demonstrates the use of CSS Modules for component scoping and dynamic styling based on component props in React.

## Key Concepts Explained

### 1. What are CSS Modules?
A CSS Module is a CSS file in which all class names and animation names are scoped locally by default. In React, a file named `MyComponent.module.css` indicates a CSS Module. During compilation, React's build tools automatically generate a unique hash for each class name. This guarantees that styles inside the module will not clash or conflict with styles in other components or global stylesheets.

### 2. Importing and Applying CSS Modules
To use a CSS Module in React, you import the styles object and reference the class names as properties:
```javascript
import styles from './CohortDetails.module.css';

// Applying style
<div className={styles.box}>
```

### 3. Conditional Styling in React
Conditional styling is the technique of dynamically changing the style of an element based on state, props, or logic. We use a ternary operator to decide which class from our CSS Module to apply to the cohort heading based on its status:
```javascript
const headingClass = props.cohort.currentStatus === 'Ongoing' 
  ? styles.ongoingHeading 
  : styles.otherHeading;
```
This applies the `ongoingHeading` style (color: green) for ongoing cohorts, and the `otherHeading` style (color: blue) for all other statuses.
