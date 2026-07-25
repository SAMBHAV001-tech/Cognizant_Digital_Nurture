# Exercise 1: React Event Handling

This project demonstrates four core React event handling patterns in a single application.

## Concepts Implemented

### 1. Button Click Events and Multiple Method Invocation
A single click event can invoke multiple functions. When the Increment button is clicked it both updates the state counter and calls a `greet()` function to display a message:
```javascript
function handleIncrement() {
  setCount(prev => prev + 1);
  greet();
}
```

### 2. Passing Arguments to Event Handlers
Arrow functions inside JSX allow passing custom arguments to handlers without calling them immediately:
```javascript
<button onClick={() => handleClick('Welcome')}>Say Welcome</button>
```

### 3. Synthetic Events
React wraps native browser events in a `SyntheticEvent` object so event behaviour is consistent across all browsers. The event object `e` is passed automatically to the handler:
```javascript
function handleClick(e) {
  setMessage('I was clicked');
}
```

### 4. CurrencyConvertor Component
`handleSubmit` uses `e.preventDefault()` to stop the form from refreshing the page, then converts Indian Rupees to Euro using the rate `1 INR = 0.011 EUR`:
```javascript
function handleSubmit(e) {
  e.preventDefault();
  const converted = (parseFloat(amount) * 0.011).toFixed(2);
  setResult(`${amount} INR = ${converted} Euro`);
}
```
