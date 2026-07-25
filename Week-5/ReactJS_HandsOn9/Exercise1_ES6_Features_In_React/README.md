# Exercise 1: ES6 Features in React

This project demonstrates the implementation and utilization of various modern ECMAScript 6 (ES6) features inside a React application.

## ES6 Features Utilized

### 1. Arrow Functions
Arrow functions provide a clean, concise syntax for writing function expressions. In React, they are extensively used inside mapping or filtering loops:
```javascript
const playersBelow70 = players.filter(player => player.score < 70);
```

### 2. ES6 Map Method
The `map()` method creates a new array populated with the results of calling a provided function on every element in the calling array. In React, `map()` is the standard way to render arrays of data into JSX elements:
```javascript
{players.map((player, index) => (
  <li key={index}>{player.name}</li>
))}
```

### 3. Array Filtering
The `filter()` method creates a shallow copy of a portion of a given array, filtered down to just the elements from the given array that pass the test implemented by the provided function. In this app, we use it to separate players with scores below 70.

### 4. Array Destructuring
Destructuring assignment is an ES6 syntax that makes it possible to unpack values from arrays, or properties from objects, into distinct variables:
```javascript
const [player1, player2, player3, ...rest] = indianTeam;
```
This is used in the Indian players component to easily extract and display players in odd and even positions.

### 5. Spread Operator
The spread operator (`...`) allows an iterable (like an array) to be expanded in places where zero or more arguments or elements are expected. We use it to merge the `T20Players` and `RanjiTrophyPlayers` arrays:
```javascript
const mergedPlayers = [...T20Players, ...RanjiTrophyPlayers];
```

### 6. Conditional Rendering
Conditional rendering in React works the same way conditions work in JavaScript. We use a ternary operator to render components dynamically based on a boolean `flag` variable:
```javascript
{flag ? <ListOfPlayers /> : <IndianPlayers />}
```
