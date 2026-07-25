import React from 'react';
import './App.css';
import Counter from './Counter';
import WelcomeMessage from './WelcomeMessage';
import SyntheticEvent from './SyntheticEvent';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  return (
    <div className="App">
      <h1 className="main-title">React Event Handling Examples</h1>
      <div className="sections">
        <Counter />
        <WelcomeMessage />
        <SyntheticEvent />
        <CurrencyConvertor />
      </div>
    </div>
  );
}

export default App;
