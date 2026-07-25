import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);
  const [message, setMessage] = useState('');

  function greet() {
    setMessage('Hello – You clicked the Increment button!');
  }

  function handleIncrement() {
    setCount(prev => prev + 1);
    greet();
  }

  function handleDecrement() {
    setCount(prev => prev - 1);
    setMessage('');
  }

  return (
    <div className="card">
      <h2>Part 1 – Counter</h2>
      <p className="counter-value">Count: <span>{count}</span></p>
      <div className="btn-row">
        <button id="btn-increment" onClick={handleIncrement}>Increment</button>
        <button id="btn-decrement" onClick={handleDecrement}>Decrement</button>
      </div>
      {message && <p className="msg">{message}</p>}
    </div>
  );
}

export default Counter;
