# Exercise 1: Create First React Application

This exercise covers the basics of creating and running a React application from scratch.

## What is React?

React is a popular JavaScript library developed by Meta (formerly Facebook) for building modern, interactive user interfaces, especially for single-page applications. It allows developers to build reusable UI components that manage their own state.

## Getting Started

### 1. Create a New React Project

To initialize a React project, we run the following command in the terminal:

```bash
npx create-react-app myfirstreact
```

This command automatically sets up a fully configured development environment with webpack, Babel, and other essential tools.

### 2. Project Structure

A standard React project contains:
- **public/**: Contains static assets and `index.html`, which serves as the entry point for the browser.
- **src/**: Contains the source code of the application.
  - `index.js`: The JavaScript entry point that renders the root React component.
  - `App.js`: The main application component.
- **package.json**: Lists project dependencies, scripts, and configurations.

### 3. Modifying the App Component

To display custom headings or elements, we modify the main component in `src/App.js`:

```javascript
import React from 'react';

function App() {
  return (
    <div>
      <h1>Welcome to the first session of React</h1>
    </div>
  );
}

export default App;
```

### 4. Running the Development Server

To start the application locally, navigate into the project directory and run:

```bash
cd myfirstreact
npm start
```

This starts the development server on `http://localhost:3000`, allowing you to see changes live in the browser.
