import React from 'react';
import ListOfPlayers from './Components/ListOfPlayers';
import IndianPlayers from './Components/IndianPlayers';
import './App.css';

function App() {
  const flag = false;

  return (
    <div className="App">
      <h1 className="main-title">Cricket App</h1>
      <div className="flag-indicator">
        Flag status: <strong>{flag.toString()}</strong>
      </div>
      {flag ? <ListOfPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;

