import React, { useState } from 'react';

function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('INR');
  const [result, setResult] = useState('');

  function handleSubmit(e) {
    e.preventDefault();
    const inrToEuro = 0.011;
    const converted = (parseFloat(amount) * inrToEuro).toFixed(2);
    setResult(`${amount} ${currency} = ${converted} Euro`);
  }

  return (
    <div className="card">
      <h2>Part 4 – Currency Convertor</h2>
      <form onSubmit={handleSubmit} className="currency-form">
        <div className="form-row">
          <label htmlFor="amount">Amount:</label>
          <input
            id="amount"
            type="number"
            value={amount}
            onChange={e => setAmount(e.target.value)}
            placeholder="Enter amount in INR"
            required
          />
        </div>
        <div className="form-row">
          <label htmlFor="currency">Currency:</label>
          <input
            id="currency"
            type="text"
            value={currency}
            onChange={e => setCurrency(e.target.value)}
          />
        </div>
        <button id="btn-convert" type="submit">Submit</button>
      </form>
      {result && <p className="msg result">{result}</p>}
    </div>
  );
}

export default CurrencyConvertor;
