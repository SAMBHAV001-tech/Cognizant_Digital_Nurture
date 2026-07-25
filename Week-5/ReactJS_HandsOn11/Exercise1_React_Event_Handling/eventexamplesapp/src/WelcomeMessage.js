import React, { useState } from 'react';

function WelcomeMessage() {
  const [message, setMessage] = useState('');

  function handleClick(msg) {
    setMessage(msg);
  }

  return (
    <div className="card">
      <h2>Part 2 – Passing Arguments</h2>
      <button id="btn-welcome" onClick={() => handleClick('Welcome')}>Say Welcome</button>
      {message && <p className="msg">{message}</p>}
    </div>
  );
}

export default WelcomeMessage;
