import React, { useState } from 'react';

function SyntheticEvent() {
  const [message, setMessage] = useState('');

  function handleClick(e) {
    setMessage('I was clicked');
  }

  return (
    <div className="card">
      <h2>Part 3 – Synthetic Event</h2>
      <button id="btn-synthetic" onClick={handleClick}>Click on me</button>
      {message && <p className="msg">{message}</p>}
    </div>
  );
}

export default SyntheticEvent;
