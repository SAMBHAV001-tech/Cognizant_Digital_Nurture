# Exercise 1: React Component Lifecycle

This project demonstrates the use of React component lifecycle methods in a class component (`Posts.js`) to fetch blog posts from a REST API and render them dynamically.

## Key Concepts Explained

### 1. Class Components in React
A class component is a more traditional way of defining components in React, declared as an ES6 class extending `React.Component`. Unlike functional components, class components have built-in state management and lifecycle methods.

### 2. What are Component Lifecycle Methods?
Lifecycle methods are special methods provided by React that run at specific points in a component's life (creation, mounting, updating, and unmounting). In this assignment, we use:

- **constructor()**: Initialized before the component is mounted. We define our initial state here (`{ posts: [], error: null }`) and bind methods if necessary.
- **componentDidMount()**: Runs immediately after the component is mounted (inserted into the tree). This is the perfect place to fetch data from a web API because the component is already on the screen. Here, we call `loadPosts()` which fetches data from:
  `https://jsonplaceholder.typicode.com/posts`
- **componentDidCatch()**: Works like a JavaScript `try-catch` block but for React components. It captures errors thrown during rendering, in lifecycle methods, or in constructors of the whole tree below them, allowing us to display a fallback error UI instead of crashing the app.

### 3. Fetching Data with Fetch API
The Fetch API is a modern, promise-based API for making HTTP requests in the browser. We perform a GET request and resolve it:
```javascript
fetch('https://jsonplaceholder.typicode.com/posts')
  .then(response => response.json())
  .then(data => this.setState({ posts: data }));
```
This updates the component state, which triggers a re-render to display the fetched blog posts.
